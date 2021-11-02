package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateInput {

    /**
     * Description: Gets the input when the user chooses a film to inspect
     */
    public static int getFilmChooserInput(){
        int filmInput = 0;

        //repeat until the user enters a valid input
        while (true) {
            System.out.print("Film to inspect (-1 to quit): ");
            Scanner scanner = new Scanner(System.in);
            try {
                filmInput = scanner.nextInt();
                //throw exception if the film does not exist
                if (filmInput > ObjCache.films.size() - 1 || filmInput < -1) {
                    throw new InvalidInputException(-1, ObjCache.films.size() - 1);
                }
                break;

            } catch (InvalidInputException e) {
                System.out.println(e);
            }catch (InputMismatchException e){
                System.out.println("Please enter a number");
            }
        }
        return filmInput;
    }

    /**
     * Description: Gets the input when the user chooses an action in a film menu
     */
    public static int getFilmMenuInput(){
        int filmMenu = 0;

        //repeat until the user enters a valid input
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                filmMenu = scanner.nextInt();

                //throw exception if the menu point does not exist
                if (filmMenu > 3 || filmMenu < 0) {
                    throw new InvalidInputException(0,3);
                }
                break;

            } catch (InvalidInputException e) {
                System.out.println(e);
            }catch (InputMismatchException e){
                System.out.println("Please enter a number");
            }
        }
        return filmMenu;
    }

    /**
     * Description: Gets the input when the user enters a rating for a film
     */
    public static int getStarsInput(){
        int stars = 0;

        //repeat until the user enters a valid input
        while (true) {
            System.out.print("Stars: ");
            Scanner scanner = new Scanner(System.in);
            try {
                stars = scanner.nextInt();

                //throw exception if the user enters an incorrect amount of stars
                if (stars < 1 || stars > 5) {
                    throw new InvalidInputException(1,5);
                }
                break;

            } catch (InvalidInputException e) {
                System.out.println(e);
            }catch (InputMismatchException e){
                System.out.println("Please enter a number");
            }
        }
        return stars;
    }

    /**
     * Description: Gets the input when the user chooses if he wants to login or register
     */
    public static int getLoginOrRegisterInput(){
        int input = 0;

        //repeat until the user enters a valid input
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                input = scanner.nextInt();

                //throw exception if the users chooses a menu point that does not exist
                if (input < 1 || input > 2) {
                    throw new InvalidInputException(1,2);
                }
                break;

            } catch (InvalidInputException e) {
                System.out.println(e);
            }catch (InputMismatchException e){
                System.out.println("Please enter a number");
            }
        }
        return input;
    }
}
