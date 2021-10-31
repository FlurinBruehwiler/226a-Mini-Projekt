import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Homepage {
    public void showPage() {
        System.out.println("What do you want to do?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. List Films");
        System.out.println("2. Search Films");
        String input = scanner.nextLine();

        while(true){
            switch (input) {
                case "1":
                    listFilms();
                    String filmInput = scanner.nextLine();
                    if(filmInput.toLowerCase(Locale.ROOT).equals("m")){
                        break;
                    }
                    showFilm(Storage.films.get(Integer.parseInt(filmInput)));
                    String filmMenu = scanner.nextLine();
                    switch (filmMenu){
                        case "0":
                            listActors(Storage.films.get(Integer.parseInt(filmInput)).actors);
                            break;
                        case "1":
                            listRatings(Storage.films.get(Integer.parseInt(filmInput)).ratings);
                            break;
                    }
                    if(filmMenu.toLowerCase(Locale.ROOT).equals("m")){
                        break;
                    }

                    break;
                case "2":

                    break;

                default:
                    break;
            }
        }


    }

    public void listFilms(){
        for(int i = 0; i < Storage.films.size(); i++){
            System.out.println(i + ": " + Storage.films.get(i).name);
        }

        System.out.println("M: To Homepage");
    }

    public void listActors(ArrayList<Actor> actors){
        actors.forEach(actor -> {
            showActor(actor);
        });
    }

    public void listRatings(ArrayList<Rating> ratings){
        ratings.forEach(rating -> {
            showRating(rating);
        });
    }

    public void showActor(Actor actor){
        System.out.println(actor.firstname + " " + actor.name);
        System.out.println("Year of Birth" + actor.yearOfBirth);
        for(Film film : getFilmsWithActor(actor)){
            System.out.println(film.name);
        }
    }

    public void showRating(Rating rating){

    }

    public ArrayList<Film> getFilmsWithActor(Actor actor){
        ArrayList<Film> films = new ArrayList<>();
        for(Film film : Storage.films){
            if(film.actors.contains(actor)) {
                films.add(film);
            }
        }
        return films;
    }

    public void showFilm(Film film){
        System.out.println("Name: " + film.name);
        System.out.println("Release Date: " + film.releasadate);
        System.out.println("Description: " + film.description);
        System.out.print("Actors: " );

        listNameOfActors(film.actors);

        System.out.println("Average Rating:" + film.getAverageRating());

        System.out.println("Menu");
        System.out.println("0: Show Actors");
        System.out.println("1: Show Ratings");

        System.out.println("M: To Homepage");
    }

    public void listNameOfActors(ArrayList<Actor> actors){
        String nameOfActors = "";
        for(Actor actor : actors){
            nameOfActors += ", " + actor.firstname + " " + actor.name;
        }

        System.out.println(nameOfActors.substring(2));
    }


}
