package main.java.ui;

import main.java.typedefinitions.Actor;
import main.java.typedefinitions.Film;
import main.java.typedefinitions.Rating;

import java.util.ArrayList;

public class Printer {
    //print single objects
    public static void printFilm(Film film){
        System.out.println("Name: " + film.getName());
        System.out.println("Release Date: " + film.getReleasadate());
        System.out.println("Description: " + film.getDescription());
        System.out.print("Actors: " );

        Printer.printObjectNames(film.getActors(), false);

        System.out.println("Average main.java.typedefinitions.Rating: " + film.getAverageRating());
    }

    public static void printRating(Rating rating){
        System.out.println("Stars: " + rating.getStars());
        if(rating.getText() != ""){
            System.out.println(rating.getText());
        }
    }

    public static void printActor(Actor actor){
        System.out.println(actor.getFirstname() + " " + actor.getName());
        System.out.println("Year of Birth " + actor.getYearOfBirth());
        printObjectNames(Homepage.getFilmsWithActor(actor), false);
    }

    //list Objects
    public static <T> void printObjects(ArrayList<T> typeDefinitions){
        typeDefinitions.forEach(td -> {
            if(td instanceof Rating){
                System.out.println("--------------------");
                printRating((Rating)td);
            }else if(td instanceof Actor){
                System.out.println("--------------------");
                printActor((Actor)td);
            }else if(td instanceof Film){
                System.out.println("--------------------");
                printFilm((Film)td);
            }
        });
    }

    public static <T> void printObjectNames(ArrayList<T> typeDefinitions, Boolean inList){
        if(inList){
            for(int i = 0; i < typeDefinitions.size(); i++){
                if(typeDefinitions.get(i) instanceof Actor actor){
                    System.out.println(i + ": " + actor.getFirstname() + " " + actor.getName());
                }else if(typeDefinitions.get(i) instanceof Film film){
                    System.out.println(i + ": " + film.getName());
                }
            }
        }else{
            String output = "";
            for(T td : typeDefinitions){
                if(td instanceof Actor actor){
                    output += ", " + actor.getFirstname() + " " + actor.getName();
                }else if(td instanceof Film film){
                    output += ", " + film.getName();
                }
            }

            System.out.println(output.substring(2));
        }

    }
}
