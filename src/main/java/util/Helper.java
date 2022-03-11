package util;

import dao.PassengerDao;
import dto.FlightDto;
import dto.PassengerDto;
import model.Flight;
import model.Passenger;
import service.PassengerService;
import service.impl.PassengerServiceImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helper {

    public static List<FlightDto> mapToFlightDto(ArrayList<Flight> flights) {
        return flights.stream().map(flight -> new FlightDto(flight.getSerial_number(),
                flight.getFrom(),
                flight.getDestination(), flight.getSeats(),
                flight.getDate())).collect(Collectors.toList());
    }

    public static boolean chooseZeroOrSerial(String choice, List<FlightDto> flightDtos) {
        if (choice.equals("0")) {
            return false;
        } else {
            List<FlightDto> flightDtoList = flightDtos.stream().
                    filter(x -> x.getSerial_number().equals(choice)).collect(Collectors.toList());
            if (flightDtoList.size() == 0) {
                System.out.println(ConsoleColors.TEXT_RED+"Enter valid serial number"+ConsoleColors.TEXT_RESET);
                return false;
            } else {
                return true;
            }
        }
    }
    public static boolean printFlightsInfo(ArrayList<Flight> flights) {
        System.out.println("Serial           From              Destination         Seats        Date");
        System.out.println("-------        ---------          -------------       -------      -------");
        if (flights.size() == 0) {
            System.out.println(ConsoleColors.TEXT_RED+"Flight was not found"+ ConsoleColors.TEXT_RESET);
            return false;
        } else {
            for (int i = 0; i < Helper.mapToFlightDto(flights).size(); i++) {
                System.out.println(ConsoleColors.TEXT_GREEN+Helper.mapToFlightDto(flights).get(i).getSerial_number() + "          " +
                        Helper.mapToFlightDto(flights).get(i).getFrom() + "                 "
                        + Helper.mapToFlightDto(flights).get(i).getDestination() + "            " +
                        + Helper.mapToFlightDto(flights).get(i).getSeats() + "          "
                        + Helper.mapToFlightDto(flights).get(i).getDate()+ConsoleColors.TEXT_RESET);
            }
            return true;
        }
    }

    public static ArrayList<PassengerDto> getPassengerDataFromConsole(PassengerService passengerService, short seats, Scanner scanner){
        ArrayList<PassengerDto> passengerDtos = new ArrayList<>();
        for(int i = 0; i < seats; i++){
            System.out.print(ConsoleColors.TEXT_YELLOW+"Enter fin code and full name (EX: 123456 Nicat Guliyev) : "+ConsoleColors.TEXT_RESET);
            String fullName = scanner.nextLine();
            String[] passengerData = fullName.split(" ");
            if(passengerData.length < 3){
                System.out.println(ConsoleColors.TEXT_RED+"Warning: Enter passenger data right format!"+ConsoleColors.TEXT_RESET);
            }
            else{
                PassengerDto passengerDto = new PassengerDto(passengerData[1], passengerData[2], passengerData[0]);
                passengerDtos.add(passengerDto);
                passengerService.createPassenger(passengerDto);
            }
        }
        return passengerDtos;
    }
}
