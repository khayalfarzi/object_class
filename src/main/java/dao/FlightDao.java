package dao;

import model.Flight;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public interface FlightDao {
    ArrayList<Flight> showAllFlights();
    ArrayList<Flight> showFlightBySerial(String serial_number);
    ResultSet getFlightsForBooking(String destination, short seats, Date date);
    boolean  updateFlightSeats(short seats, String serial_number);
}
