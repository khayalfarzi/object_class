package dao.impl;

import dao.BookingDao;
import model.Booking;
import util.SqlConnection;
import util.SqlQueries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingDaoImpl implements BookingDao {

    Connection connection;

    @Override
    public boolean createBooking(Booking booking) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            boolean bool = statement.execute(SqlQueries.insertBookingSql(booking));
            connection.close();
            return bool;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }

    }

    @Override
    public ResultSet getBookingBySerialAndFin(Booking booking) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQueries.selectBookingBySerialAndFinSql(booking));
            connection.close();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteBooking(Booking booking) {
        try {
            connection = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(SqlQueries.deleteBookingByIdSql(booking));
            connection.close();
            return count;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateFlightSeatsByBookingId(Booking booking) {
        try {
            connection  = SqlConnection.checkConnection(connection);
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(SqlQueries.updateFlightSeatsByBookingIdSql(booking));
            connection.close();
            return count;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
