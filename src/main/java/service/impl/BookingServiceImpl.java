package service.impl;

import dao.BookingDao;

import dto.BookingDto;
import model.Booking;
import service.BookingService;
import util.ConsoleColors;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;

    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void createBooking(BookingDto bookingDto) {
        Booking booking = new Booking(bookingDto.getFin_code(), bookingDto.getSerial_number());
        if (!bookingDao.createBooking(booking)) {
            System.out.println(ConsoleColors.TEXT_GREEN+"Booking is created"+ConsoleColors.TEXT_RESET);
        }
    }

    @Override
    public int getBookingBySerialAndFin(BookingDto bookingDto) {
        Booking booking = new Booking(bookingDto.getFin_code(), bookingDto.getSerial_number());
        int count = 0;
        ResultSet resultSet = bookingDao.getBookingBySerialAndFin(booking);
        try {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    @Override
    public void deleteBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        int count = bookingDao.updateFlightSeatsByBookingId(booking);
        if (count > 0) {
            if (bookingDao.deleteBooking(booking) > 0)
                System.out.println(ConsoleColors.TEXT_GREEN+"Booking was canceled"+ConsoleColors.TEXT_RESET);
            else
                System.out.println(ConsoleColors.TEXT_RED+"Booking was not cancelled"+ConsoleColors.TEXT_RESET);
        }
    }
}
