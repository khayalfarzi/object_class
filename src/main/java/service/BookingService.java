package service;

import dto.BookingDto;

public interface BookingService {
    void createBooking(BookingDto bookingDto);
    int getBookingBySerialAndFin(BookingDto bookingDto);
    void deleteBooking(BookingDto bookingDto);
}
