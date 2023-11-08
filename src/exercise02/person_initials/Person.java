package exercise02.person_initials;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;

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
        return "Person3{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String toDisplayString() {
        return String.format("%s %s", firstName, lastName);
    }
    //hier kommt Code dazu Aufgabe 1
    public String getInitials() {
        if(firstName== null && lastName == null) { //wenn null, einen leeren String zurückgeben, sonst
            //Initialien String erzeugen und zurückgeben
            return String.format("%s", "Stranger");
        }

        if (firstName == null && lastName != null) {
            return String.format("%s %s", "-", lastName.charAt(0));
        }

        if (firstName != null && lastName == null) {
            return String.format("%s %s", firstName.charAt(0), "-");
        }
        return String.format("%s%s", firstName.charAt(0), lastName.charAt(0));
    }

    @Override
    public boolean equals(Object o) {
        //Objektreferenzen prüfen
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        if (firstName != null && firstName.equals(person.firstName)
                && lastName != null && lastName.equals(person.lastName)) {
            return true;
        }
        return false;
        // einfacher:
        // return Objects.equals(firstName, person3.firstName) &&
        //        Objects.equals(lastName, person3.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
