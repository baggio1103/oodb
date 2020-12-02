package lab7.hotel;
import lab6.annotation.Column;
import lab6.annotation.Entity;

@Entity
public class Client {

    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private int roomCount;


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", room_count=" + roomCount +
                '}';
    }

    public Client(Long id, String name, int roomCount, double cash) {
        this.id = id;
        this.name = name;
        this.roomCount = roomCount;
    }
}
