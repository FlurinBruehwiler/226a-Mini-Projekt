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

            }

            System.out.println(k.toString() + ":" + v.toString());
        });
    }

    public Film(String _Name, String _Release, String _Description, ArrayList<Actor> _actors, ArrayList<Rating> _ratings){

    }

    public void saveToJson(){
        String path = "film.json";

        JSONArray userList = new JSONArray();

        userList = JSONFileManager.readJSONArrayFromFile(path);

        HashMap<String,String> userDetailsHashMap = new HashMap<String,String>();
        userDetailsHashMap.put("name", Name);
        userDetailsHashMap.put("releasedate", Releasadate);
        userDetailsHashMap.put("description", Description);

        String UUIDsOfActors = "";
        for (Actor actor : actors) {
            UUIDsOfActors += "," + actor.ID;
        }
        userDetailsHashMap.put("actors", UUIDsOfActors);

        String UUIDsOfRatings = "";
        for (Rating rating : ratings) {
            UUIDsOfRatings += "," + rating.ID;
        }
        userDetailsHashMap.put("ratings", UUIDsOfRatings);

        JSONObject userDetails = new JSONObject(userDetailsHashMap);
        userList.add(userDetails);

        JSONFileManager.writeJSONArrayToFile(userList, path);
    }
}
