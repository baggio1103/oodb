package lab8.hotel;

import lab8.annotation.*;

@Entity
public class Room implements BaseEntity{

    @Id
    private Long id;

    @Column
    private Long roomCount;

    @Column
    @OneToOne
    private Client client;

    @Column
    @ManyToOne
    private Reception reception;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Long roomCount) {
        this.roomCount = roomCount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    @Override
    public String toString() {
        return "" + id + "";
    }


    public String getDescription() {
        return "Room{" +
                "id=" + id +
                ", roomCount=" + roomCount +
                ", client=" + client.getDescription() +
                ", reception=" + reception.getDescription() +
                '}';
    }

}
