package lab2;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JsonLoadSave {

    public static Hotel loadHotel(String path) throws IOException {
        Hotel hotel;
        File file = new File(path);
        String hotelString = "";

        if (file.exists()){
            hotelString = new String(Files.readAllBytes(file.toPath()));
        }
        hotel = new Gson().fromJson(hotelString, Hotel.class);

        return hotel;
    }


    public static void saveRoomList(Room[] rooms) throws IOException {
        if (rooms != null){
            Gson gson = new Gson();
            String roomAsGson = gson.toJson(rooms);

            System.out.println(roomAsGson);

            try(OutputStream os = new FileOutputStream(new File("rooms.json"))){
                os.write(roomAsGson.getBytes(StandardCharsets.UTF_8));
                os.flush();
            }

        }
    }

    public static void saveHotel(Hotel hotel) throws IOException {
        if (hotel != null){
            Gson gson = new Gson();
            String hotelAsGson = gson.toJson(hotel);
            System.out.println(hotelAsGson);
            try(OutputStream os = new FileOutputStream(new File("hotel.json"))){
                os.write(hotelAsGson.getBytes(StandardCharsets.UTF_8));
                os.flush();
            }

        }
    }


}
