package controller;

import dto.BookingDto;
import service.BookingService;
import util.ConsoleColors;

import java.util.Scanner;

public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    public void deleteBooking(){
        System.out.print(ConsoleColors.TEXT_YELLOW+"Enter the id of booking for cancelling : "+ConsoleColors.TEXT_RESET);
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(id);
        bookingService.deleteBooking(bookingDto);
    }

}
