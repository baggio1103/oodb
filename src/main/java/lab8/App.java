package lab8;

import lab8.hotel.Client;
import lab8.hotel.Reception;
import lab8.orm.EntityManager;
import lab8.orm.EntityManagerFactory;
import lab8.orm.EntityManagerImpl;

import java.util.Properties;

public class App {

    public static void main(String[] args) {


        Properties properties = new Properties();
        properties.put("url", "jdbc:postgresql://localhost/hotel");
        properties.put("user", "postgres");
        properties.put("password", "xdubivxb");

        EntityManagerFactory factory = new EntityManagerFactory(properties);

        EntityManager entityManager = factory.createEntityManager();

//        Reception reception = new Reception();
//        reception.setId((long) 3);
//        reception.setName("The Hilton Reception");
//
//        Hotel hotel = new Hotel();
//        hotel.setName("The Korston Tower");
//        hotel.setStars(5L);
//        hotel.setReception(reception);

//        entityManager.persist(reception);
//        entityManager.persist(hotel);
//        entityManager.remove(reception);

//        Staff staff = new Staff();
//        staff.setName("Dave");
//        staff.setEmail("dave@gmail.com");
//        staff.setReception(reception);
//        entityManager.persist(staff);
//        entityManager.find(Reception.class, 3);
//        entityManager.find(Staff.class, 1);
//        entityManager.remove(staff);

//        Client client = new Client();
//        client.setEmail("BackhamDavid@mail.ru");
//        client.setName("David");
//        client.setRoomCount(3);

//        entityManager.merge(client,2);

//        Reception recep = (Reception) entityManager.find(Reception.class, 3);
//        entityManager.remove(recep);
//        Hotel hotel = (Hotel) entityManager.find(Hotel.class, 3);



        Reception reception = (Reception) entityManager.find(Reception.class, 4);
        System.out.println(reception.getDescription());

        reception.setName("Hilton main reception");

        entityManager.merge(reception);

        reception = (Reception) entityManager.find(Reception.class, 4);

        System.out.println(reception.getDescription());


    }


}