package util;

import java.sql.*;

public class SqlConnection {
    public final static String url = "jdbc:postgresql://localhost:5432/";
    public final static String user = "postgres";
    public final static String pass = "12345";

    public static Connection createConnection(){
        createDb();
        try {
            return  DriverManager.getConnection(url+"stepproject2", user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static Connection checkConnection(Connection connection){
        try {
            if(connection == null || connection.isClosed()){
                connection = SqlConnection.createConnection();
            }
        } catch (SQLException e) {
            System.out.println("Can not created Database Connection");
        }
        return connection;
    }


    public static void createDb() {
        if (ifDbExists() == 0) {
            try {
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
                statement.execute("Create database StepProject2");
                System.out.println("Creating Database");
                Thread.sleep(1000);
                connection.close();
                createTables();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createTables() {
        try {
            Connection connection = DriverManager.getConnection(url + "stepproject2", user, pass);
            Statement statement = connection.createStatement();
            statement.execute(SqlQueries.createFlightSql());
            statement.execute(SqlQueries.createPassengerSql());
            statement.execute(SqlQueries.createBookingSql());
            statement.execute(SqlQueries.insertFlightSql());
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int ifDbExists() {
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select count(datname) from pg_database where datname = 'stepproject2'");
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            connection.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return count;
    }
}
