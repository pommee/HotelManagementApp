import java.util.Scanner;

public class HotelApp {
    private boolean cont = true;
    private Scanner input = new Scanner(System.in);
    private HotelLogic myHotelLogic = new HotelLogic();

    public static void main(String[] args) {
        HotelApp myHotelApp = new HotelApp();
        myHotelApp.loginMenu();
    }

    private void loginMenu() {
        do {
            System.out.println("Select an option");
            System.out.println("1. Hotel manager login");
            System.out.println("2. Customer login");
            String choice = input.nextLine();
            if (choice.equals("1")) {
                System.out.print("Please enter password: ");
                String password = input.nextLine();
                if (password.equals("abc123")) {
                    showMenu();
                    cont = false;
                } else {
                    System.out.println("Please try again!");
                }
            } else {
                System.out.println("That option is unavailable!");
            }
        } while (cont);
    }

    private void showMenu() {
        boolean cont = true;
        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Add customer");
            System.out.println("2. Show customers registered");
            System.out.println("3. Show all rooms");
            System.out.println("4. Check in customer");
            System.out.println("5. Create rooms");
            System.out.println("6. Exit");
            System.out.println("7. Search for booking");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                myHotelLogic.addCustomer();
            } else if (choice.equals("2")) {
                myHotelLogic.getCustomers();
            } else if (choice.equals("3")) {
                myHotelLogic.getRooms();
            } else if (choice.equals("4")) {
                myHotelLogic.checkInCustomer();
            } else if (choice.equals("5")) {
                myHotelLogic.createRooms();
            } else if (choice.equals("6")) {
                cont = false;
            } else if (choice.equals("7")) {
                myHotelLogic.searchBooking();
            }
        } while (cont);
    }
}
