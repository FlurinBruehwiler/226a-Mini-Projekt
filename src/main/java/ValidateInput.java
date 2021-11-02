package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateInput {
    public static int getFilmChooserInput(){
        int filmInput = 0;
        while (true) {
            System.out.print("Film to inspect (-1 to quit): ");
            Scanner scanner = new Scanner(System.in);
            try {
                filmInput = scanner.nextInt();
                if (filmInput > ObjCache.films.size() - 1) {
                    throw new InputMismatchException();
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number that corresponds to a film");
            }
        }
        return filmInput;
    }

    public static int getFilmMenuInput(){
        int filmMenu = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                filmMenu = scanner.nextInt();
                if (filmMenu > 3) {
                    throw new InputMismatchException();
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Please enter number");
            }
        }
        return filmMenu;
    }

    public static int getStarsInput(){
        int stars = 0;
        while (true) {
            System.out.print("Stars: ");
            Scanner scanner = new Scanner(System.in);
            try {
                stars = scanner.nextInt();
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
