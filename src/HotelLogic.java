import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class HotelLogic {

    private ArrayList<Room> arrListRoom = new ArrayList<Room>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public void getCustomers(ArrayList customers) {
        for (Customer post: customers) {
            System.out.println(customers);
        }
        public getCustomer(String ssn) {
            return customer;
        }

        public void createRooms(){
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

        public void getRooms(){

            for (Room post: arrListRoom
                 ) {
                System.out.println(arrListRoom);
            }
        }
    }

