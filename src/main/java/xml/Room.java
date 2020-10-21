package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Room {
    private int number;
    private double cost;
    private int roomCount;
    private Client client;
    private boolean isReserved;

    public Room(int number, double cost, int roomCount){
        this.number = number;
        this.cost = cost;
        this.roomCount = roomCount;
        this.isReserved = false;
        this.client = null;
    }

    public Room(){

    }

    @XmlElement(name = "roomNumber")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlElement(name = "roomCost")
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @XmlElement(name = "roomCount")
    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @XmlElement(name = "client")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @XmlElement(name = "isRoomReserved")
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Hotel.Room{" +
                "number=" + number +
                ", cost=" + cost +
                ", roomCount=" + roomCount +
                ", client=" + client +
                ", isReserved=" + isReserved +
                '}';
    }

}
