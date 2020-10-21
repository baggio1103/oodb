package Hotel;

public class Demo {

    public static void main(String[] args) {
        Staff chris = new Staff("Chris", "Bale", "4623108", "chris@gmail.com");
        Client client = new Client("Tony","Stark","+79869334644", "stark@mail.com", 1000, 2);
        Reception reception = new Reception(chris);
        Hotel hotel = new Hotel("MGM-Grand", 5, reception);
        System.out.println("Welcome to Our Hotel.Hotel!\n"+hotel.toString());
        System.out.println("\nReserving room!\n");
        reception.reserve(client);
        System.out.println();
        System.out.println(client.toString()+"\n");


        Client test = reception.searchClientByName("Tony", "Stark");
//        Client test = reception.searchClientByName("Stark", "Tony");

        if (test != null){
            System.out.println(test.toString());
        }else {
            System.out.println(test);
        }

    }

}
