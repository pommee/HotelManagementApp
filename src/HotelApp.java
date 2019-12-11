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
            System.out.println("2. Show all customers");
            System.out.println("3. Show all rooms");
            System.out.println("4. Check in customer");
            System.out.println("5. Create rooms");
            System.out.println("6. Create customers");
            System.out.println("7. Search for booking");
            System.out.println("8. Edit customer");
            System.out.println("9. Remove customer");
            System.out.println("10. Remove room");
            System.out.println("11. Exit");
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
                myHotelLogic.createCustomers();
            } else if (choice.equals("7")) {
                myHotelLogic.searchBooking();
            } else if (choice.equals("8")) {
                myHotelLogic.editCustomer();
            } else if (choice.equals("9")) {
                myHotelLogic.removeCustomer();
            } else if (choice.equals("10")) {
                myHotelLogic.removeRoom();
            } else if (choice.equals("11")) {
                System.out.println("Thank you for visiting our hotel!");
                cont = false;
            }

        } while (cont);
    }
}
