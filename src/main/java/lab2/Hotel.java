package lab2;

public class Hotel {
    private String name;
    private int stars;
    private Reception reception;

    public Hotel(String name, int stars, Reception reception){
        this.name = name;
        this.stars = stars;
        this.reception = reception;
    }

    public Reception getReception() {
        return reception;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
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
