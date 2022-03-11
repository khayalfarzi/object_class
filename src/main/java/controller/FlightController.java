package controller;

import service.FlightService;
import util.ConsoleColors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlightController {
    private final FlightService flightService;
    Scanner scanner = new Scanner(System.in);

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public void showAllFlights(){
        flightService.showAllFlights();
    }

    public void showFlightBySerial(){
        System.out.print(ConsoleColors.TEXT_YELLOW+"Enter the serial number : "+ConsoleColors.TEXT_RESET);
        String serial_number = scanner.nextLine();
        flightService.showFlightBySerial(serial_number);
    }

    public void showFlightsForBooking(){
        System.out.print(ConsoleColors.TEXT_YELLOW+"Enter destination : "+ConsoleColors.TEXT_RESET);
        String destination = scanner.nextLine();
        System.out.print(ConsoleColors.TEXT_YELLOW+"Enter number of passengers : "+ConsoleColors.TEXT_RESET);
        short seats = scanner.nextShort();
        scanner.nextLine();
        System.out.print(ConsoleColors.TEXT_YELLOW+"Enter date : "+ConsoleColors.TEXT_RESET);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        flightService.showFlightForBooking(destination, seats, date);
    }
}
