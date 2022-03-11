package model;

import java.util.Date;
import java.util.Objects;

public class Flight {
    private int id;
    private String serial_number;
    private String from;
    private String destination;
    private short seats;
    private Date date;

    public Flight() {
    }

    public Flight(int id, String serial_number, String from, String destination) {
        this.id = id;
        this.serial_number = serial_number;
        this.from = from;
        this.destination = destination;
    }

    public Flight(int id, String serial_number, String from, String destination, short seats, Date date) {
        this.id = id;
        this.serial_number = serial_number;
        this.from = from;
        this.destination = destination;
        this.seats = seats;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public short getSeats() {
        return seats;
    }

    public void setSeats(short seats) {
        this.seats = seats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() && getSeats() == flight.getSeats() && Objects.equals(getSerial_number(), flight.getSerial_number()) && Objects.equals(getFrom(), flight.getFrom()) && Objects.equals(getDestination(), flight.getDestination()) && Objects.equals(getDate(), flight.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSerial_number(), getFrom(), getDestination(), getSeats(), getDate());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", serial_number='" + serial_number + '\'' +
                ", from='" + from + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", date=" + date +
                '}';
    }
}
