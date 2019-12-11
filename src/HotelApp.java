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
            System.out.println("5. Check out customer");
            System.out.println("6. Create rooms");
            System.out.println("7. Edit a room");
            System.out.println("8. Exit");
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
                myHotelLogic.createRooms();
            } else if (choice.equals("7")){
                myHotelLogic.editRoom();
            } else if (choice.equals("8")) {
                cont = false;
            }
        } while (cont);
    }
}
