import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSONFileManager {
    public static void writeJSONArrayToFile(JSONArray arrayToSave, String path){
        try (FileWriter file = new FileWriter(path)) {
            file.write(arrayToSave.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param path
     * @return
     */
    public static JSONArray readJSONArrayFromFile(String path){


        File tempFile = new File(path);

        if(tempFile.length() == 0){
            return new JSONArray();
        }

        boolean exists = tempFile.exists();

        JSONArray readList = new JSONArray();

        if(!exists){
            return readList;
        }

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path)) {

            Object obj = jsonParser.parse(reader);
            readList = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return readList;
    }
}
