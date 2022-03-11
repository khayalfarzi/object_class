package model;

import java.util.Objects;

public class Passenger {
    private int id;
    private String finCode;
    private String firstname;
    private String lastname;

    public Passenger() {
    }

    public Passenger(String firstname, String lastname, String finCode) {
        this.finCode = finCode;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Passenger(int id, String firstname, String lastname, String finCode) {
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
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return getId() == passenger.getId() && Objects.equals(finCode, passenger.finCode) && Objects.equals(getFirstname(), passenger.getFirstname()) && Objects.equals(getLastname(), passenger.getLastname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), finCode, getFirstname(), getLastname());
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", finCode='" + finCode + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
