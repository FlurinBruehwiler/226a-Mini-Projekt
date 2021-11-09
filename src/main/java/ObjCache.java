package main.java;

import main.java.typedefinitions.Actor;
import main.java.typedefinitions.Film;
import main.java.typedefinitions.Rating;
import main.java.typedefinitions.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.UUID;

public class ObjCache {
    public static ArrayList<Actor> actors = new ArrayList<>();
    public static ArrayList<Rating> ratings = new ArrayList<>();
    public static ArrayList<Film> films = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

    /**
     * Description: Reads all objects from the JSON files and creates the objects
     */
    public static void readAllObjects(){
        readAllActors();
        readAllRatings();
        ReadAllFilms();
        readAllUsers();
    }

    /**
     *  Description: Reads all users from the JSON file and creates the users
     */
    public static void readAllUsers(){
        JSONArray userList = JSONFileManager.readJSONArrayFromFile("JSONStorage/users.json");

        userList.forEach(item -> {
            JSONObject JSONUser = (JSONObject) item;
            User newUser = new User(JSONUser);
            users.add(newUser);
        });
    }

    /**
     *  Description: Reads all actors from the JSON file and creates the actors
     */
    public static void readAllActors(){
        JSONArray actorList = JSONFileManager.readJSONArrayFromFile("JSONStorage/actors.json");

        actorList.forEach(item -> {
            JSONObject JSONActor = (JSONObject) item;
            Actor newActor = new Actor(JSONActor);
            actors.add(newActor);
        });
    }

    /**
     *  Description: Reads all ratings from the JSON file and creates the ratings
     */
    public static void readAllRatings(){
        JSONArray ratingList = JSONFileManager.readJSONArrayFromFile("JSONStorage/ratings.json");

        ratingList.forEach(item -> {
            JSONObject JSONRating = (JSONObject) item;
            Rating newRating = new Rating(JSONRating);
            ratings.add(newRating);
        });
    }

    /**
     *  Description: Reads all films from the JSON file and creates the films
     */
    public static void ReadAllFilms(){
        JSONArray filmList = JSONFileManager.readJSONArrayFromFile("JSONStorage/films.json");

        filmList.forEach(item -> {
            JSONObject JSONFilm = (JSONObject) item;
            Film newFilm = new Film(JSONFilm);
            films.add(newFilm);
        });
    }

    /**
     *  Description: Gets the actor with a specific UUID
     */
    public static Actor getActorbyId(UUID id){
        for (Actor actor: actors) {
            if(actor.ID.equals(id)){
                return actor;
            }
        }

        return null;
    }

    /**
     *  Description: Gets the rating with a specific UUID
     */
    public static Rating getRatingbyId(UUID id){
        for (Rating rating: ratings) {
            if(rating.ID.equals(id)){
                return rating;
            }
        }

        return null;
    }
}
