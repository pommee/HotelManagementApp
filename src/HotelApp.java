import java.time.LocalDate;
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
        LocalDate date = LocalDate.now();
        System.out.println("Welcome to HKR Hotel Application");
        System.out.println("Current date: " + (date) + "\n");
        do {
            myHotelLogic.createRooms();
            System.out.println();
            System.out.println("--- Login options ---");
            System.out.println("1. Hotel manager login");
            System.out.print("2. Customer login" + "\n> ");
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
            System.out.println();
            System.out.println("--- Manager ---");
            System.out.println("1. Add customer");
            System.out.println("2. Show all customers");
            System.out.println("3. Show rooms");
            System.out.println("4. Show all bookings");
            System.out.println("5. Check in/out customer");
            System.out.println("6. Create customers");
            System.out.println("7. Search for booking");
            System.out.println("8. Edit room");
            System.out.println("9. Edit customer");
            System.out.println("10. Remove customer");
            System.out.println("11. Remove room");
            System.out.println("12. Edit booking");
            System.out.println("13. Create bookings");
            System.out.println("14. Cancel booking");
            System.out.println("15. Exit");
            System.out.print("> ");
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
                System.out.println("3. Return to manager menu");
                String subMenu = input.nextLine();
                if (subMenu.equals("1")) {
                    myHotelLogic.getAvailableRooms();
                } else if (subMenu.equals("2")) {
                    myHotelLogic.getRooms();
                } else if (subMenu.equals("3")) {
                    showManagerMenu();
                } else {
                    System.out.println("Please enter a number between 1-3.");
                }
            } else if (choice.equals("4")) {
                myHotelLogic.getBookings();
            } else if (choice.equals("5")) {
                boolean contAnswer = true;
                do {
                    System.out.println("1. Check in customer");
                    System.out.println("2. Check out customer");
                    System.out.print("Select an option: ");
                    String option = input.nextLine();
                    if (option.equals("1")) {
                        myHotelLogic.checkInCustomer();
                        contAnswer = false;
                    } else if (option.equals("2")) {
                        myHotelLogic.checkOutCustomer();
                        contAnswer = false;
                    } else {
                        System.out.println("Please try again");
                    }
                } while (contAnswer);
            } else if (choice.equals("6")) {
                myHotelLogic.createCustomers();
            } else if (choice.equals("7")) {
                myHotelLogic.searchBooking();
            } else if (choice.equals("8")) {
                myHotelLogic.editRoom();
            } else if (choice.equals("9")) {
                myHotelLogic.editCustomer();
            } else if (choice.equals("10")) {
                myHotelLogic.removeCustomer();
            } else if (choice.equals("11")) {
                myHotelLogic.removeRoom();
            } else if (choice.equals("12")) {
                myHotelLogic.editBooking();
            } else if (choice.equals("13")) {
                myHotelLogic.createBookings();
            } else if (choice.equals("14")) {
                myHotelLogic.cancelBooking();
            } else if (choice.equals("15")) {
                System.out.println("Thank you for visiting our hotel!");
                cont = false;
            }

        } while (cont);
    }

    private void showCustomerMenu() {
        boolean cont = true;
        do {
            System.out.println();
            System.out.println("--- Customer ---");
            System.out.println("1. Show rooms");
            System.out.println("2. Check In/Out");
            System.out.println("3. Register");
            System.out.println("4. Exit");
            System.out.print("> ");
            String choice = input.nextLine();
            if (choice.equals("1")) {
                myHotelLogic.getAvailableRooms();
            } else if (choice.equals("2")) {
                boolean contAnswer = true;
                do {
                    System.out.println("1. Check in");
                    System.out.println("2. Check out");
                    System.out.print("Select an option: ");
                    String option = input.nextLine();
                    if (option.equals("1")) {
                        myHotelLogic.checkInCustomer();
                        contAnswer = false;
                    } else if (option.equals("2")) {
                        myHotelLogic.checkOutCustomer();
                        contAnswer = false;
                    } else {
                        System.out.println("Please try again");
                    }
                } while (contAnswer);
            } else if (choice.equals("3")) {
                myHotelLogic.customerMenuCheckIn();
            } else if (choice.equals("4")) {
                cont = false;
                System.out.println("Thanks for using HKR Hotel app");
            }
        } while (cont);
    }
}
