import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

public class Actor {
    UUID ID;
    String name;
    String firstname;
    String yearOfBirth;

    public Actor(JSONObject actor){
        actor.forEach((key,value) -> {
            switch (key.toString()){
                case "id":
                    ID = UUID.fromString(value.toString());
                case "name":
                    name = value.toString();
                case "firstname":
                    firstname = value.toString();
                case "age":
                    yearOfBirth = value.toString();
            }
        });
    }

    public void saveToJson(){
        String path = "actors.json";

        JSONArray actorList = new JSONArray();


        actorList = JSONFileManager.readJSONArrayFromFile(path);

        HashMap<String,String> actorDetailsHashMap = new HashMap<String,String>();
        actorDetailsHashMap.put("id", ID.toString());
        actorDetailsHashMap.put("name", name);
        actorDetailsHashMap.put("firstname", firstname);
        actorDetailsHashMap.put("yearOfBirth", yearOfBirth);


        JSONObject userDetails = new JSONObject(actorDetailsHashMap);
        actorList.add(userDetails);

        JSONFileManager.writeJSONArrayToFile(actorList, path);
    }
    
}
