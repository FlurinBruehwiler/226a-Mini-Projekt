import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException, ParseException {
        UserManager.updateUsers();

        Register reg = new Register();
        var temp = reg.getInput();
        reg.writeInput(temp);
        Login log = new Login();
        log.login();
    }
}
