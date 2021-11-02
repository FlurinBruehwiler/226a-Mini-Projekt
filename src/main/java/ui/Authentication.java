package main.java.ui;

import main.java.ObjCache;
import main.java.typedefinitions.User;

import java.util.Scanner;

public class Authentication {
    public static void authentificate(){
        while(true){
            System.out.println("0: Login");
            System.out.println("1: Register");
            Scanner scanner = new Scanner(System.in);
            int loginOrRegister = scanner.nextInt();
            switch(loginOrRegister){
                case 0:
                    if(login()){
                        return;
                    }
                    break;

                case 1:
                    register();
                    return;
            }
        }
    }

    private static boolean register(){
        while (true){
            String[] input = getRegisterInput();
            if(input[1].equals(input[2])){
                if(!userAlreadyExists(input[0])){
                    User newUser = new User(input[0], input[1]);
                    ObjCache.users.add(newUser);
                    newUser.saveToJson();
                    return true;
                }
                System.out.println("User with username " + input[0] + " does already exist");
            }else{
                System.out.println("Passwords do not match");
            }
        }
    }

    private static boolean userAlreadyExists(String username){
        for (User user : ObjCache.users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    private static boolean login(){
        while(true){
            String[] input = getLoginInput();
            for(User user : ObjCache.users){
                if(user.getUsername().equals(input[0])){
                    if(user.getPassword().equals(input[1])){
                        System.out.println("-------------------------");
                        System.out.println("Login successful");
                        return true;
                    }
                }
            }
            System.out.println("Wrong Username or Password");
            System.out.println("0: try again");
            System.out.println("1: go back");
            Scanner scanner = new Scanner(System.in);
            int tryAgain = scanner.nextInt();
            if(tryAgain == 1){
                return false;
            }
        }
    }

    public static String[] getRegisterInput() {
        System.out.println("-------------------------");
        System.out.println("Register");

        String[] output = new String[3];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a username");
        output[0] = scanner.nextLine();
        System.out.println("Please enter a password");
        output[1] = scanner.nextLine();
        System.out.println("Please enter your password again");
        output[2] = scanner.nextLine();

        return output;
    }

    public static String[] getLoginInput(){
        System.out.println("--------------------------");
        System.out.println("Login");

        String[] output = new String[2];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a username");
        output[0] = scanner.nextLine();
        System.out.println("Please enter a password");
        output[1] = scanner.nextLine();

        return output;
    }
}
