package service.impl;

import dao.BookingDao;
import dao.FlightDao;
import dao.PassengerDao;
import dao.impl.BookingDaoImpl;
import dao.impl.PassengerDaoImpl;
import dto.BookingDto;
import dto.FlightDto;
import dto.PassengerDto;
import model.Flight;
import service.BookingService;
import service.FlightService;
import service.PassengerService;
import util.ConsoleColors;
import util.DataParser;
import util.Helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;
    private final PassengerDao passengerDao = new PassengerDaoImpl();
    private final PassengerService passengerService = new PassengerServiceImpl(passengerDao);
    private final BookingDao bookingDao = new BookingDaoImpl();
    private final BookingService  bookingService = new BookingServiceImpl(bookingDao);

    public FlightServiceImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public void showAllFlights() {
        ResultSet resultSet = flightDao.showAllFlights();
        ArrayList<Flight> flights = DataParser.parseFlightResultSet(resultSet);
        System.out.println("Serial           From              Destination");
        System.out.println("-------        ---------          -------------");
        for (int i = 0; i < Helper.mapToFlightDto(flights).size(); i++) {
            System.out.println(ConsoleColors.TEXT_GREEN +Helper.mapToFlightDto(flights).get(i).getSerial_number() + "          " +
                    Helper.mapToFlightDto(flights).get(i).getFrom() + "                 "
                    + Helper.mapToFlightDto(flights).get(i).getDestination()+ ConsoleColors.TEXT_RESET);
        }
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void showFlightBySerial(String serial_number) {
        ResultSet resultSet = flightDao.showFlightBySerial(serial_number);
        ArrayList<Flight> flights = DataParser.parseFlightResultSet(resultSet);
        Helper.printFlightsInfo(flights);
        System.out.println("--------------------------------------------------------------------------");
    }

    @Override
    public void showFlightForBooking(String destination, short seats, Date date) {
        ResultSet resultSet = flightDao.getFlightsForBooking(destination, seats, date);
        ArrayList<Flight> flights = DataParser.parseFlightResultSet(resultSet);
        if(!Helper.printFlightsInfo(flights)){
            return;
        }
        System.out.print(ConsoleColors.TEXT_YELLOW+"Enter 0 to return main menu or enter serial number for booking : "+ConsoleColors.TEXT_RESET);
        Scanner scanner = new Scanner(System.in);
        String serial_number = scanner.nextLine();
        if(Helper.chooseZeroOrSerial(serial_number, Helper.mapToFlightDto(flights))){
            List<FlightDto> flightList =  Helper.mapToFlightDto(flights).stream().filter(flight1 -> flight1.getSerial_number().equals(serial_number)).collect(Collectors.toList());
            ArrayList<PassengerDto> passengerDtos = Helper.getPassengerDataFromConsole(passengerService,seats,scanner);
            for(int i = 0; i < passengerDtos.size(); i++){
                BookingDto bookingDto = new BookingDto(passengerDtos.get(i).getFinCode(), serial_number);
                if(bookingService.getBookingBySerialAndFin(bookingDto) == 0){
                    bookingService.createBooking(bookingDto);
                    flightDao.updateFlightSeats((short) (flightList.get(0).getSeats()-1), serial_number);
                    flightList.get(0).setSeats((short) (flightList.get(0).getSeats()-1));
                }
                else{
                    System.out.println(ConsoleColors.TEXT_RED+"Booking was not created"+ConsoleColors.TEXT_RESET);
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}


