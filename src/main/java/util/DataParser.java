package util;

import model.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataParser {
    public static ArrayList<Flight> parseFlightResultSet(ResultSet resultSet) {
        ArrayList<Flight> flights = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getInt("id"),
                        resultSet.getString("serial_number"),
                        resultSet.getString("From"),
                        resultSet.getString("destination"),
                        resultSet.getShort("seats"),
                        resultSet.getDate("date")
                );
                flights.add(flight);
            }
            return flights;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
