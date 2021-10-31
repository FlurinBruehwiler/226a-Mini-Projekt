import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.UUID;

public class Storage {
    public static ArrayList<Actor> actors = new ArrayList<>();
    public static ArrayList<Rating> ratings = new ArrayList<>();
    public static ArrayList<Film> films = new ArrayList<>();

    public static void ReadAllObjects(){
        ReadAllActors();
        ReadAllRatings();
        ReadAllFilms();

    }

    public static void ReadAllActors(){
        JSONArray actorList = JSONFileManager.readJSONArrayFromFile("actors.json");

        actorList.forEach(item -> {
            JSONObject JSONActor = (JSONObject) item;
            Actor newActor = new Actor(JSONActor);
            actors.add(newActor);
        });
    }

    public static void ReadAllRatings(){
        JSONArray ratingList = JSONFileManager.readJSONArrayFromFile("ratings.json");

        ratingList.forEach(item -> {
            JSONObject JSONRating = (JSONObject) item;
            Rating newRating = new Rating(JSONRating);
            ratings.add(newRating);
        });
    }

    public static void ReadAllFilms(){
        JSONArray filmList = JSONFileManager.readJSONArrayFromFile("films.json");

        filmList.forEach(item -> {
            JSONObject JSONFilm = (JSONObject) item;
            Film newFilm = new Film(JSONFilm);
            films.add(newFilm);
        });
    }

    public static Actor getActorbyId(UUID id){
        for (Actor actor: actors) {
            if(actor.ID.equals(id)){
                return actor;
            }
        }

        return null;
    }

    public static Rating getRatingbyId(UUID id){
        for (Rating rating: ratings) {
            if(rating.ID.equals(id)){
                return rating;
            }
        }

        return null;
    }
}
