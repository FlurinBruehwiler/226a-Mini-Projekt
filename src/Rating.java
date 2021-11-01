import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
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

    public Rating(UUID _ID, int _stars, String _text){
        ID = _ID ;
        stars = _stars;
        text = _text;
    }

    public void saveToJson(){
        String path = "ratings.json";

        JSONArray ratingList = new JSONArray();

        ratingList = JSONFileManager.readJSONArrayFromFile(path);

        HashMap<String,String> ratingDetailsHashMap = new HashMap<String,String>();
        ratingDetailsHashMap.put("id", ID.toString());
        ratingDetailsHashMap.put("stars", String.valueOf(stars));
        ratingDetailsHashMap.put("text", text);

        JSONObject userDetails = new JSONObject(ratingDetailsHashMap);
        ratingList.add(userDetails);

        JSONFileManager.writeJSONArrayToFile(ratingList, path);
    }
}
