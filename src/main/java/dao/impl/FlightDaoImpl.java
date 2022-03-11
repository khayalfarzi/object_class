package dao.impl;

import dao.FlightDao;
import util.SqlConnection;
import util.SqlQueries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class FlightDaoImpl implements FlightDao {

    Connection connection;

    @Override
    public ResultSet showAllFlights() {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueries.selectAllFlightsSql());
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet showFlightBySerial(String serial_number) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueries.selectFlightBySerialSql(serial_number));
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ResultSet getFlightsForBooking(String destination, short seats, Date date) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueries.selectFlightsForBookingSql(destination, seats, date));
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean updateFlightSeats(short seats, String serial_number) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            boolean bool =  statement.execute(SqlQueries.updateFlightSeatsSql(seats, serial_number));
            connection.close();
            return bool;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
