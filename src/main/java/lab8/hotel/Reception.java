package lab8.hotel;

import lab8.annotation.Column;
import lab8.annotation.Entity;
import lab8.annotation.Id;

@Entity
public class Reception implements BaseEntity{
    @Id
    private Long id;

    @Column
    private String name;

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

    @Override
    public String toString() {
        return "" + id + "";
    }


    public String getDescription() {
        return "Reception{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
