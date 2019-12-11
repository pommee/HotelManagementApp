import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Room> arrListRoom = new ArrayList<>();
    private ArrayList<Customer> arrListCustomer = new ArrayList<>();

    public void addCustomer() {
        boolean cont = true;
        do {
            System.out.print("Enter ssn: ");
            String ssn = input.nextLine();
            if (ssn.equals("")) {
                System.out.println("No ssn was entered, try again");
                break;
            }
            System.out.print("Enter name: ");
            String name = input.nextLine();
            if (name.equals("")) {
                System.out.println("No name was entered, try again");
                break;
            }
            System.out.print("Enter address: ");
            String address = input.nextLine();
            if (address.equals("")) {
                System.out.println("No address was entered, try again");
                break;
            }
            System.out.print("Enter telephone-number: ");
            String telephoneNumber = input.nextLine();
            if (telephoneNumber.equals("")) {
                System.out.println("No telephone-number was entered, try again");
                break;
            }

            isCustomerCreated(ssn);
            if (isCustomerCreated(ssn)) {
                System.out.println("That ssn already exists");
            } else {
                arrListCustomer.add(new Customer(ssn, name, address, telephoneNumber));
                cont = false;
            }
        } while (cont);
    }

    private boolean isCustomerCreated(String customerSsn) {
        for (Customer element : arrListCustomer) {
            if (element.getSsn().equals(customerSsn)) {
                return true;
            }
        }
        return false;
    }

    public void getCustomers() {
        if (arrListCustomer.size() > 0) {
            for (Customer post : arrListCustomer) {
                System.out.println(post);
            }
        } else {
            System.out.println("There are currently no registered customers");
        }
    }

    public void createRooms() {

        if (arrListRoom.size() <= 0) {
            int roomNumber = 0;
            for (int i = 0; i < 11; i++) {
                arrListRoom.add(new Room(roomNumber, 1, false, 150.0));
                roomNumber++;
            }
            for (int i = 0; i < 4; i++) {
                arrListRoom.add(new Room(roomNumber, 1, true, 200.0));
                roomNumber++;
            }
            for (int i = 0; i < 5; i++) {
                arrListRoom.add(new Room(roomNumber, 2, false, 300.0));
                roomNumber++;
            }
            System.out.println("Rooms created");
        } else {
            System.out.println("Rooms already created");
        }
    }

    public void getRooms() {
        if (arrListRoom.size() > 0) {
            for (Room print : arrListRoom) {
                System.out.println(print);
            }
        } else {
            System.out.println("No rooms created");
        }
    }


    public void getAvailableRooms() {
        for (Room room : arrListRoom) {
            if (!room.isBooked()) {
                System.out.println(room);
            } else {
                System.out.println("Room is booked.");
            }
        }
    }

    private boolean roomNumberExists(Integer roomNumber) {
        for (Room element : arrListRoom) {
            if (element.getRoomNumber() == (roomNumber)) {
                System.out.println("Room informations: " + element);
                return true;
            }
        }
        System.out.println("That room does not exist");
        return false;
    }

    private boolean customerExists(String customerSsn) {
        for (Customer element : arrListCustomer) {
            if (element.getSsn().equals(customerSsn)) {
                System.out.println("Customer information: " + element);
                return true;
            }
        }
        System.out.println("SSN" + " not in system");
        return false;
    }

    public void checkInCustomer() {
        if (arrListCustomer.size() <= 0) {
            System.out.println("No customers in the system");
        } else {
            System.out.print("ssn of customer: ");
            String ssn = input.nextLine();
            boolean exists = customerExists(ssn);
            if (exists) {
                if (arrListRoom.size() <= 0) {
                    System.out.println("No rooms to book");
                } else {
                    getAvailableRooms();
                    System.out.print("What room do you want to book: ");
                    int choice = getUserNumberInput();
                    if (roomNumberExists(choice)) {
                        System.out.println("Do you want to book " + ssn + " to room number: " + choice + "?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int answer = getUserNumberInput();
                        if (answer == 1) {
                            for (Room room : arrListRoom) {
                                if (room.getRoomNumber() == choice) {
                                    room.setBooked(true);
                                    room.setBookedBy(ssn);
                                }
                            }
                            System.out.println("Booked");
                        } else if (answer == 2) {
                            System.out.println("No booking has been done");
                        }
                    }
                }
            } else {
                System.out.println("Customer does not exist");
            }
        }
    }


    public Room getCustomerRoom(String ssn) {
        for (Room room : arrListRoom) {
            if (room.isBookedBy(ssn)) {
                return room;
            }
        }
        return null;
    }


    public void listCustomerRooms(String ssn) {
        for (Room room : arrListRoom) {
            if (room.isBookedBy(ssn)) {
                System.out.println(room);
            }
        }
    }

    public void checkOutCustomer() {
        if (arrListCustomer.size() > 0) {
            System.out.println("Enter the social security number of the customer who wishes to check out: ");
            String ssn = input.nextLine();
            boolean exists = customerExists(ssn);
            if (exists) {
                listCustomerRooms(ssn);

                System.out.println("Do you wish to check out?");
                System.out.println("1.Yes");
                System.out.println("2.No");
                int option = getUserNumberInput();
                if (option == 1) {
                    for (Room room : arrListRoom) {
                        if (room.isBookedBy(ssn)) {
                            room.setBooked(false);
                            room.setBookedBy(null);
                        }
                    }
                    System.out.println("The customer has now checked out");
                } else if (option == 2) {
                    System.out.println("Cancelled");
                }
            }
        } else {
            System.out.println("No customer");
        }
    }

    public void editRoom() {
        if (arrListCustomer.size() > 0) {
            System.out.println("Enter the social security number of the customer who wishes to edit their room: ");
            String ssn = input.nextLine();
            boolean exists = customerExists(ssn);
            if (exists) {
                Room room = getCustomerRoom(ssn);
                System.out.println(room);

                System.out.println("Would you like to add an extra bed to a current booked room?");
                System.out.println("1.Yes");
                System.out.println("2.No");
                int option = getUserNumberInput();
                if (option == 1) {
                    room.setNumberOfBeds(room.getNumberOfBeds() + 1);
                    System.out.println("An extra bed has been added to the room");
                }

                System.out.println("Do you want to add a customer note?");
                System.out.println("1.Yes");
                System.out.println("2.No");
                int choice = getUserNumberInput();
                if (choice == 1) {
                    System.out.print("Enter your note: ");
                    String customerNote = input.nextLine();
                    room.setCustomerNote(customerNote);
                    System.out.println("Customer notes: " + room.getCustomerNote());
                }
            }
        }
    }

    public int getUserNumberInput() {
        boolean doLoop = true;
        int number = 0;
        while (doLoop) {
            String userInput = input.nextLine();
            try {
                number = Integer.parseInt(userInput);
                doLoop = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter a number instead");
            }
        }
        return number;
    }
}


