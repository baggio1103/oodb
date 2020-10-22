package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hotel")
public class Hotel {
    private String name;
    private int stars;

    private Reception reception;

    public Hotel(String name, int stars, Reception reception) {
        this.name = name;
        this.stars = stars;
        this.reception = reception;
    }

    public Hotel() {
    }

    @XmlElement(name = "reception")
    public Reception getReception() {
        return reception;
    }


    public int getStars() {
        return stars;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hotel.Hotel{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", reception=" + reception.getReceptionist().toString() +
                '}';
    }
}
