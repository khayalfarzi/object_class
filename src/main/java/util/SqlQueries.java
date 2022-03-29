package util;

import model.Booking;
import model.Passenger;

import java.util.Date;

public class SqlQueries {

    public static String createFlightSql() {
        return "Create Table Flights(\n" +
                " Id serial Primary key,\n" +
                " serial_number varchar(10) Unique not null,\n" +
                "\"from\" varchar(50) not null,\n" +
                " destination varchar(50) not null,\n" +
                " seats smallInt not null,\n" +
                " \"date\" Date not null)";
    }

    public static String createPassengerSql() {
        return "Create Table Passengers(\n" +
                "\tid serial Primary key,\n" +
                "\tfirstname varchar(20) not null,\n" +
                "\tlastname varchar(20) not null,\n" +
                "\tfin_code varchar(10) Unique not null\n" +
                ")";
    }

    public static String createBookingSql() {
        return "Create Table Booking(\n" +
                "id serial Primary key,\n" +
                "fin_code varchar(10) not null,\n" +
                "serial_number varchar(10) not null,\n" +
                "\tForeign key(fin_code) references Passengers(fin_code),\n" +
                "\tForeign key(serial_number) references Flights(serial_number)\n" +
                ")";
    }

    public static String insertFlightSql() {
        return " Insert into Flights(\n" +
                " serial_number, \"from\", destination, seats, \"date\")\n" +
                " values('34GH56', 'Kiev', 'Baku', 13, '2022-03-12'),\n" +
                " ('25JK11', 'Kiev', 'Istanbul', 9, '2022-03-12')";
    }

    public static String insertBookingSql(Booking booking){
        return String.format("Insert Into Booking (fin_code, serial_number) " +
                "values('%s' , '%s')", booking.getFin_code(), booking.getSerial_number());
    }

    public static String selectBookingBySerialAndFinSql(Booking booking){
        return String.format("Select count(fin_code) from Booking where fin_code = '%s' " +
                "AND serial_number = '%s'" , booking.getFin_code(), booking.getSerial_number());
    }

    public static String deleteBookingByIdSql(Booking booking){
        return String.format("Delete from Booking where id = %d", booking.getId());
    }

    public static String updateFlightSeatsByBookingIdSql(Booking booking){
        return String.format("Update Flights set seats = \n" +
                "(select seats from Flights where serial_number = (Select serial_number from Booking where id = %d) ) + 1\n" +
                "where serial_number =  (Select serial_number from Booking where id = %d)", booking.getId(), booking.getId());
    }

    public static String selectAllFlightsSql(){
        return "Select * from Flights where " +
                " \"date\" >= current_date and \"date\" <= current_date + INTERVAL '1 DAY'";
    }

    public static String selectFlightBySerialSql(String serial_number){
        return String.format("Select * from Flights where \"date\" >= current_date and \"date\" <= current_date + INTERVAL '1 DAY' AND serial_number='%s'", serial_number);
    }

    public static String selectFlightsForBookingSql(String destination, short seats, Date date){
        return String.format("Select * from Flights where " +
                "destination = '%s' AND seats >= %d AND \"date\" = '%s'", destination, seats, date);
    }

    public static String updateFlightSeatsSql(short seats, String serial_number){
        return String.format("Update Flights set seats =  %d where serial_number = '%s'",
                seats, serial_number);
    }

    public static String insertPassengerSql(Passenger passenger){
        return String.format("Insert into Passengers(fin_code, firstname, lastname)\n" +
                        "values('%s' , '%s', '%s')",
                passenger.getFinCode(), passenger.getFirstname(),
                passenger.getLastname());
    }

    public static String selectAllBookingsByFinSql(String fin_code){
        return String.format("Select p.fin_code, p.firstname, " +
                "p.lastname, b.id as booking_id, b.serial_number," +
                " f.\"from\", f.destination, f.\"date\"\n" +
                "  from Passengers p join  Booking b on p.fin_code = b.fin_code join Flights f " +
                "on b.serial_number = f.serial_number\n" +
                "where p.fin_code = '%s'", fin_code);
    }
}
