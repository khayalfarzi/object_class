package dto;
import java.util.Date;
import java.util.Objects;

public class FlightDto {
    private int id;
    private String serial_number;
    private String from;
    private String destination;
    private short seats;
    private Date date;

    public FlightDto() {
    }

    public FlightDto(String serial_number, String from, String destination) {
        this.serial_number = serial_number;
        this.from = from;
        this.destination = destination;
    }

    public FlightDto(String serial_number, String from, String destination, short seats, Date date) {
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
        if (!(o instanceof FlightDto)) return false;
        FlightDto flightDto = (FlightDto) o;
        return getId() == flightDto.getId() && getSeats() == flightDto.getSeats() && Objects.equals(getSerial_number(), flightDto.getSerial_number()) && Objects.equals(getFrom(), flightDto.getFrom()) && Objects.equals(getDestination(), flightDto.getDestination()) && Objects.equals(getDate(), flightDto.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSerial_number(), getFrom(), getDestination(), getSeats(), getDate());
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "id=" + id +
                ", serial_number='" + serial_number + '\'' +
                ", from='" + from + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", date=" + date +
                '}';
    }
}
