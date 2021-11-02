import java.util.*;

public class Homepage {
    
    public static void showPage() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-------------------------");
            System.out.println("Films");

            //Print all Films
            Printer.printObjectNames(Storage.films, true);

            //Choose Film
            int filmInput = 0;
            while (true) {
                System.out.print("Film to inspect (-1 to quit): ");
                Scanner filmScanner = new Scanner(System.in);
                try {
                    filmInput = filmScanner.nextInt();
                    if (filmInput > Storage.films.size() - 1) {
                        throw new InputMismatchException();
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number that corresponds to a film");
                }
            }

            if (filmInput == -1) {
                System.exit(0);
            }

            Film film = Storage.films.get(filmInput);

            System.out.println("----------------------------");
            System.out.println("Film");
            Printer.printFilm(film);

            System.out.println("----------------------------");
            System.out.println("What do you want to do?");
            System.out.println("0: Detailed actor list");
            System.out.println("1: List all ratings");
            System.out.println("2: Create rating");
            System.out.println("3: Go back to film list");

            int filmMenu = 0;
            while (true) {
                Scanner filmScanner = new Scanner(System.in);
                try {
                    filmMenu = filmScanner.nextInt();
                    if (filmMenu > 3) {
                        throw new InputMismatchException();
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Please enter number");
                }
            }

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
        int stars = 0;
        while (true) {
            System.out.print("Stars: ");
            Scanner scanner = new Scanner(System.in);
            try {
                stars = scanner.nextInt();
                if (stars < 1 || stars > 5) {
                    throw new InputMismatchException();
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 0 and 5");
            }
        }

        System.out.print("Comment (optional): ");
        Scanner scanner2 = new Scanner(System.in);
        String text = scanner2.nextLine();
        Rating newRating = new Rating(stars, text);
        Storage.ratings.add(newRating);
        film.getRatings().add(newRating);
        newRating.saveToJson();
        film.saveToJson();
    }

    public static ArrayList<Film> getFilmsWithActor(Actor actor) {
        ArrayList<Film> films = new ArrayList<>();
        for (Film film : Storage.films) {
            if (film.getActors().contains(actor)) {
                films.add(film);
            }
        }
        return films;
    }
}
