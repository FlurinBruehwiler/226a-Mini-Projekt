package main.java.ui;

import main.java.ObjCache;
import main.java.ValidateInput;
import main.java.typedefinitions.Actor;
import main.java.typedefinitions.Film;
import main.java.typedefinitions.Rating;

import java.util.*;

public class Homepage {

    public static void showPage() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("Films");

            //Print all Films
            Printer.printObjectNames(ObjCache.films, true);

            //Choose main.java.typedefinitions.Film
            int filmInput = ValidateInput.getFilmChooserInput();

            if (filmInput == -1) {
                System.exit(0);
            }

            Film film = ObjCache.films.get(filmInput);

            System.out.println("----------------------------");
            System.out.println("main.java.typedefinitions.Film");
            Printer.printFilm(film);

            System.out.println("----------------------------");
            System.out.println("What do you want to do?");
            System.out.println("0: Detailed actor list");
            System.out.println("1: List all ratings");
            System.out.println("2: Create rating");
            System.out.println("3: Go back to film list");

            int filmMenu = ValidateInput.getFilmMenuInput();

            switch (filmMenu) {
                case 0:
                    Printer.printObjects(film.getActors());
                    break;
                case 1:
                    Printer.printObjects(film.getRatings());
                    break;
                case 2:
                    createRating(film);
                    break;
                case 3:
                    break;
            }
        }
    }

    public static void createRating(Film film) {

        System.out.println("--------------------------");
        System.out.println("Create rating");
        int stars = ValidateInput.getStarsInput();

        System.out.print("Comment (optional): ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Rating newRating = new Rating(stars, text);
        ObjCache.ratings.add(newRating);
        film.getRatings().add(newRating);
        newRating.saveToJson();
        film.saveToJson();
    }

    public static ArrayList<Film> getFilmsWithActor(Actor actor) {
        ArrayList<Film> films = new ArrayList<>();
        for (Film film : ObjCache.films) {
            if (film.getActors().contains(actor)) {
                films.add(film);
            }
        }
        return films;
    }
}
