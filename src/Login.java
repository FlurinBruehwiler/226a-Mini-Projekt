import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.nio.file.Path;
import java.util.Scanner;

public class Login {

    public void login(){
        String[] input = getInput();
        boolean result = checkInput(input);
        System.out.println(result);

    }


    public boolean checkInput(String[] input){
        for (User user: UserManager.users) {

            String username = user.username;
            String password = user.password;

            if(input[0].equals(username) && input[1].equals(password)){
                return true;
            }
        }
        return false;
    }

    public String[] getInput() {
        String[] output = new String[2];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        output[0] = scanner.nextLine();
        System.out.println("Please enter your password");
        output[1] = scanner.nextLine();

        return output;


    }
}
