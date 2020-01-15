import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelLogic {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Room> arrListRoom = new ArrayList<>();
    private ArrayList<Customer> arrListCustomer = new ArrayList<>();
    private ArrayList<Booking> arrListBookings = new ArrayList<>();
    private ArrayList<Booking> arrListRecordBooking = new ArrayList<>();


    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public void addCustomer() {
        boolean cont = true;
        do {
            System.out.print("Enter SSN (YYYYMMDDXXXX): ");
            String ssn = input.nextLine();
            if (ssn.matches("[0-9]+")) {
                if (ssn.equals("")) {
                    System.out.println("No SSN was entered, try again.");
                    break;
                }
                System.out.print("Enter name: ");
                String name = input.nextLine();
                if (name.matches("[A-Öa-ö]+")) {
                    if (name.equals("")) {
                        System.out.println("No name was entered, try again.");
                        break;
                    }
                    System.out.print("Enter address: ");
                    String address = input.nextLine();
                    if (address.equals("")) {
                        System.out.println("No address was entered, try again.");
                        break;
                    }
                    System.out.print("Enter telephone-number: ");
                    String telephoneNumber = input.nextLine();
                    if (telephoneNumber.matches("[0-9]+")) {
                        if (telephoneNumber.equals("")) {
                            System.out.println("No telephone-number was entered, try again.");
                            break;
                        }

                        isCustomerCreated(ssn);
                        if (isCustomerCreated(ssn)) {
                            System.out.println("That SSN already exists.");
                        } else {
                            arrListCustomer.add(new Customer(ssn, name, address, telephoneNumber));
                            try {
                                saveCustomerText();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            cont = false;
                        }
                    } else {
                        System.out.println("Please only enter numbers");
                    }
                } else {
                    System.out.println("Please only enter letters");
                }
            } else {
                System.out.println("Please only enter numbers");
            }
        } while (cont);
    }

    public void removeCustomer() {
        if (!arrListCustomer.isEmpty()) {
            for (Customer element : arrListCustomer) {
                System.out.println(element);
            }
            System.out.print("Enter the SSN of the customer you would like to remove: ");
            String inputSSN = input.nextLine();
            if (customerExists(inputSSN)) {
                System.out.println("Are you sure you want to remove " + inputSSN + "? " + "(y/n)");
                System.out.print("> ");
                String answer = input.nextLine();
                if (answer.equals("y")) {
                    arrListCustomer.removeIf(element -> element.getSsn().equals(inputSSN));
                    System.out.println("Customer with SSN: " + inputSSN + " has been successfully removed.");
                } else if (answer.equals("n")) {
                    System.out.println("No changes have been made");
                }
                try {
                    saveCustomerText();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("There are no customers to remove.");
        }
    }

    public void removeRoom() {

        if (!arrListRoom.isEmpty()) {
            for (Room post : arrListRoom) {
                System.out.println(post);
            }
            try {
                System.out.print("Enter the number of the room you would like to remove: ");
                int roomNr = Integer.parseInt(input.nextLine());
                arrListRoom.removeIf(element -> element.getRoomNumber() == roomNr);
                saveRoomText();
                System.out.println("Successfully removed room " + roomNr + ".");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        } else {
            System.out.println("There are no rooms to remove.");
        }
    }

    public void editCustomer() throws IOException {
        if (!arrListCustomer.isEmpty()) {
            for (Customer element : arrListCustomer) {
                System.out.println(element);
            }
            System.out.print("Enter the SSN of the customer you would like to edit: ");
            String inputSSN = input.nextLine();
            if (customerExists(inputSSN)) {
                System.out.println();
                for (Customer element : arrListCustomer) {
                    if (element.getSsn().equals(inputSSN)) {

                        System.out.println("What type of information would you like to edit of customer " + arrListCustomer.get(arrListCustomer.indexOf(element)) + "?");
                        System.out.println("1. SSN");
                        System.out.println("2. Name");
                        System.out.println("3. Address");
                        System.out.println("4. Telephone number");

                        boolean cont = true;
                        do {
                            String choice = input.nextLine();
                            if (choice.equals("1")) {
                                System.out.print("Enter new SSN: ");
                                String newSSN = input.nextLine();
                                Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                custChange.setSsn(newSSN);
                                saveCustomerText();
                                System.out.println("Successfully changed customers SSN.");
                                cont = false;
                            } else if (choice.equals("2")) {
                                System.out.print("Enter new name: ");
                                String newName = input.nextLine();
                                Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                custChange.setName(newName);
                                saveCustomerText();
                                System.out.println("Successfully changed customers name.");
                                cont = false;
                            } else if (choice.equals("3")) {
                                System.out.print("Enter new address: ");
                                String newAddress = input.nextLine();
                                Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                custChange.setAddress(newAddress);
                                saveCustomerText();
                                System.out.println("Successfully changed customers address.");
                                cont = false;
                            } else if (choice.equals("4")) {
                                System.out.print("Enter new telephone nr: ");
                                String newNr = input.nextLine();
                                Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                custChange.setTelephoneNumber(newNr);
                                saveCustomerText();
                                System.out.println("Successfully changed customers telephone number.");
                                cont = false;
                            }
                        } while (cont);
                    }
                }
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

    public void getRooms() {
        if (arrListRoom.size() > 0) {
            for (Room print : arrListRoom) {
                System.out.println(print);
            }
        } else {
            System.out.println("There are no rooms created to view.");
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
            System.out.println("There are no available rooms to view.");
        }
    }

    private boolean roomNumberExists(Integer roomNumber) {
        for (Room element : arrListRoom) {
            if (element.getRoomNumber() == (roomNumber)) {
                System.out.println("Room information: " + element);
                return true;
            }
        }
        System.out.println("That room does not exist.");
        return false;
    }

    private boolean customerExists(String customerSsn) {
        for (Customer element : arrListCustomer) {
            if (element.getSsn().equals(customerSsn)) {
                System.out.println("Customer information: " + element);
                return true;
            }
        }
        System.out.println("SSN is not in system.");
        return false;
    }

    public void searchBooking() {
        if (arrListRoom.size() > 0) {
            System.out.print("Enter SSN: ");
            String ssn = input.nextLine();
            if (isCustomerCreated(ssn)) {
                for (Room room : arrListRoom) {
                    if (ssn.equals(room.getBookedBy())) {
                        System.out.println(room);
                    }
                }
            } else {
                System.out.println("Customer not registered.");
            }
        } else {
            System.out.println("No rooms created");
        }
    }

    public void checkInCustomer() {
        try {
            boolean cont = true;
            Date currentDate = new Date();
            if (arrListCustomer.size() <= 0) {
                System.out.println("No customers in the system.");
            } else {
                for (Customer element : arrListCustomer) {
                    System.out.println(element);
                }
                System.out.print("Enter SSN of the customer you would like to check-in: ");
                String ssn = input.nextLine();
                boolean exists = customerExists(ssn);
                if (exists) {
                    if (arrListRoom.size() <= 0) {
                        System.out.println("No rooms to book.");
                    } else {
                        getAvailableRooms();
                        System.out.print("Enter the number of the room which you would like to book: ");
                        int choice = input.nextInt();
                        if (roomNumberExists(choice)) {

                            do {
                                Date checkInDate = null;
                                do {
                                    System.out.print("What date do you want to check-in (dd-mm-yyyy): ");
                                    String userDate = input.next();
                                    try {
                                        checkInDate = dateFormat.parse(userDate);

                                    } catch (ParseException ex) {
                                        System.out.println("Invalid date.");
                                    }
                                } while (checkInDate == null);
                                if (checkInDate.compareTo(currentDate) < 0) {
                                    System.out.println("Entered date has to be at least one day from now.");
                                } else {
                                    Date checkOutDate = null;
                                    do {
                                        System.out.print("What date do you want to check out (dd-mm-yyyy): ");
                                        String userDate = input.next();
                                        try {
                                            checkOutDate = dateFormat.parse(userDate);
                                        } catch (ParseException e) {
                                            System.out.println("Invalid date.");
                                        }
                                    } while (checkOutDate == null);
                                    if (checkOutDate.getTime() - checkInDate.getTime() <= 0) {
                                        System.out.println("Entered date has to be at least one day more than check-in Date.");
                                    } else {
                                        input.nextLine();
                                        cont = false;
                                        System.out.println("-- Confirm Check-In --");
                                        System.out.println("Do you want to book " + ssn + " to room number: " + choice + "?");
                                        System.out.print("Check-in Date: ");
                                        System.out.println(dateFormat.format(checkInDate));
                                        System.out.print("Check-out Date: ");
                                        System.out.println(dateFormat.format(checkOutDate));
                                        ;
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        String answer = input.nextLine();
                                        if (answer.equals("1")) {
                                            for (Room room : arrListRoom) {
                                                if (room.getRoomNumber() == choice) {
                                                    room.setBooked(true);
                                                    room.setBookedBy(ssn);
                                                    try {
                                                        saveRoomText();
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            int bookingId = 0;
                                            double totalPrice;
                                            long days;
                                            days = Math.abs((checkInDate.getTime() - checkOutDate.getTime()) / 86400000);
                                            for (Booking booking : arrListBookings) {
                                                bookingId = booking.getBookingId() + 1;
                                            }
                                            totalPrice = getCustomerRoom(ssn).getPricePerNight() * days;
                                            arrListBookings.add(new Booking(bookingId, checkInDate, checkOutDate, totalPrice, ssn));
                                            try {
                                                saveBookingText();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            System.out.println("Successfully booked customer.");
                                        } else if (answer.equals("2")) {
                                            System.out.println("No booking has been done.");
                                        }
                                    }
                                }
                            } while (cont);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Please try again.");
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

    public void checkOutCustomer() throws IOException {
        if (arrListCustomer.size() > 0) {
            for (Customer element : arrListCustomer) {
                System.out.println(element);
            }
            System.out.print("Enter the social security number of the customer who wishes to check out: ");
            String ssn = input.nextLine();
            boolean exists = customerExists(ssn);
            if (exists) {
                listCustomerRooms(ssn);

                System.out.println("Do you wish to check out?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                String option = input.nextLine();
                if (option.equals("1")) {
                    for (Room room : arrListRoom) {
                        if (room.isBookedBy(ssn)) {
                            room.setBooked(false);
                            room.setBookedBy(null);
                            saveRoomText();
                        }
                    }
                    arrListRecordBooking.addAll(arrListBookings);
                    arrListBookings.removeIf(booking -> booking.getBookedBy().equals(ssn));
                    saveBookingText();
                    System.out.println("The customer has successfully checked out.");
                } else if (option.equals("2")) {
                    System.out.println("Cancelled.");
                } else {
                    System.out.println("Please make a valid input.");
                }
            }
        } else {
            System.out.println("No customers in the system.");
        }
    }

    public void editRoom() throws IOException {
        for (Room element : arrListRoom) {
            System.out.println(element);
        }
        try {
            System.out.print("Enter the number of the room you would like to edit: ");
            String choice = input.nextLine();
            for (Room element : arrListRoom) {
                if (element.getRoomNumber() == Integer.parseInt(choice)) {
                    System.out.println("-- Edit Room --");
                    System.out.println("1. Edit bed amount");
                    System.out.println("2. Add customer note");
                    System.out.print("Choose option: ");
                    String option = input.nextLine();
                    if (option.equals("1")) {
                        System.out.println("The room currently has " + element.getNumberOfBeds() + " beds.");
                        System.out.print("Enter new amount of beds (1-3): ");
                        try {
                            int beds = input.nextInt();
                            input.nextLine();
                            element.setNumberOfBeds(beds);
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a number.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Please enter a number between 1-3.");
                        }
                        System.out.println("Number of beds successfully changed.");
                        saveRoomText();
                    } else if (option.equals("2")) {
                        System.out.print("Enter customer note to add: ");
                        String note = input.nextLine();
                        element.setCustomerNote(note);
                        System.out.println("Note successfully added.");
                        saveRoomText();
                    } else {
                        System.out.println("Please enter a proper number.");
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("\n" + "Please try again.");
            editRoom();
        }
    }

    public void editBooking() {

        if (!arrListBookings.isEmpty()) {
            for (Booking element : arrListBookings) {
                System.out.println("ID: " + element);
            }
            try {
                System.out.print("Enter the ID of the Booking you would like to edit: ");
                int editIndex = Integer.parseInt(input.nextLine());

                for (Booking element : arrListBookings) {
                    if (element.getBookingId() == editIndex) {
                        System.out.println("1. Booking ID");
                        System.out.println("2. Check-in date");
                        System.out.println("3. Check-out date");
                        System.out.println("4. Total price");
                        System.out.print("Enter option to edit for BookID " + element.getBookingId() + ": ");
                        String menuChoice = input.nextLine();
                        if (menuChoice.equals("1")) {
                            System.out.print("Enter new Booking ID: ");
                            int newBookingID = input.nextInt();
                            element.setBookingId(newBookingID);
                            System.out.println("Successfully changed Booking ID.");
                            saveBookingText();
                        } else if (menuChoice.equals("2")) {
                            System.out.print("Enter new Check-in date (dd-mm-yyyy): ");
                            String newCheckIn = input.nextLine();
                            Date newCheckIn2 = null;
                            try {
                                newCheckIn2 = dateFormat.parse(newCheckIn);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            element.setCheckInDate(newCheckIn2);
                            saveBookingText();
                            System.out.println("Successfully changed check-in date.");
                        } else if (menuChoice.equals("3")) {
                            System.out.print("Enter new Check-out date (dd-mm-yyyy): ");
                            String newCheckOut = input.nextLine();
                            Date newCheckOut2 = null;
                            try {
                                newCheckOut2 = dateFormat.parse(newCheckOut);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            element.setCheckOutDate(newCheckOut2);
                            saveBookingText();
                            System.out.println("Successfully changed check-out date.");
                        } else if (menuChoice.equals("4")) {
                            System.out.print("Enter new total price: ");
                            double newTotalPrice = input.nextDouble();
                            element.setTotalPrice(newTotalPrice);
                            saveBookingText();
                            System.out.println("Successfully changed total price.");
                        }
                    }
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a number.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter an ID that exists.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There are no bookings to edit.");
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

        if (!arrListBookings.isEmpty()) {
            for (Room element : arrListRoom) {
                if (element.isBooked()) {
                    System.out.println(element);
                }
            }
            System.out.print("Enter the number of the room which you would like to cancel booking: ");
            try {
                int cancelBooking = Integer.parseInt(input.nextLine());
                arrListRoom.get(cancelBooking).setBooked(false);
                arrListRoom.get(cancelBooking).setBookedBy(null);
                arrListRoom.get(cancelBooking).setCustomerNote(null);
                saveRoomText();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter a number.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a valid number.");
            }
            System.out.println("Booking successfully cancelled.");
        } else {
            System.out.println("There are no bookings to cancel.");
        }
    }

    public void customerMenuCheckIn() throws IOException {
        boolean cont = true;
        do {
            System.out.print("\n" + "Enter ssn YYYYMMDDXXXX: ");
            String ssn = input.nextLine();
            if (ssn.matches("[0-9]+")) {
                if (ssn.equals("")) {
                    System.out.println("No ssn was entered, try again.");
                    break;
                }
                System.out.print("Enter name: ");
                String name = input.nextLine();
                if (name.matches("[A-Za-z]+")) {
                    if (name.equals("")) {
                        System.out.println("No name was entered, try again.");
                        break;
                    }
                    System.out.print("Enter address: ");
                    String address = input.nextLine();
                    if (address.equals("")) {
                        System.out.println("No address was entered, try again.");
                        break;
                    }
                    System.out.print("Enter telephone-number: ");
                    String telephoneNumber = input.nextLine();
                    if (telephoneNumber.matches("[0-9]+")) {
                        if (telephoneNumber.equals("")) {
                            System.out.println("No telephone-number was entered, try again.");
                            break;
                        }

                        isCustomerCreated(ssn);
                        if (isCustomerCreated(ssn)) {
                            System.out.println("That SSN already exists.");
                        } else {
                            boolean successful = true;
                            do {
                                System.out.println("\n" + "Is all information correct? (y/n)");
                                System.out.print("> ");
                                String answer = input.nextLine();
                                if (answer.equals("y")) {
                                    arrListCustomer.add(new Customer(ssn, name, address, telephoneNumber));
                                    saveCustomerText();
                                    cont = false;
                                    successful = false;
                                } else if (answer.equals("n")) {
                                    customerMenuCheckIn();
                                } else {
                                    System.out.println("That is not a valid option. Please try again.");
                                }
                            } while (successful);
                        }
                    } else {
                        System.out.println("Please only enter numbers");
                    }
                } else {
                    System.out.println("Please only enter characters");
                }
            } else {
                System.out.println("Please only enter numbers");
            }
        } while (cont);
    }

    public void previousBooking() {
        System.out.print("Enter your SSN (YYYYMMDDXXXX): ");
        String ssn = input.nextLine();
        System.out.println();
        for (Customer element : arrListCustomer) {
            if (element.getSsn().equals(ssn)) {
                System.out.println("Current booking: ");
                for (Booking booking : arrListBookings) {
                    if (booking.getBookedBy().equals(ssn)) {
                        System.out.println(booking);
                    }
                }
                System.out.println();
                System.out.println("Previous bookings:");
                for (Booking element2 : arrListRecordBooking) {
                    if (element2.getBookedBy().equals(ssn)) {
                        System.out.println(element2);
                    }
                }
            }
        }
    }

    public void saveBookingText() throws IOException {
        File fileName = new File("Bookings.txt");
        try {
            FileWriter fw = new FileWriter(fileName);
            Writer output = new BufferedWriter(fw);

            int sz = arrListBookings.size();

            for (int i = 0; i < sz; i++) {
                output.write(arrListBookings.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }

    public void saveCustomerText() throws IOException {
        File fileName = new File("Customers.txt");
        try {
            FileWriter fw = new FileWriter(fileName);
            Writer output = new BufferedWriter(fw);

            int sz = arrListCustomer.size();

            for (int i = 0; i < sz; i++) {
                output.write(arrListCustomer.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }

    public void saveRoomText() throws IOException {
        File fileName = new File("Rooms.txt");
        try {
            FileWriter fw = new FileWriter(fileName);
            Writer output = new BufferedWriter(fw);

            int sz = arrListRoom.size();

            for (int i = 0; i < sz; i++) {
                output.write(arrListRoom.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }

    public void readBookingText() throws IOException, ParseException {

        BufferedReader bkReader = new BufferedReader(new FileReader("Bookings.txt"));

        for (String line = bkReader.readLine(); line != null; line = bkReader.readLine()) {
            String[] data = line.split(",");
            int bookingId = Integer.parseInt(data[0].split(": ")[1]);
            Date checkInDate = dateFormat.parse(data[1].split(": ")[1]);
            Date checkOutDate = dateFormat.parse(data[2].split(": ")[1]);
            double totalPrice = Double.parseDouble(data[3].split(": ")[1]);
            String bookedBy = data[4].split(": ")[1];
            arrListBookings.add(new Booking(bookingId, checkInDate, checkOutDate, totalPrice, bookedBy));
        }
    }


    public void readCustomerText() throws IOException, ParseException {

        BufferedReader custReader = new BufferedReader(new FileReader("Customers.txt"));

        for (String line = custReader.readLine(); line != null; line = custReader.readLine()) {
            String[] data = line.split(",");
            String ssn = data[0].split(": ")[1];
            String name = data[1].split(": ")[1];
            String address = data[2].split(": ")[1];
            String telephoneNumber = data[3].split(": ")[1];
            arrListCustomer.add(new Customer(ssn, name, address, telephoneNumber));
        }
    }

    public void readRoomText() throws IOException, ParseException {

        BufferedReader roomReader = new BufferedReader(new FileReader("Rooms.txt"));

        for (String line = roomReader.readLine(); line != null; line = roomReader.readLine()) {
            String[] data = line.split(",");
            int roomNumber = Integer.parseInt(data[0].split(": ")[1]);
            int numberOfBeds = Integer.parseInt(data[1].split(": ")[1]);
            boolean hasBalcony = Boolean.parseBoolean(data[2].split(": ")[1]);
            double pricePerNight = Double.parseDouble(data[3].split(": ")[1]);
            boolean isBooked = Boolean.parseBoolean(data[4].split(": ")[1]);
            String bookedBy = (data[5].split(": ")[1]);
            String customerNote = (data[6].split(": ")[1]);
            arrListRoom.add(new Room(roomNumber, numberOfBeds, hasBalcony, pricePerNight, isBooked, bookedBy, customerNote));
        }
    }

    public void showBookingsBetweenDates() throws ParseException {
        if (!arrListBookings.isEmpty()) {

            for (Booking element : arrListBookings) {
                System.out.println(element);
            }
            try {
                System.out.print("Enter the first date you would like to search from (dd-mm-yyyy): ");
                String dateInput = input.nextLine();
                Date dateFrom = dateFormat.parse(dateInput);
                System.out.print("Enter the second date you would like to search to (dd-mm-yyyy): ");
                String dateInput2 = input.nextLine();
                Date dateTo = dateFormat.parse(dateInput2);

                if (!arrListBookings.isEmpty())
                    System.out.println("Bookings between " + dateInput + " and " + dateInput2 + ":");

                for (Booking element : arrListBookings) {
                    if (dateFrom.before(element.getCheckInDate()) && dateTo.after(element.getCheckInDate())) {
                        System.out.println(element);
                    }
                }
            } catch (ParseException e) {
                System.out.println("Invalid date specified, please try again.");
            }
        } else {
            System.out.println("There are no bookings to view.");
        }
    }

    public void applyCoupon() throws IOException {
        if (!arrListBookings.isEmpty() && !arrListCustomer.isEmpty()) {
            System.out.print("Enter your SSN: ");
            String userSSN = input.nextLine();

            for (Booking element : arrListBookings) {

                if (element.getBookedBy().equals(userSSN)) {
                    System.out.println("Current price: " + element.getTotalPrice());
                    System.out.print("Enter coupon code to get 20% off: ");
                    String coupon = input.nextLine();
                    if (coupon.equals("NYSTART")) {
                        double discount = element.getTotalPrice() - (20 * element.getTotalPrice() / 100);
                        element.setTotalPrice(discount);
                        saveBookingText();
                        System.out.println("Price is now: " + element.getTotalPrice());
                    } else {
                        System.out.println("Coupon code not recognized.");
                    }
                } else {
                    System.out.println("That customer has not made a booking.");
                }
            }
        } else {
            System.out.println("There are no bookings or customers.");
        }
    }

    public void customerEditCustomer() throws IOException {
        if (!arrListCustomer.isEmpty()) {

            System.out.print("Enter your ssn: ");
            String inputSSN = input.nextLine();
            if (customerExists(inputSSN)) {
                System.out.println();
                for (Customer element : arrListCustomer) {
                    if (element.getSsn().equals(inputSSN)) {
                        System.out.println("What type of information would you like to edit of customer " + arrListCustomer.get(arrListCustomer.indexOf(element)) + "?");
                        System.out.println("1. SSN");
                        System.out.println("2. Name");
                        System.out.println("3. Address");
                        System.out.println("4. Telephone number");

                        boolean cont = true;
                        do {
                            String choice = input.nextLine();
                            if (choice.equals("1")) {
                                do {
                                    System.out.print("Enter new SSN: ");
                                    String newSSN = input.nextLine();
                                    if (newSSN.matches("[0-9]+")) {
                                        Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                        custChange.setSsn(newSSN);
                                        saveCustomerText();
                                        System.out.println("Successfully changed customers SSN.");
                                        cont = false;
                                    } else {
                                        System.out.println("Please only enter numbers.");
                                    }
                                } while (cont);
                            } else if (choice.equals("2")) {
                                do {
                                    System.out.print("Enter new name: ");
                                    String newName = input.nextLine();
                                    if (newName.matches("[A-Za-z]+")) {
                                        Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                        custChange.setName(newName);
                                        saveCustomerText();
                                        System.out.println("Successfully changed customers name.");
                                        cont = false;
                                    } else {
                                        System.out.println("Please only enter characters.");
                                    }
                                } while (cont);
                            } else if (choice.equals("3")) {
                                System.out.print("Enter new address: ");
                                String newAddress = input.nextLine();
                                Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                custChange.setAddress(newAddress);
                                saveCustomerText();
                                System.out.println("Successfully changed customers address.");
                                cont = false;
                            } else if (choice.equals("4")) {
                                do {
                                    System.out.print("Enter new telephone nr: ");
                                    String newNr = input.nextLine();
                                    if (newNr.matches("[0-9]+")) {
                                        Customer custChange = arrListCustomer.get(arrListCustomer.indexOf(element));
                                        custChange.setTelephoneNumber(newNr);
                                        saveCustomerText();
                                        System.out.println("Successfully changed customers telephone number.");
                                        cont = false;
                                    } else {
                                        System.out.println("Please only enter numbers.");
                                    }
                                } while (cont);
                            } else {
                                System.out.println("Please enter a proper number.");
                            }
                        } while (cont);
                    }
                }
            }
        } else {
            System.out.println("There are no customers to edit.");
        }
    }

    public void customerCheckInCustomer() {
        try {
            boolean cont = true;
            Date currentDate = new Date();
            if (arrListCustomer.size() <= 0) {
                System.out.println("No customers in the system.");
            } else {
                System.out.print("Enter your ssn: ");
                String ssn = input.nextLine();
                boolean exists = customerExists(ssn);
                if (exists) {
                    if (arrListRoom.size() <= 0) {
                        System.out.println("No rooms to book.");
                    } else {
                        getAvailableRooms();
                        System.out.print("Enter the number of the room which you would like to book: ");
                        int choice = input.nextInt();
                        if (roomNumberExists(choice)) {

                            do {
                                Date checkInDate = null;
                                do {
                                    System.out.print("What date do you want to check-in (dd-mm-yyyy): ");
                                    String userDate = input.next();
                                    try {
                                        checkInDate = dateFormat.parse(userDate);

                                    } catch (ParseException ex) {
                                        System.out.println("Invalid date.");
                                    }
                                } while (checkInDate == null);
                                if (checkInDate.compareTo(currentDate) < 0) {
                                    System.out.println("Entered date has to be at least one day from now.");
                                } else {
                                    Date checkOutDate = null;
                                    do {
                                        System.out.print("What date do you want to check out (dd-mm-yyyy): ");
                                        String userDate = input.next();
                                        try {
                                            checkOutDate = dateFormat.parse(userDate);
                                        } catch (ParseException e) {
                                            System.out.println("Invalid date.");
                                        }
                                    } while (checkOutDate == null);
                                    if (checkOutDate.getTime() - checkInDate.getTime() <= 0) {
                                        System.out.println("Entered date has to be at least one day more than check-in Date.");
                                    } else {
                                        input.nextLine();
                                        cont = false;
                                        System.out.println("-- Confirm Check-In --");
                                        System.out.println("Do you want to book " + ssn + " to room number: " + choice + "?");
                                        System.out.print("Check-in Date: ");
                                        System.out.println(dateFormat.format(checkInDate));
                                        System.out.print("Check-out Date: ");
                                        System.out.println(dateFormat.format(checkOutDate));
                                        ;
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        String answer = input.nextLine();
                                        if (answer.equals("1")) {
                                            for (Room room : arrListRoom) {
                                                if (room.getRoomNumber() == choice) {
                                                    room.setBooked(true);
                                                    room.setBookedBy(ssn);
                                                    try {
                                                        saveRoomText();
                                                    } catch (IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            int bookingId = 0;
                                            double totalPrice;
                                            long days;
                                            days = Math.abs((checkInDate.getTime() - checkOutDate.getTime()) / 86400000);
                                            for (Booking booking : arrListBookings) {
                                                bookingId = booking.getBookingId() + 1;
                                            }
                                            totalPrice = getCustomerRoom(ssn).getPricePerNight() * days;
                                            arrListBookings.add(new Booking(bookingId, checkInDate, checkOutDate, totalPrice, ssn));
                                            try {
                                                saveBookingText();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            System.out.println("Successfully booked customer.");
                                        } else if (answer.equals("2")) {
                                            System.out.println("No booking has been done.");
                                        }
                                    }
                                }
                            } while (cont);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Please try again.");
        }
    }

    public void customerCheckOutCustomer() throws IOException {
        if (arrListCustomer.size() > 0) {
            System.out.print("Enter the social security number of the customer who wishes to check out: ");
            String ssn = input.nextLine();
            boolean exists = customerExists(ssn);
            if (exists) {
                listCustomerRooms(ssn);

                System.out.println("Do you wish to check out?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                String option = input.nextLine();
                if (option.equals("1")) {
                    for (Room room : arrListRoom) {
                        if (room.isBookedBy(ssn)) {
                            room.setBooked(false);
                            room.setBookedBy(null);
                            saveRoomText();
                        }
                    }
                    arrListRecordBooking.addAll(arrListBookings);
                    arrListBookings.removeIf(booking -> booking.getBookedBy().equals(ssn));
                    saveBookingText();
                    System.out.println("The customer has successfully checked out.");
                } else if (option.equals("2")) {
                    System.out.println("Cancelled.");
                } else {
                    System.out.println("Please make a valid input.");
                }
            }
        } else {
            System.out.println("No customers in the system.");
        }
    }
}