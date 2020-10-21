package jdbc;

import com.google.gson.Gson;
import xml.Client;
import xml.Hotel;
import xml.Reception;
import xml.Staff;

import java.io.IOException;
import java.sql.*;

public class App {

    private static final String url = "jdbc:postgresql://localhost/Hotel";
    private static final String user = "postgres";
    private static final String password = "xdubivxb";

    public static void main(String[] args) throws SQLException, IOException {
        Staff chris = new Staff("Chris", "Bale", "4623108", "chris@gmail.com");
        Client client = new Client("Tony","Stark","+79869334644", "stark@mail.com", 1000, 2);
        Reception reception = new Reception(chris);
        Hotel hotel = new Hotel("MGM-Grand", 5, reception);
        reception.reserve(client);

        /**
        * Casting the hotel into json-format
        * and calling the method insert();
        * */
        Gson gson = new Gson();
        String sqlQuery = gson.toJson(hotel);
        Connection connection = connect();

        long startTime = System.currentTimeMillis();
        insert(connection, "hotel", "data", sqlQuery);
        long finishedTime = System.currentTimeMillis();
        long elapsedTime = finishedTime - startTime;
        System.out.println("Time elapsed for json: " +  elapsedTime+"\n");

        long start = System.currentTimeMillis();
        insert(connection, "hotel_b", "data", sqlQuery);
        long completedTime = System.currentTimeMillis();
        long dif = completedTime - start;
        System.out.println("Time elapsed for jsonb: " + dif);

    }

    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSql successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void insert(Connection connection, String table, String column, String jsonString) throws SQLException {
        String sqlInsert = "insert into "+table+" ("+column+") values (cast (? as json))";
        PreparedStatement statement = connection.prepareStatement(sqlInsert);
        statement.setString(1, jsonString);
        int rows = statement.executeUpdate();
        System.out.printf("%d rows added", rows);
        statement.close();
    }

    public static void retrieve(Connection connection, String tableName) throws SQLException {
        String sqlQuery = "Select * from " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getInt(1));
            System.out.print(":");
            System.out.println(resultSet.getString(2));
        }
    }


}
