package dto;
import model.Booking;

import java.util.Objects;

public class BookingDto {
    private int id;
    private String fin_code;
    private String serial_number;

    public BookingDto() {
    }

    public BookingDto(String fin_code, String serial_number) {
        this.fin_code = fin_code;
        this.serial_number = serial_number;
    }

    public BookingDto(int id, String fin_code, String serial_number) {
        this.id = id;
        this.fin_code = fin_code;
        this.serial_number = serial_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFin_code() {
        return fin_code;
    }

    public void setFin_code(String fin_code) {
        this.fin_code = fin_code;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingDto)) return false;
        BookingDto bookingDto = (BookingDto) o;
        return getId() == bookingDto.getId() && Objects.equals(fin_code, bookingDto.fin_code)
                && Objects.equals(getSerial_number(), bookingDto.getSerial_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), fin_code, getSerial_number());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", fin_code='" + fin_code + '\'' +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }
}
