import org.json.simple.JSONObject;

import java.net.URL;
import java.util.UUID;

public class Actor {
    UUID ID;

    public Actor(JSONObject actor){
        ID = UUID.randomUUID();
    }
    
}
