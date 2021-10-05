import java.io.*;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Register {
    public String[] getInput() {
        String[] output = new String[2];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a username");
        output[0] = scanner.nextLine();
        System.out.println("Please enter a password");
        output[1] = scanner.nextLine();
        System.out.println("Please enter your password again");
        String checkpassword = scanner.nextLine();

        if (output[1].equals(checkpassword)) {
            return output;
        } else {
            return getInput();
        }
    }

    @SuppressWarnings("unchecked")
    public void writeInput(String[] input) throws IOException, ParseException {
        String path = "users.json";


        JSONArray userList = new JSONArray();

        readJSONArrayFromFile(path);

        JSONObject userDetails = new JSONObject();

        userDetails.put("username", input[0]);
        userDetails.put("password", input[1]);

        userList.add(userDetails);

        writeJSONArrayToFile(userList, path);
    }

    public void writeJSONArrayToFile(JSONArray arrayToSave, String path){
        try (FileWriter file = new FileWriter(path)) {
            file.write(arrayToSave.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONArray readJSONArrayFromFile(String path){
        File tempFile = new File(path);
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



