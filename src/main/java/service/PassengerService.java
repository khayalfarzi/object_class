package service;

import dto.PassengerDto;

public interface PassengerService {
   void createPassenger(PassengerDto passengerDto);
   void showAllBookings(String finCode);
}
