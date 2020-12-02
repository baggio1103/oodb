package lab6.hotel;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.OneToMany;

@Entity
public class Reception {

    @Column
    @OneToMany
    private Client[] clients;

    @Column
    @OneToMany
    private Room[] rooms;

    @Column
    @OneToMany
    private Staff staff;

    @Column
    private int currentFreeRoom = 0;

    @Column
    private int roomIndex = -1;

    public Reception( Staff staff){
        this.staff = staff;
        int numberOfRooms = 10;
        clients = new Client[numberOfRooms];
        rooms = new Room[numberOfRooms];
        loadRooms();
    }

    public Reception(){

    }

    public void reserve(Client client){
        if (areRoomsAvailable()) {
            int roomCountWanted = client.getRoomCountWanted();
            if (isTheRoomFree(roomCountWanted) && hasClientEnoughMoney(client,rooms[roomIndex])){
                staff.reserve(client, rooms[roomIndex]);
                clients[roomIndex] = client;
                currentFreeRoom ++;
            }
        }else {
            System.out.println("All the rooms are reserved!");
        }
    }

    public boolean areRoomsAvailable(){
        return currentFreeRoom < 10;
    }

    public int searchRoomByRoomCount(int roomCount){
        for (int i = 0; i < rooms.length; i++){
            Room room = rooms[i];
            if (room.getRoomCount() == roomCount && !room.isReserved()){
                roomIndex = i;
                return roomIndex;
            }
        }
        roomIndex = -1;
        return roomIndex; //no such room or the room is reserved
    }

    public boolean isTheRoomFree(int roomCount){
        if (searchRoomByRoomCount(roomCount) >= 0){
            return true;
        }else {
            System.out.println("The room you want is reserved!");
            return false;
        }
    }

    public boolean hasClientEnoughMoney(Client client, Room room){
        if (client.getCash() >= room.getCost()){
            return true;
        }else {
            System.out.println("You have no sufficient amount of money");
            return false;
        }
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void printRoomDetails(){
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] != null){
                Room room = rooms[i];
                Client client = room.getClient();
                System.out.println(room.toString());
                printClientInfo(client);
            }
        }
    }

    void printClientInfo(Client client){
        if (client != null){
            System.out.println(client.toString());
        }
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Client searchClientByName(String firstName, String lastName){
        for (Client client : clients){
            if (client != null) {
                if (client.getFirstName().equals(firstName) && client.getLastName().equals(lastName)) {
                    return client;
                }

                if (client.getFirstName().equals(lastName) && client.getLastName().equals(firstName)) {
                    return client;
                }
                //this condition enables to find a person
                // if their details are confused i.e.
                // instead of last time is used firstname
            }
        }
        return null;
    }

    public void loadRooms(){
        rooms[0] = new Room(111, 199, 2);
        rooms[1] = new Room(122, 211, 2);
        rooms[2] = new Room(133, 159, 1);
        rooms[3] = new Room(221, 220, 2);
        rooms[4] = new Room(222, 239, 3);
        rooms[5] = new Room(232, 200, 1);
        rooms[6] = new Room(331, 250, 3);
        rooms[7] = new Room(332, 220,2);
        rooms[8] = new Room(333, 299, 3);
        rooms[9] = new Room(441, 350,4);
    }

}
