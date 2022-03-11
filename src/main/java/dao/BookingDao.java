package dao;

import model.Booking;

import java.awt.print.Book;
import java.sql.ResultSet;

public interface BookingDao {
    boolean createBooking(Booking booking);
    ResultSet getBookingBySerialAndFin(Booking booking);
    int deleteBooking(Booking booking);
    int updateFlightSeatsByBookingId(Booking booking);
}
