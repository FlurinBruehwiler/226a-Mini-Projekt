import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Homepage {
    public static void showPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Films");

        while(true){
            //Print all Films
            Printer.printObjectNames(Storage.films, true);

            //Choose Film
            String filmInput = scanner.nextLine();
            Printer.printFilm(Storage.films.get(Integer.parseInt(filmInput)));

            System.out.println("What do you want to do?");
            System.out.println("0: Detailed actor list");
            System.out.println("1: List all Ratings");
            System.out.println("2: Create review");
            System.out.println("------------------------");
            System.out.println("F: Go back to film list");

            String filmMenu = scanner.nextLine();

            switch (filmMenu.toLowerCase(Locale.ROOT)){
                case "0":
                    Printer.printObjects(Storage.films.get(Integer.parseInt(filmInput)).actors);
                    break;
                case "1":
                    Printer.printObjects(Storage.films.get(Integer.parseInt(filmInput)).ratings);
                    break;
                case "2":
                    break;
                case "m":
                    break;
            }
        }
    }

    public static ArrayList<Film> getFilmsWithActor(Actor actor){
        ArrayList<Film> films = new ArrayList<>();
        for(Film film : Storage.films){
            if(film.actors.contains(actor)) {
                films.add(film);
            }
        }
        return films;
    }
}
