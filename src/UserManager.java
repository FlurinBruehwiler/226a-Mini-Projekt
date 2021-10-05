import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class UserManager {
    public static ArrayList<User> users = new ArrayList();

    public static void updateUsers(){
        JSONArray userList = JSONFileManager.readJSONArrayFromFile(PathManager.UsersPath);

        for (Object userObject : userList) {
            JSONObject user = (JSONObject) userObject;
            String username = (String) user.get("username");
            String password = (String) user.get("password");

            users.add(new User(username, password));
        }
    }
}
