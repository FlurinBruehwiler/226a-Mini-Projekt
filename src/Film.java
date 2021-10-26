import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Film {
    
    String Name;
    String Releasadate;
    String Description;
    ArrayList<Actor> actors;
    float avgrating;
    ArrayList<Rating> ratings;


    public Film(String _Name, String _Release, String _Description, ArrayList<Actor> _actors, ArrayList<Rating> _ratings){
        Name = _Name;
        Releasadate = _Release;
        Description = _Description;
        actors = _actors;
        ratings = _ratings;

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
