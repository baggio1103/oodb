package Hotel;

public class Hotel {
    private String name;
    private int stars;
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
                ", reception=" + reception.getReceptionist().toString() +
                '}';
    }
}
