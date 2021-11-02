package main.java.typedefinitions;

import main.java.JSONFileManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.UUID;

public class Actor extends TypeDefinition {
    private String name;
    private String firstname;
    private String yearOfBirth;

    public String getName(){
        return name;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getYearOfBirth(){
        return yearOfBirth;
    }

    public Actor(JSONObject actor){
        actor.forEach((key,value) -> {
            switch (key.toString()){
                case "id":
                    ID = UUID.fromString(value.toString());
                    break;
                case "name":
                    name = value.toString();
                    break;
                case "firstname":
                    firstname = value.toString();
                    break;
                case "yearOfBirth":
                    yearOfBirth = value.toString();
                    break;
            }
        });
    }

    public Actor(String _name, String _firstname, String _yearOfBirth){
        ID = UUID.randomUUID();
        name = _name ;
        firstname = _firstname;
        yearOfBirth = _yearOfBirth;
    }

    public void saveToJson(){
        String path = "actors.json";

        JSONArray actorList = new JSONArray();


        actorList = JSONFileManager.readJSONArrayFromFile(path);

        actorList = removeTdFromList(actorList, ID);

        HashMap<String,String> actorDetailsHashMap = new HashMap<String,String>();
        actorDetailsHashMap.put("id", ID.toString());
        actorDetailsHashMap.put("name", name);
        actorDetailsHashMap.put("firstname", firstname);
        actorDetailsHashMap.put("yearOfBirth", yearOfBirth);

        actorList.add(new JSONObject(actorDetailsHashMap));

        JSONFileManager.writeJSONArrayToFile(actorList, path);
    }
    
}
