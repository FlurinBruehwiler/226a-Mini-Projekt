import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Storage {
    ArrayList<Actor> Actors = new ArrayList<>();
    ArrayList<Rating> Ratings = new ArrayList<>();
    ArrayList<Film> Films = new ArrayList<>();

    void ReadAllActors(){
        JSONArray actorList = JSONFileManager.readJSONArrayFromFile("actors.json");

        actorList.forEach(item -> {
            JSONObject JSONActor = (JSONObject) item;
            Actor newActor = new Actor(JSONActor);
            Actors.add(newActor);
        });
    }

    void ReadAllRatings(){
        JSONArray ratingList = JSONFileManager.readJSONArrayFromFile("ratings.json");

        ratingList.forEach(item -> {
            JSONObject JSONRating = (JSONObject) item;
            Rating newRating = new Rating(JSONRating);
            Ratings.add(newRating);
        });
    }

    void ReadAllFilms(){
        JSONArray filmList = JSONFileManager.readJSONArrayFromFile("films.json");

        filmList.forEach(item -> {
            JSONObject JSONFilm = (JSONObject) item;
            Film newFilm = new Film(JSONFilm);
            Films.add(newFilm);
        });
    }
}
