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

    /**
     * Constructor for the case that you want to convert a JSONObject to a rating
     * @param rating
     */
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

    /**
     * Constructor for the case that you want to create a rating from scratch (Create Rating Menu)
     * @param _stars
     * @param _text
     */
    public Rating(int _stars, String _text){
        ID = UUID.randomUUID();
        stars = _stars;
        text = _text;
    }

    /**
     * Description: Saves to the respective JSON file
     */
    public void saveToJson(){
        String path = "JSONStorage/ratings.json";

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
