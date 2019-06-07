package pl.coderslab.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    private long id;
    private String firstName;
    private String lastName;

    public Customer() {
        this.id = 1L;
        this.firstName = "Unknownname";
        this.lastName = "Unknownlastname";
    }

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.firstName + " " + this.lastName;
    }
}