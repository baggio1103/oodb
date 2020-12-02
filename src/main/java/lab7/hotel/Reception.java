package lab7.hotel;
import lab6.annotation.Column;
import lab6.annotation.Entity;

@Entity
public class Reception {
    @Column
    private Long id;

    @Column
    private String name;

    @Override
    public String toString() {
        return "Reception{" +
                "id=" + id +
                '}';
    }

}
