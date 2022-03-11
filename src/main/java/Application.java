import controller.BookingController;
import controller.FlightController;
import controller.PassengerController;
import dao.BookingDao;
import dao.FlightDao;
import dao.PassengerDao;
import dao.impl.BookingDaoImpl;
import dao.impl.FlightDaoImpl;
import dao.impl.PassengerDaoImpl;
import service.BookingService;
import service.FlightService;
import service.PassengerService;
import service.impl.BookingServiceImpl;
import service.impl.FlightServiceImpl;
import service.impl.PassengerServiceImpl;
import util.ConsoleColors;
import util.MainMenu;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        FlightDao flightDao = new FlightDaoImpl();
        FlightService flightService = new FlightServiceImpl(flightDao);
        FlightController flightController = new FlightController(flightService);
        BookingDao bookingDao = new BookingDaoImpl();
        BookingService bookingService = new BookingServiceImpl(bookingDao);
        BookingController bookingController = new BookingController(bookingService);
        PassengerDao passengerDao = new PassengerDaoImpl();
        PassengerService passengerService = new PassengerServiceImpl(passengerDao);
        PassengerController passengerController = new PassengerController(passengerService);
        flightController.showAllFlights();
        MainMenu.showMenu();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print(ConsoleColors.TEXT_YELLOW+"Enter the command : "+ConsoleColors.TEXT_RESET);
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number){
                case 1:
                    flightController.showAllFlights();
                    MainMenu.showMenu();
                    break;
                case 2:
                    flightController.showFlightBySerial();
                    MainMenu.showMenu();
                    break;
                case 3:
                    flightController.showFlightsForBooking();
                    MainMenu.showMenu();
                    break;
                case 4:
                    bookingController.deleteBooking();
                    MainMenu.showMenu();
                    break;
                case 5:
                    passengerController.showAllBookings();
                    MainMenu.showMenu();
                    break;
                case 6:
                    System.out.println("GO HOME BABY");
                    return;
            }
        }
    }
}
