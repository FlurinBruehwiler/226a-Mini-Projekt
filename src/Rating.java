import org.json.simple.JSONObject;

import java.util.UUID;

import java.util.UUID;

public class Rating{
    UUID ID;
    public Rating(JSONObject rating){
        ID = UUID.randomUUID();
    }
}
