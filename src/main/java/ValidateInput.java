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
                    throw new InputMismatchException();
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number that corresponds to a film");
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
                    throw new InputMismatchException();
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter number");
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
                    throw new InputMismatchException();
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number between 0 and 5");
            }
        }
        return stars;
    }
}
