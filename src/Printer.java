import java.util.ArrayList;

public class Printer {
    //print single objects
    public static void printFilm(Film film){
        System.out.println("Name: " + film.name);
        System.out.println("Release Date: " + film.releasadate);
        System.out.println("Description: " + film.description);
        System.out.print("Actors: " );

        Printer.printObjectNames(film.actors, false);

        System.out.println("Average Rating: " + film.getAverageRating());
    }

    public static void printRating(Rating rating){
        System.out.println("Stars: " + rating.stars);
        if(rating.text != ""){
            System.out.println(rating.text);
        }
    }

    public static void printActor(Actor actor){
        System.out.println(actor.firstname + " " + actor.name);
        System.out.println("Year of Birth " + actor.yearOfBirth);
        printObjectNames(Homepage.getFilmsWithActor(actor), false);
    }

    //list Objects
    public static <T> void printObjects(ArrayList<T> typeDefinitions){
        typeDefinitions.forEach(td -> {
            if(td instanceof Rating){
                printRating((Rating)td);
                System.out.println("--------------------");
            }else if(td instanceof Actor){
                printActor((Actor)td);
                System.out.println("--------------------");
            }else if(td instanceof Film){
                printFilm((Film)td);
                System.out.println("--------------------");
            }
        });
    }

    public static <T> void printObjectNames(ArrayList<T> typeDefinitions, Boolean inList){
        if(inList){
            for(int i = 0; i < typeDefinitions.size(); i++){
                if(typeDefinitions.get(i) instanceof Actor actor){
                    System.out.println(i + ": " + actor.firstname + " " + actor.name);
                }else if(typeDefinitions.get(i) instanceof Film film){
                    System.out.println(i + ": " + film.name);
                }
            }
        }else{
            String output = "";
            for(T td : typeDefinitions){
                if(td instanceof Actor actor){
                    output += ", " + actor.firstname + " " + actor.name;
                }else if(td instanceof Film film){
                    output += ", " + film.name;
                }
            }

            System.out.println(output.substring(2));
        }

    }
}
