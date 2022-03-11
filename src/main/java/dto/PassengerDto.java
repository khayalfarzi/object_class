package dto;
import java.util.Objects;

public class PassengerDto {
    private int id;
    private String finCode;
    private String firstname;
    private String lastname;

    public PassengerDto() {
    }

    public PassengerDto(String firstname, String lastname, String finCode) {
        this.finCode = finCode;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public PassengerDto(int id, String firstname, String lastname, String finCode) {
        this.id = id;
        this.finCode = finCode;
        this.firstname = firstname;
        this.lastname = lastname;
    }


    public String getFinCode() {
        return finCode;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerDto)) return false;
        PassengerDto that = (PassengerDto) o;
        return getId() == that.getId() && Objects.equals(getFinCode(), that.getFinCode()) && Objects.equals(getFirstname(), that.getFirstname()) && Objects.equals(getLastname(), that.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFinCode(), getFirstname(), getLastname());
    }

    @Override
    public String toString() {
        return "PassengerDto{" +
                "id=" + id +
                ", finCode='" + finCode + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
