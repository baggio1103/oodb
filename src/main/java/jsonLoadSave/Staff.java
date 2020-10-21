package jsonLoadSave;

public class Staff extends Person {

    public Staff(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public void reserve(Client client, Room room) {
        room.setReserved(true);
        client.pay(room);
        room.setClient(client);
    }

}
