package dao.impl;


import model.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightDaoImplTest {
    FlightDaoImpl flightDao = new FlightDaoImpl();
    @Test
    void selectAllFlights() throws SQLException, ParseException {
        Flight flight1 = new Flight(3, "12LM23", "Kiev", "Baku", (short) 13,
                new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-26"));
        Flight flight2 = new Flight(4, "89MK55", "Kiev", "Istanbul", (short) 4,
                new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-27"));
        assertEquals(flight1, flightDao.showAllFlights().get(0));
        assertEquals(flight2, flightDao.showAllFlights().get(1));
    }

    @Test
    void showFlightBySerial() throws ParseException {
        Flight flight1 = new Flight(3, "12LM23", "Kiev", "Baku", (short) 13,
                new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-26"));
        Flight flight2 = new Flight(4, "89MK55", "Kiev", "Istanbul", (short) 4,
                new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-27"));
        assertEquals(flight1, flightDao.showFlightBySerial("12LM23").get(0));
        assertEquals(flight2, flightDao.showFlightBySerial("89MK55").get(0));
    }
}