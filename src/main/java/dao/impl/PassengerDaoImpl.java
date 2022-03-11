package dao.impl;

import dao.PassengerDao;
import model.Passenger;
import util.SqlConnection;
import util.SqlQueries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PassengerDaoImpl implements PassengerDao {
    Connection connection;

    @Override
    public String createPassenger(Passenger passenger) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            statement.execute(SqlQueries.insertPassengerSql(passenger));
            connection.close();
            return "Passenger is crated";
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key value"))
                return "Passenger already exists";
            else
                return e.getMessage();
        }
    }

    @Override
    public ResultSet showAllBookings(String finCode) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueries.selectAllBookingsByFinSql(finCode));
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
