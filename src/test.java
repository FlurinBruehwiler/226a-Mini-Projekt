import org.json.simple.parser.ParseException;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException, ParseException {
        UserManager.updateUsers();

        /*
        Rating rating1 = new Rating(UUID.randomUUID(), 4, "Ein sehr guter Film, welcher mich satifiziert hat");
        rating1.saveToJson();
        Rating rating2 = new Rating(UUID.randomUUID(), 1,"James Bond, schlecht wie immer");
        rating2.saveToJson();

        Actor actor1 = new Actor(UUID.randomUUID(), "Craig", "Daniel", "1968");
        actor1.saveToJson();
        Actor actor2 = new Actor(UUID.randomUUID(), "Seydoux", "Lea", "1985");
        actor2.saveToJson();

        Film film1 = new Film("Bond", "13.09.2004", "very gut", new ArrayList<>(Arrays.asList(actor1, actor2)), new ArrayList<>(Arrays.asList(rating1, rating2)));
        Film film2 = new Film("The French Dispatch", "13.09.2004", "very gut", new ArrayList<>(Arrays.asList(actor1, actor2)), new ArrayList<>(Arrays.asList(rating1, rating2)));
        film1.saveToJson();
        film2.saveToJson();
        */



        Storage.ReadAllObjects();


        Homepage.showPage();

      /*  Register reg = new Register();
        var temp = reg.getInput();
        reg.writeInput(temp);

        Login log = new Login();
        log.login();
        */

    }
}
