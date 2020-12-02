package lab8.hotel;

import lab8.annotation.Column;
import lab8.annotation.Entity;
import lab8.annotation.Id;
import lab8.annotation.OneToOne;

@Entity
public class Hotel implements BaseEntity{
    @Id
    private Long id;
    @Column
    private String name;

    @Column
    private Long stars;

    @Column
    @OneToOne
    private Reception reception;

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

    public Long getStars() {
        return stars;
    }

    public void setStars(Long stars) {
        this.stars = stars;
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
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", reception=" + reception.getDescription() +
                '}';
    }

}
