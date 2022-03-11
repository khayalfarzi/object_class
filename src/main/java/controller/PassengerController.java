package controller;

import service.PassengerService;
import util.ConsoleColors;

import java.util.Scanner;

public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public void showAllBookings(){
        System.out.print(ConsoleColors.TEXT_YELLOW+"Enter passenger fin code for all flights : "+ConsoleColors.TEXT_RESET);
        Scanner scanner = new Scanner(System.in);
        String finCode = scanner.nextLine();
        passengerService.showAllBookings(finCode);
    }
}
