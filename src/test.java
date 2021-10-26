import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException, ParseException {
        UserManager.updateUsers();
        Actor actor1 = new Actor();
        Actor actor2 = new Actor();
        Actor actor3 = new Actor();
        Rating rating1 = new Rating();
        Rating rating2 = new Rating();

        ArrayList<Actor> actors = new ArrayList<>(Arrays.asList(actor1, actor2, actor3));
        ArrayList<Rating> ratings = new ArrayList<>(Arrays.asList(rating1, rating2));
        
        Film film = new Film("James Bond", "2021", "Bond enough said", actors, ratings);
        film.saveToJson();



      /*  Register reg = new Register();
        var temp = reg.getInput();
        reg.writeInput(temp);

        Login log = new Login();
        log.login();
        */

    }
}
