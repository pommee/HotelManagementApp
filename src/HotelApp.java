import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class HotelApp {
    private boolean cont = true;
    private Scanner input = new Scanner(System.in);
    private HotelLogic myHotelLogic = new HotelLogic();
    private boolean doneOnce = false;


    public static void main(String[] args) throws IOException, ParseException {
        HotelApp myHotelApp = new HotelApp();
        myHotelApp.loginMenu();
    }

    private void loginMenu() throws IOException, ParseException {
        System.out.println("  _    _  _  __ _____    _    _         _         _ \n" +
                " | |  | || |/ /|  __ \\  | |  | |       | |       | |\n" +
                " | |__| || ' / | |__) | | |__| |  ___  | |_  ___ | |\n" +
                " |  __  ||  <  |  _  /  |  __  | / _ \\ | __|/ _ \\| |\n" +
                " | |  | || . \\ | | \\ \\  | |  | || (_) || |_|  __/| |\n" +
                " |_|  |_||_|\\_\\|_|  \\_\\ |_|  |_| \\___/  \\__|\\___||_|\n" +
                "                                                    \n" +
                "                                                    ");
        LocalDate date = LocalDate.now();
        System.out.println();
        System.out.println("Current date: " + (date));
        do {
            if (!doneOnce) {
                myHotelLogic.readBookingText();
                myHotelLogic.readCustomerText();
                myHotelLogic.readRoomText();
                doneOnce = true;
            }
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
            } else {
                System.out.println("Invalid option, please try again");
            }
        } while (cont);
    }

    private void showManagerMenu() throws IOException, ParseException {
        boolean cont = true;
        do {
            System.out.println();
            System.out.println("--- Manager ---");
            System.out.println("1. Add customer");
            System.out.println("2. View all customers");
            System.out.println("3. View rooms");
            System.out.println("4. View all bookings");
            System.out.println("5. Check in/out customer");
            System.out.println("6. Search for booking");
            System.out.println("7. Edit room");
            System.out.println("8. Edit customer");
            System.out.println("9. Remove customer");
            System.out.println("10. Remove room");
            System.out.println("11. Edit booking");
            System.out.println("12. Cancel booking");
            System.out.println("13. View bookings between dates");
            System.out.println("14. Previous Bookings");
            System.out.println("15. Log out");
            System.out.println("16. Exit");
            System.out.print("> ");
            String choice = input.nextLine();
            System.out.println();

            if (choice.equals("1")) {
                myHotelLogic.addCustomer();
            } else if (choice.equals("2")) {
                myHotelLogic.getCustomers();
            } else if (choice.equals("3")) {
                System.out.println("-- Select option --");
                System.out.println("1. View available rooms only");
                System.out.println("2. View all rooms");
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
                myHotelLogic.searchBooking();
            } else if (choice.equals("7")) {
                myHotelLogic.editRoom();
            } else if (choice.equals("8")) {
                myHotelLogic.editCustomer();
            } else if (choice.equals("9")) {
                myHotelLogic.removeCustomer();
            } else if (choice.equals("10")) {
                myHotelLogic.removeRoom();
            } else if (choice.equals("11")) {
                myHotelLogic.editBooking();
            } else if (choice.equals("12")) {
                myHotelLogic.cancelBooking();
            } else if (choice.equals("13")) {
                myHotelLogic.showBookingsBetweenDates();
            } else if (choice.equals("14")) {
                myHotelLogic.previousBooking();
            } else if (choice.equals("15")) {
                loginMenu();
            } else if (choice.equals("16")) {
                System.out.println("Thank you for using the HKR Hotel App!");
                cont = false;
            } else {
                System.out.println("Invalid option, please try again");
            }
        } while (cont);
    }

    private void showCustomerMenu() throws IOException, ParseException {
        boolean cont = true;
        do {
            System.out.println();
            System.out.println("--- Customer ---");
            System.out.println("1. View rooms");
            System.out.println("2. Edit information");
            System.out.println("3. Check In/Out");
            System.out.println("4. Register");
            System.out.println("5. View previous bookings");
            System.out.println("6. Apply coupon");
            System.out.println("7. Log out");
            System.out.println("8. Exit");
            System.out.print("> ");
            String choice = input.nextLine();
            if (choice.equals("1")) {
                myHotelLogic.getAvailableRooms();
            } else if (choice.equals("2")) {
                myHotelLogic.editCustomer();
            } else if (choice.equals("3")) {
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
                        System.out.println("Please try again!");
                    }
                } while (contAnswer);
            } else if (choice.equals("4")) {
                myHotelLogic.customerMenuCheckIn();
            } else if (choice.equals("5")) {
                myHotelLogic.previousBooking();
            } else if (choice.equals("6")) {
                myHotelLogic.applyCoupon();
            } else if (choice.equals("7")) {
                loginMenu();
            } else if (choice.equals("8")) {
                cont = false;
                System.out.println("Thanks for visiting HKR Hotel!");
            }
        } while (cont);
    }
}