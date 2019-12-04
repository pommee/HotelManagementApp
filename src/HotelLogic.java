import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class HotelLogic {

    private ArrayList<Room> arrListRoom = new ArrayList<Room>();
    private ArrayList<Customer> arrListCustomer = new ArrayList<Customer>();

    public void getCustomers() {
        if (arrListCustomer.size() > 0) {
            for (Customer post : arrListCustomer) {
                System.out.println(post);
            }
        } else {
            System.out.println("There are currently no registered customers");
        }

        public void createRooms () {
            if (arrListRoom.size() <= 0) {
                int roomNumber = 0;
                for (int i = 0; i < 11; i++) {
                    arrListRoom.add(new Room(roomNumber, 1, 150.0, false, false));
                    roomNumber++;
                }


                if (arrListRoom.size() <= 0) {
                    for (int i = 0; i < 4; i++) {
                        arrListRoom.add(new Room(roomNumber, 1, 200.0, true, false));
                        roomNumber++;
                    }


                    if (arrListRoom.size() <= 0) {
                        for (int i = 0; i < 5; i++) {
                            arrListRoom.add(new Room(roomNumber, 2, 300.0, false, false));
                            roomNumber++;
                        }
                    }
                }
            }
        }

        public void getRooms () {

            for (Room post : arrListRoom
            ) {
                System.out.println(arrListRoom);
            }
        }

        public void getAvailableRooms () {
            for (Room room : arrListRoom) {
                if (!room.isBooked()) {
                    System.out.println(room);
                } else {
                    System.out.println("Room is booked.");
                }
            }
        }
    }
}

