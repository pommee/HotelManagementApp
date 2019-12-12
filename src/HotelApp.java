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
            System.out.println("3. Show rooms");
            System.out.println("4. Show all bookings");
            System.out.println("5. Check in customer");
            System.out.println("6. Check out customer");
            System.out.println("7. Create customers");
            System.out.println("8. Create rooms");
            System.out.println("9. Search for booking");
            System.out.println("10. Edit room");
            System.out.println("11. Edit customer");
            System.out.println("12. Remove customer");
            System.out.println("13. Remove room");
            System.out.println("14. Edit booking");
            System.out.println("15. Create bookings");
            System.out.println("16. Cancel booking");
            System.out.println("17. Exit");
            String choice = input.nextLine();
            System.out.println();

            if (choice.equals("1")) {
                myHotelLogic.addCustomer();
            } else if (choice.equals("2")) {
                myHotelLogic.getCustomers();
            } else if (choice.equals("3")) {
                System.out.println("-- Select option --");
                System.out.println("1. Show available rooms only");
                System.out.println("2. Show all rooms");
                int roomChoice = input.nextInt();
                if (roomChoice == 1) {
                    myHotelLogic.getAvailableRooms();
                } else if (roomChoice == 2) {
                    myHotelLogic.getRooms();
                }
            } else if (choice.equals("4")) {
                myHotelLogic.getBookings();
            } else if (choice.equals("5")) {
                myHotelLogic.checkInCustomer();
            } else if (choice.equals("6")) {
                myHotelLogic.checkOutCustomer();
            } else if (choice.equals("7")) {
                myHotelLogic.createCustomers();
            } else if (choice.equals("8")) {
                myHotelLogic.createRooms();
            } else if (choice.equals("9")) {
                myHotelLogic.searchBooking();
            } else if (choice.equals("10")) {
                myHotelLogic.editRoom();
            } else if (choice.equals("11")) {
                myHotelLogic.editCustomer();
            } else if (choice.equals("12")) {
                myHotelLogic.removeCustomer();
            } else if (choice.equals("13")) {
                myHotelLogic.removeRoom();
            } else if (choice.equals("14")) {
                myHotelLogic.editBooking();
            } else if (choice.equals("15")) {
                myHotelLogic.createBookings();
            } else if (choice.equals("16")) {
                myHotelLogic.cancelBooking();
            } else if (choice.equals("17")) {
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
