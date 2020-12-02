package lab6.hotel;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.OneToOne;

@Entity
public class Hotel {

    @Column
    private String name;

    @Column
    private int stars;

    @Column
    @OneToOne
    private Reception reception;

    public Hotel(String name, int stars, Reception reception){
        this.name = name;
        this.stars = stars;
        this.reception = reception;
    }

    @Override
    public String toString() {
        return "Hotel.Hotel{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", reception=" + reception.getStaff().toString() +
                '}';
    }
}
