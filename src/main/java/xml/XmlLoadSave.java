package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlLoadSave {

    public static Hotel loadHotel(String path){
        Hotel hotel;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            hotel = (Hotel) unmarshaller.unmarshal(new File(path));
            return hotel;
        }catch (JAXBException exception){
            exception.printStackTrace();
        }
        return null;
    }


    public static void saveHotel(Hotel hotel, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(hotel, new File(path));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
