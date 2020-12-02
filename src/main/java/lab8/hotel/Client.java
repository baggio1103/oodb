package lab8.hotel;

import lab8.annotation.Column;
import lab8.annotation.Entity;
import lab8.annotation.Id;

@Entity
public class Client implements BaseEntity{
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private int roomCount;

    public Client() {
    }

    public Client(Long id, String name, int roomCount, double cash) {
        this.id = id;
        this.name = name;
        this.roomCount = roomCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @Override
    public String toString() {
        return "" + id + "";
    }

    public String getDescription() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email +
                ", room_count=" + roomCount +
                '}';
    }

}
