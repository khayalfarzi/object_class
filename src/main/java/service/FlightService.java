package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public interface FlightService {
    void showAllFlights();
    void showFlightBySerial(String serial_number);
    void showFlightForBooking(String destination, short seats, Date date);
}
