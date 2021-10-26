import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Film {
    
    String name;
    String releasadate;
    String description;
    ArrayList<Actor> actors;
    ArrayList<Rating> ratings;

    float avgrating;


    public Film(JSONObject film){
        film.forEach((k,v) -> {
            switch (k.toString()){
                case "name":
                    name = v.toString();
                case "releasedate":
                    releasadate = v.toString();
                case "description":
                    description = v.toString();
                case "actors":
                    String[] actorsID = v.toString().split(",");
                    for (String actorId:actorsID) {
                        Actor foundActor = Storage.getActorbyId(UUID.fromString(actorId));
                        if(foundActor != null){
                            actors.add(foundActor);
                        }
                    }
                case "ratings":
                    String[] ratingsID = v.toString().split(",");
                    for (String ratingId:ratingsID) {
                        Rating foundRating = Storage.getRatingbyId(UUID.fromString(ratingId));
                        if(foundRating != null){
                            ratings.add(foundRating);
                        }
                    }
            }
        });
    }

    public Film(String _name, String _releaseDate, String _description, ArrayList<Actor> _actors, ArrayList<Rating> _ratings){
        name = _name ;
        releasadate = _releaseDate;
        description = _description;
        actors = _actors;
        ratings = _ratings;
    }

    public void saveToJson(){
        String path = "films.json";

        JSONArray filmList = new JSONArray();

        filmList = JSONFileManager.readJSONArrayFromFile(path);

        HashMap<String,String> filmDetailsHashMap = new HashMap<String,String>();
        filmDetailsHashMap.put("name", name);
        filmDetailsHashMap.put("releasedate", releasadate);
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
