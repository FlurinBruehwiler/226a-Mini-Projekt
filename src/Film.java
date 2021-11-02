import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Film extends TypeDefinition{
    private String name;
    private String releasedate;
    private String description;
    private ArrayList<Actor> actors = new ArrayList<>();
    private ArrayList<Rating> ratings =  new ArrayList<>();

    public String getName(){
        return name;
    }

    public String getReleasadate(){
        return releasedate;
    }

    public String getDescription(){
        return description;
    }

    public ArrayList<Actor> getActors(){
        return actors;
    }

    public ArrayList<Rating> getRatings(){
        return ratings;
    }

    public Film(JSONObject film){
        film.forEach((k,v) -> {
            switch (k.toString()){
                case "id":
                    ID = UUID.fromString(v.toString());
                    break;
                case "name":
                    name = v.toString();
                    break;
                case "releasedate":
                    releasedate = v.toString();
                    break;
                case "description":
                    description = v.toString();
                    break;
                case "actors":
                    String[] actorsID = v.toString().split(",");
                    for (String actorId:actorsID) {
                        Actor foundActor = Storage.getActorbyId(UUID.fromString(actorId));
                        if(foundActor != null){
                            actors.add(foundActor);
                        }else{
                            System.out.println("Actor not found with UUID: " + actorId);
                        }
                    }
                    break;
                case "ratings":
                    String[] ratingsID = v.toString().split(",");
                    for (String ratingId:ratingsID) {
                        Rating foundRating = Storage.getRatingbyId(UUID.fromString(ratingId));
                        if(foundRating != null){
                            ratings.add(foundRating);
                        } else{
                            System.out.println("Rating not found with UUID: " + ratingId);
                        }
                    }
                    break;
            }
        });
    }

    public float getAverageRating(){
        int sum = 0;
        for(Rating rating: ratings){
            sum += rating.getStars();
        }
        return (float)sum / ratings.size();
    }

    public Film(UUID _ID, String _name, String _releaseDate, String _description, ArrayList<Actor> _actors, ArrayList<Rating> _ratings){
        ID = _ID ;
        name = _name ;
        releasedate = _releaseDate;
        description = _description;
        actors = _actors;
        ratings = _ratings;
    }

    public void saveToJson(){
        String path = "films.json";

        JSONArray filmList = new JSONArray();

        filmList = JSONFileManager.readJSONArrayFromFile(path);

        filmList = removeTdFromList(filmList, ID);

        HashMap<String,String> filmDetailsHashMap = new HashMap<String,String>();
        filmDetailsHashMap.put("id", ID.toString());
        filmDetailsHashMap.put("name", name);
        filmDetailsHashMap.put("releasedate", releasedate);
        filmDetailsHashMap.put("description", description);

        String UUIDsOfActors = "";
        for (Actor actor : actors) {
            UUIDsOfActors += "," + actor.ID;
        }
        filmDetailsHashMap.put("actors", UUIDsOfActors.substring(1));

        String UUIDsOfRatings = "";
        for (Rating rating : ratings) {
            UUIDsOfRatings += "," + rating.ID;
        }
        filmDetailsHashMap.put("ratings", UUIDsOfRatings.substring(1));

        JSONObject userDetails = new JSONObject(filmDetailsHashMap);
        filmList.add(userDetails);

        JSONFileManager.writeJSONArrayToFile(filmList, path);
    }
}
