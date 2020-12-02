package lab8.orm.crud;

import lab8.hotel.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Select {

    private final Connection connection;
    private final Insert insert;

    public Select(Connection connection) {
        this.connection = connection;
        insert = new Insert(connection);
    }

    public BaseEntity selectById(Class<?> object, Object var){
        if (var instanceof Integer){
            Integer id = (Integer) var;
            String sql = createSelectQuery(object);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet set = preparedStatement.executeQuery();
                if (!set.next()){
                    return null;
                }
                preparedStatement.close();
                if (object.equals(Client.class)){
                    Client client = new Client();
                    client.setId((long) set.getInt(1));
                    client.setName(set.getString(2));
                    client.setEmail(set.getString(3));
                    client.setRoomCount(set.getInt(4));
                    return client;
                }else if (object.equals(Reception.class)){
                    Reception reception = new Reception();
                    reception.setId((long) set.getInt(1));
                    reception.setName(set.getString(2));
                    return reception;
                }else if (object.equals(Hotel.class)){
                    Hotel hotel = new Hotel();
                    hotel.setId((long) set.getInt(1));
                    hotel.setName(set.getString(2));
                    hotel.setStars((long) set.getInt(3));
                    hotel.setReception((Reception) selectById(Reception.class, set.getInt(4)));
                    return hotel;
                }else if (object.equals(Room.class)){
                    Room room = new Room();
                    room.setId((long) set.getInt(1));
                    room.setRoomCount((long) set.getInt(2));
                    room.setClient((Client) selectById(Client.class, set.getInt(3)));
                    room.setReception((Reception) selectById(Reception.class, set.getInt(4)));
                    return room;
                }else if (object.equals(Staff.class)){
                    Staff staff = new Staff();
                    staff.setId((long) set.getInt(1));
                    staff.setName(set.getString(2));
                    staff.setEmail(set.getString(3));
                    staff.setReception((Reception) selectById(Reception.class, 4));
                    return staff;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public String createSelectQuery(Class<?> object) {
        String tableName = object.getSimpleName().toLowerCase();
        return "Select * from " + tableName + " where id = ?";
    }


}
