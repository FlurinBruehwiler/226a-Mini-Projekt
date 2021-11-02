import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.UUID;

public class TypeDefinition {
    public UUID ID;

    public JSONArray removeTdFromList(JSONArray tdList, UUID id){
        JSONArray output = new JSONArray();
        tdList.forEach(item -> {
            ((JSONObject)item).forEach((k,v) -> {
                if(k.toString().equals("id")){
                    if(!(v.toString().equals(id.toString()))){
                        output.add(item);
                    }
                }
            });
        });
        return output;
    }
}
