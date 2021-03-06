package main.java.typedefinitions;

import main.java.JSONFileManager;
import main.java.ObjCache;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Film extends TypeDefinition {
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

    /**
     * Constructor for the case that you want to convert a JSONObject to a film
     * @param film
     */
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
                        Actor foundActor = ObjCache.getActorbyId(UUID.fromString(actorId));
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
                        Rating foundRating = ObjCache.getRatingbyId(UUID.fromString(ratingId));
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

    /**
     * Constructor for the case that you want to create a film from scratch
     * @param _name
     * @param _releaseDate
     * @param _description
     * @param _actors
     * @param _ratings
     */
    public Film(String _name, String _releaseDate, String _description, ArrayList<Actor> _actors, ArrayList<Rating> _ratings){
        ID = UUID.randomUUID();
        name = _name ;
        releasedate = _releaseDate;
        description = _description;
        actors = _actors;
        ratings = _ratings;
    }

    /**
     * Gets the average rating of the film
     * @return
     */
    public float getAverageRating(){
        int sum = 0;
        for(Rating rating: ratings){
            sum += rating.getStars();
        }

        return (float)sum / ratings.size();
    }

    /**
     * Description: Saves to the respective JSON file
     */
    public void saveToJson(){
        String path = "JSONStorage/films.json";

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

        filmList.add(new JSONObject(filmDetailsHashMap));

        JSONFileManager.writeJSONArrayToFile(filmList, path);
    }
}
