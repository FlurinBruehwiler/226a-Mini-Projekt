package main.java.typedefinitions;

import main.java.JSONFileManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.UUID;

public class User extends TypeDefinition {
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    /**
     * Constructor for the case that you want to convert a JSONObject to a user
     * @param user
     */
    public User(JSONObject user){
        user.forEach((key,value) -> {
            switch (key.toString()){
                case "id":
                    ID = UUID.fromString(value.toString());
                    break;
                case "username":
                    username = value.toString();
                    break;
                case "password":
                    password = value.toString();
                    break;
            }
        });
    }

    /**
     * Constructor for the case that you want to create a user from scratch (Register)
     * @param _username
     * @param _password
     */
    public User(String _username, String _password){
        ID = UUID.randomUUID();
        username = _username;
        password = _password;
    }

    /**
     * Description: Saves to the respective JSON file
     */
    public void saveToJson(){
        String path = "JSONStorage/users.json";

        JSONArray userList = new JSONArray();

        userList = JSONFileManager.readJSONArrayFromFile(path);

        userList = removeTdFromList(userList, ID);

        HashMap<String,String> ratingDetailsHashMap = new HashMap<String,String>();
        ratingDetailsHashMap.put("id", ID.toString());
        ratingDetailsHashMap.put("username", username);
        ratingDetailsHashMap.put("password", password);

        userList.add(new JSONObject(ratingDetailsHashMap));

        JSONFileManager.writeJSONArrayToFile(userList, path);
    }
}
