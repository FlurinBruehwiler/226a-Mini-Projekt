import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        JSONArray userList = new JSONArray();

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("users.json")) {
            Object obj = jsonParser.parse(reader);
            userList = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject userDetails = new JSONObject();

        userDetails.put("username", input[0]);
        userDetails.put("password", input[1]);

        userList.add(userDetails);

        try (FileWriter file = new FileWriter("users.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(userList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



