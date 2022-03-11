package dao;

import java.sql.ResultSet;
import java.util.Date;

public interface FlightDao {
    ResultSet showAllFlights();
    ResultSet showFlightBySerial(String serial_number);
    ResultSet getFlightsForBooking(String destination, short seats, Date date);
    boolean  updateFlightSeats(short seats, String serial_number);
}
