import java.util.Scanner;

public class Login {
    public String[] getInput()
    {
        String[] output = new String[2];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username:");
        output[0] = scanner.nextLine();
        System.out.println("Please enter your password");
        output[1] = scanner.nextLine();

        return output;


    }
}
