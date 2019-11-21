import java.util.Scanner;

public class HotelApp {
    boolean cont = true;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        HotelApp myApp = new HotelApp();
        myApp.showMenu();
    }

    private void showMenu() {
        do {
            System.out.println("Select an option");
            System.out.println("1. Hotel manager login");
            System.out.println("2. Customer login");
            String choice = input.nextLine();
            if (choice.equals("1")) {
                System.out.print("Please enter password: ");
                String password = input.nextLine();
                if (password.equals("abc123")) {
                    System.out.println("Welcome to the hotel app!");
                    cont = false;
                } else {
                    System.out.println("Please try again!");
                }
            } else {
                System.out.println("That option is unavailable!");
            }
        } while (cont);
    }
}
