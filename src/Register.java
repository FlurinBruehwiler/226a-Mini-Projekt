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

        userList = JSONFileManager.readJSONArrayFromFile(path);

        JSONObject userDetails = new JSONObject();

        userDetails.put("username", input[0]);
        userDetails.put("password", input[1]);

        userList.add(userDetails);

        JSONFileManager.writeJSONArrayToFile(userList, path);

        UserManager.updateUsers();
    }
}