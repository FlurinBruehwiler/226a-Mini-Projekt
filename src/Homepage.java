import java.util.Scanner;

public class Homepage {
    public void showPage() {
        System.out.println("What do you want to do?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. List Films");
        System.out.println("2. Search Films");
        String input = scanner.nextLine();

        switch (input) {
            case "1":

                break;
            case "2":

                break;

            default:
                break;
        }

    }
}
