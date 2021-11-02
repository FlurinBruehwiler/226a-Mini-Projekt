package main.java.typedefinitions;

import main.java.JSONFileManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.UUID;

public class Rating extends TypeDefinition {
    private int stars;
    private String text;

    public int getStars(){
        return stars;
    }

    public String getText(){
        return text;
    }

    public Rating(JSONObject rating){
        rating.forEach((key,value) -> {
            switch (key.toString()){
                case "id":
                    ID = UUID.fromString(value.toString());
                    break;
                case "stars":
                    stars = Integer.parseInt(value.toString());
                    break;
                case "text":
                    text = value.toString();
                    break;
            }
        });
    }

    public Rating(int _stars, String _text){
        ID = UUID.randomUUID();
        stars = _stars;
        text = _text;
    }

    public void saveToJson(){
        String path = "ratings.json";

        JSONArray ratingList = new JSONArray();

        ratingList = JSONFileManager.readJSONArrayFromFile(path);

        ratingList = removeTdFromList(ratingList, ID);

        HashMap<String,String> ratingDetailsHashMap = new HashMap<String,String>();
        ratingDetailsHashMap.put("id", ID.toString());
        ratingDetailsHashMap.put("stars", String.valueOf(stars));
        ratingDetailsHashMap.put("text", text);

        ratingList.add(new JSONObject(ratingDetailsHashMap));

        JSONFileManager.writeJSONArrayToFile(ratingList, path);
    }
}