import java.util.Random;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelLogic {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Room> arrListRoom = new ArrayList<>();
    private ArrayList<Customer> arrListCustomer = new ArrayList<>();
    private ArrayList<Booking> arrListBookings = new ArrayList<>();

    public void addCustomer() {
        boolean cont = true;
        do {
            System.out.print("Enter ssn YYYYMMDD-XXXX: ");
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

    public void removeCustomer() {

        int custId = 0;
        if (!arrListCustomer.isEmpty()) {
            System.out.println("Enter the ID of the customer you would like to remove:");
            for (Customer post : arrListCustomer) {
                System.out.println("ID: " + custId + ", " + post);
                custId++;
            }
            try {
                int removeIndex = input.nextInt();
                System.out.println("Customer has successfully been removed.");
                arrListCustomer.remove(removeIndex);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
        } else {
            System.out.println("There are no customers to remove.");
        }
    }

    public void removeRoom() {

        if (!arrListRoom.isEmpty()) {
            System.out.println("Enter the number of the room you would like to remove:");
            for (Room post : arrListRoom) {
                System.out.println(post);
            }
            try {
                int roomNumber = input.nextInt();
                System.out.println("Room " + roomNumber + " has successfully been removed.");
                arrListRoom.remove(roomNumber);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
        } else {
            System.out.println("There are no rooms.");
        }
    }

    public void editCustomer() {
        int customerId = 0;

        if (!arrListCustomer.isEmpty()) {
            for (Customer element : arrListCustomer) {
                System.out.println("ID: " + customerId + ", " + element);
                customerId++;
            }
            System.out.print("Enter the ID of the customer you would like to edit: ");
            int editIndex = input.nextInt();
            System.out.println("What type of information would you like to edit of customer " + arrListCustomer.get(editIndex) + "?");
            System.out.println("1. SSN");
            System.out.println("2. Name");
            System.out.println("3. Address");
            System.out.println("4. Telephone number");

            try {
                int choice = input.nextInt();
                if (choice == 1) {
                    System.out.print("Enter new SSN: ");
                    input.nextLine();
                    String newSSN = input.nextLine();
                    Customer custChange = arrListCustomer.get(editIndex);
                    custChange.setSsn(newSSN);
                    System.out.println("Successfully changed customers SSN.");
                } else if (choice == 2) {
                    System.out.print("Enter new name: ");
                    input.nextLine();
                    String newName = input.nextLine();
                    Customer custChange = arrListCustomer.get(editIndex);
                    custChange.setName(newName);
                    System.out.println("Successfully changed customers name.");
                } else if (choice == 3) {
                    System.out.print("Enter new address: ");
                    input.nextLine();
                    String newAddress = input.nextLine();
                    Customer custChange = arrListCustomer.get(editIndex);
                    custChange.setAddress(newAddress);
                    System.out.println("Successfully changed customers address.");
                } else if (choice == 4) {
                    System.out.print("Enter new telephone nr: ");
                    input.nextLine();
                    String newNr = input.nextLine();
                    Customer custChange = arrListCustomer.get(editIndex);
                    custChange.setTelephoneNumber(newNr);
                    System.out.println("Successfully changed customers telephone number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a number between 1-4.");
            }
        } else {
            System.out.println("There are no customers to edit.");
        }
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

        if (arrListRoom.isEmpty()) {
            Random random = new Random();
            for (int i = 0; i <= 20; i++) {
                int randomBeds = random.nextInt((3 - 1) + 1) + 1;
                double randomPrice = random.nextInt(300 - 100) + 100;
                boolean randomHasBalcony = random.nextBoolean();
                boolean randomIsBooked = random.nextBoolean();
                arrListRoom.add(new Room(i, randomBeds, randomHasBalcony, randomPrice));
                arrListRoom.get(i).setBooked(randomIsBooked);
            }
            System.out.println("Rooms created.");
        } else {
            System.out.println("There are rooms already created");
        }
    }

    public void createCustomers() {

        if (arrListCustomer.isEmpty()) {
            arrListCustomer.add(new Customer("195705060688", "Jakob Kristiansson", "Fältvägen 9A", "0736205531"));
            arrListCustomer.add(new Customer("198704359382", "Mikael Persson", "Hjortgatan 3C", "0702716273"));
            arrListCustomer.add(new Customer("197712224855", "Åke Jonsson", "Gladiolvägen 6B", "0738351905"));

            System.out.println("Customers created.");
        } else {
            System.out.println("There are customers already created.");
        }
    }

    public void getRooms() {
        if (arrListRoom.size() > 0) {
            for (Room print : arrListRoom) {
                System.out.println(print);
            }
        } else {
            System.out.println("There are no rooms created to show.");
        }
    }

    public void getAvailableRooms() {
        if (!arrListRoom.isEmpty()) {
            for (Room room : arrListRoom) {
                if (!room.isBooked()) {
                    System.out.println("Available: " + room);
                }
            }
        } else {
            System.out.println("There are no rooms created to show only available rooms.");
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

    public void searchBooking() {
        if (arrListRoom.size() > 0) {
            System.out.print("Enter ssn: ");
            String ssn = input.nextLine();
            if (isCustomerCreated(ssn)) {
                for (Room room : arrListRoom) {
                    if (ssn.equals(room.getBookedBy())) {
                        System.out.println(room);
                    }
                }
            } else {
                System.out.println("Customer not registered");
            }
        } else {
            System.out.println("No rooms created");
        }
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
                    int choice = input.nextInt();
                    if (roomNumberExists(choice)) {
                        System.out.println("Do you want to book " + ssn + " to room number: " + choice + "?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int answer = input.nextInt();
                        if (answer == 1) {
                            for (Room room : arrListRoom) {
                                if (room.getRoomNumber() == choice) {
                                    room.setBooked(true);
                                    room.setBookedBy(ssn);
                                }
                            }
                            System.out.println("Booked");
                            input.nextLine();
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
                    int beds = room.getNumberOfBeds();
                    room.setNumberOfBeds(beds + 1);
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

    public void editBooking() {
        if (!arrListBookings.isEmpty()) {
            for (Booking element : arrListBookings) {
                System.out.println("ID: " + element);
            }

            try {
                System.out.print("Enter the ID of the Booking you would like to edit: ");
                int editIndex = input.nextInt() - 1;
                System.out.println("What type of information would you like to edit of the booking " + arrListBookings.get(editIndex) + "?");
                System.out.println("1. Booking ID");
                System.out.println("2. Check-in date");
                System.out.println("3. Check-out date");
                System.out.println("4. Total price");
                int menuChoice = input.nextInt();
                if (menuChoice == 1) {
                    System.out.print("Enter new Booking ID: ");
                    input.nextLine();
                    int newBookingID = input.nextInt();
                    Booking bookChange = arrListBookings.get(editIndex);
                    bookChange.setBookingId(newBookingID);
                    System.out.println("Successfully changed Booking ID.");
                } else if (menuChoice == 2) {
                    System.out.print("Enter new Check-in date (YYYY-MM-DD): ");
                    input.nextLine();
                    String newCheckIn = input.nextLine();
                    Booking bookChange = arrListBookings.get(editIndex);
                    bookChange.setCheckInDate(newCheckIn);
                    System.out.println("Successfully changed check-in date.");
                } else if (menuChoice == 3) {
                    System.out.print("Enter new Check-out date (YYYY-MM-DD): ");
                    input.nextLine();
                    String newCheckOut = input.nextLine();
                    Booking bookChange = arrListBookings.get(editIndex);
                    bookChange.setCheckOutDate(newCheckOut);
                    System.out.println("Successfully changed check-out date.");
                } else if (menuChoice == 4) {
                    System.out.print("Enter new total price: ");
                    input.nextLine();
                    double newTotalPrice = input.nextDouble();
                    Booking bookChange = arrListBookings.get(editIndex);
                    bookChange.setTotalPrice(newTotalPrice);
                    System.out.println("Successfully changed total price.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a number between 1-4.");
            }
        } else {
            System.out.println("There are no bookings to edit.");
        }
    }

    public void createBookings() {

        if (arrListBookings.size() <= 0) {
            arrListBookings.add(new Booking(1, "2019-12-12", "2019-12-13", 250.0));
            arrListBookings.add(new Booking(2, "2019-12-17", "2019-12-20", 350.0));
            arrListBookings.add(new Booking(3, "2019-12-25", "2019-12-20", 400.0));

            System.out.println("Bookings created.");
        } else {
            System.out.println("Bookings already created.");
        }
    }

    public void getBookings() {
        if (arrListBookings.size() > 0) {
            for (Booking element : arrListBookings) {
                System.out.println(element);
            }
        } else {
            System.out.println("No room bookings created.");
        }
    }

    public void cancelBooking() {

        if (arrListBookings.isEmpty()) {
            for (Room element : arrListRoom) {
                if (element.isBooked()) {
                    System.out.println(element);
                }
            }
            System.out.print("Enter the number of the room which you would like to cancel booking: ");
            int cancelBooking = input.nextInt();
            arrListRoom.get(cancelBooking).setBooked(false);
        } else {
            System.out.println("There are no bookings to cancel.");
        }
    }
}

