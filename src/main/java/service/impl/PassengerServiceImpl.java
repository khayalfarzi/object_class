package service.impl;

import dao.PassengerDao;
import dto.PassengerDto;
import model.Passenger;
import service.PassengerService;
import util.ConsoleColors;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerServiceImpl implements PassengerService {

    private final PassengerDao passengerDao;

    public PassengerServiceImpl(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    public void createPassenger(PassengerDto passengerDto) {
        Passenger passenger = new Passenger(passengerDto.getFirstname(),
                passengerDto.getLastname(), passengerDto.getFinCode());
        System.out.println(passengerDao.createPassenger(passenger));
    }

    @Override
    public void showAllBookings(String finCode) {
        ResultSet resultSet = passengerDao.showAllBookings(finCode);
        System.out.println("FINCODE          FIRSTNAME           LASTNAME          BOOKINGID           SERIAL NUMBER           FROM            DESTINATION            DATE");
        System.out.println("-------         ----------          ----------        -----------         ----------------       --------        --------------          --------");
        int count = 0;
        try {
            while (resultSet.next()){
                count++;
                System.out.println(ConsoleColors.TEXT_GREEN+resultSet.getString("fin_code") + "          " + resultSet.getString("firstname") + "              " +
                        resultSet.getString("lastname") + "               " + resultSet.getInt("booking_id") + "                   " +
                        resultSet.getString("serial_number") + "              "  + resultSet.getString("from") + "            " +
                        resultSet.getString("destination") + "             " + resultSet.getDate("date")+ ConsoleColors.TEXT_RESET);
            }
            if(count == 0){
                System.out.println(ConsoleColors.TEXT_RED+"There Is no flights for the Passenger(" + finCode + ")"+ConsoleColors.TEXT_RESET);
            }
        }
        catch (SQLException e){
            System.out.println( e.getMessage());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
