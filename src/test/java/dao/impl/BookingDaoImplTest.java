package dao.impl;

import dao.BookingDao;
import model.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingDaoImplTest {
    BookingDao bookingDao = new BookingDaoImpl();
    @Test
    void createBooking(){
        Booking booking = new Booking("44444444", "89MK55");
        assertEquals(true, bookingDao.createBooking(booking));
        Booking booking1 = new Booking("333222", "89MK55");
        assertEquals(false, bookingDao.createBooking(booking1));
    }

    @Test
    void getBookingBySerialAndFin(){
        Booking booking = new Booking("333222", "89MK55");
        assertEquals(1, bookingDao.getBookingBySerialAndFin(booking));
        Booking booking1 = new Booking("333222", "34GH56");
        assertEquals(0, bookingDao.getBookingBySerialAndFin(booking1));
        Booking booking2 = new Booking("3332222342734t8237t482374t82347823t48723t48273t4823t48", "34GH56");
        assertEquals(0, bookingDao.getBookingBySerialAndFin(booking2));
    }
}
