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
                    showManagerMenu();
                    cont = false;
                } else {
                    System.out.println("Please try again!");
                }
            } else if (choice.equals("2")) {
                showCustomerMenu();
                cont = false;
            }
        } while (cont);
    }

    private void showManagerMenu() {
        boolean cont = true;
        do {
            System.out.println("--- Manager ---");
            System.out.println("1. Add customer");
            System.out.println("2. Show all customers");
            System.out.println("3. Show all rooms");
            System.out.println("4. Check in customer");
            System.out.println("5. Check out customer");
            System.out.println("6. Create customers");
            System.out.println("7. Create rooms");
            System.out.println("8. Search for booking");
            System.out.println("9. Edit room");
            System.out.println("10. Edit customer");
            System.out.println("11. Remove customer");
            System.out.println("12. Remove room");
            System.out.println("13. Exit");
            String choice = input.nextLine();
            System.out.println();

            if (choice.equals("1")) {
                myHotelLogic.addCustomer();
            } else if (choice.equals("2")) {
                myHotelLogic.getCustomers();
            } else if (choice.equals("3")) {
                myHotelLogic.getRooms();
            } else if (choice.equals("4")) {
                myHotelLogic.checkInCustomer();
            } else if (choice.equals("5")) {
                myHotelLogic.checkOutCustomer();
            } else if (choice.equals("6")) {
                myHotelLogic.createCustomers();
            } else if (choice.equals("7")) {
                myHotelLogic.createRooms();
            } else if (choice.equals("8")) {
                myHotelLogic.searchBooking();
            } else if (choice.equals("9")) {
                myHotelLogic.editRoom();
            } else if (choice.equals("10")) {
                myHotelLogic.editCustomer();
            } else if (choice.equals("11")) {
                myHotelLogic.removeCustomer();
            } else if (choice.equals("12")) {
                myHotelLogic.removeRoom();
            } else if (choice.equals("13")) {
                System.out.println("Thank you for visiting our hotel!");
                cont = false;
            }

        } while (cont);
    }

    private void showCustomerMenu() {
        boolean cont = true;
        do {
            System.out.println("--- Customer ---");
            System.out.println("1. ");
            System.out.println("2. Exit");

            String choice = input.nextLine();
            if (choice.equals("1")) {
                System.out.println("Test");
            } else if (choice.equals("2")) {
                cont = false;
                System.out.println("Thanks for using HKR Hotel app");
            }
        } while (cont);
    }
}
