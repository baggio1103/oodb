package xml;

public class Client extends Person {
    private double cash;
    private int roomCountWanted;

    public Client(String firstName, String lastName, String phoneNumber, String email, double cash, int roomWanted) {
        super(firstName, lastName, phoneNumber, email);
        this.cash = cash;
        this.roomCountWanted = roomWanted;
    }

    public Client() {

    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getRoomCountWanted() {
        return roomCountWanted;
    }

    public void setRoomCountWanted(int roomWanted) {
        this.roomCountWanted = roomWanted;
    }

    public void pay(Room room) {
        System.out.println("The Hotel.Client has paid for the room!");
        this.cash -= room.getCost();
    }

    @Override
    public String toString() {
        return "Hotel.Client{" + "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", cash=" + cash +
                ", roomWanted=" + roomCountWanted +
                '}';
    }
}
