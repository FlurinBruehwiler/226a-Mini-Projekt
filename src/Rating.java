import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.UUID;

import java.util.UUID;

public class Rating{
    UUID ID;
    int stars;
    String text;


    public Rating(JSONObject rating){
        rating.forEach((key,value) -> {
            switch (key.toString()){
                case "id":
                    ID = UUID.fromString(value.toString());
                case "stars":
                    stars = Integer.parseInt(value.toString());
                case "text":
                    text = value.toString();
            }
        });
    }

    public void saveToJson(){
        String path = "ratings.json";

        JSONArray ratingList = new JSONArray();

        ratingList = JSONFileManager.readJSONArrayFromFile(path);

        HashMap<String,String> ratingDetailsHashMap = new HashMap<String,String>();
        ratingDetailsHashMap.put("id", ID.toString());
        ratingDetailsHashMap.put("starts", String.valueOf(stars));
        ratingDetailsHashMap.put("text", text);

        JSONObject userDetails = new JSONObject(ratingDetailsHashMap);
        ratingList.add(userDetails);

        JSONFileManager.writeJSONArrayToFile(ratingList, path);
    }
}
