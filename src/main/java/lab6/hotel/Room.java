package lab6.hotel;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.OneToOne;

@Entity
public class Room {

    @Column
    private int number;

    @Column
    private double cost;

    @Column
    private int roomCount;

    @Column
    @OneToOne
    private Client client;

    @Column
    private boolean isReserved;

    public Room(int number, double cost, int roomCount){
        this.number = number;
        this.cost = cost;
        this.roomCount = roomCount;
        this.isReserved = false;
        this.client = null;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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
