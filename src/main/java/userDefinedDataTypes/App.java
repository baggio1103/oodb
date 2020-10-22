package userDefinedDataTypes;

import java.sql.*;

public class App {

    private static final String url = "jdbc:postgresql://localhost/oodb";
    private static final String user = "postgres";
    private static final String password = "xdubivxb";


    public static void main(String[] args) throws SQLException {
        Connection connection = connect();
        Client client = new Client("Julia", "Roberts", "julia@gmail.com", 'F');
        String date = String.valueOf(java.time.LocalDate.now());
        insert(connection, client, date);
        select(connection, "client_table", "email");
        update(connection, "email", "chbale@gmail.com", "id", 4);
    }

    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void select(Connection connection, String table, String column) throws SQLException {
        String sqlQuery = "Select ";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        if (column.equals("")){
            sqlQuery += " * from " + table;
            preparedStatement = connection.prepareStatement(sqlQuery);
            set = preparedStatement.executeQuery();
            while (set.next()){
                System.out.print(set.getInt(1));
                System.out.print(":");
                System.out.println(set.getString(2));
            }
        }else {
            sqlQuery += "(client). client." + column + " from " + table;
            preparedStatement = connection.prepareStatement(sqlQuery);
            set = preparedStatement.executeQuery();
            while (set.next()){
                System.out.println(set.getString(1));
            }
        }
        connection.close();
    }

    public static void insert(Connection connection, Client client, String date) throws SQLException {
        PreparedStatement statement;
        String sqlQuery = "Insert into client_table(client) values ( row (row (?, ?, ?, ?), ?));";

        statement = connection.prepareStatement(sqlQuery);
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setString(3, client.getEmail());
        statement.setString(4, String.valueOf(client.getGender()));
        statement.setDate(5, Date.valueOf(java.time.LocalDate.now()));

        int row = statement.executeUpdate();
        System.out.printf("%d rows added", row);
        statement.close();
    }

    public static void update(Connection connection, String setColumn, String newValue, String columnCompared, int valueCompared) throws SQLException {
        PreparedStatement statement;
        String sqlQuery = "Update client_table set client.client."+setColumn + " = ? where " + columnCompared +" = ? ";
        statement = connection.prepareStatement(sqlQuery);
        statement.setString(1, newValue);
        statement.setInt(2, valueCompared);
        System.out.println(statement.toString());
        int row = statement.executeUpdate();
        System.out.printf("%d row added ",  row);
        statement.close();
    }

}
