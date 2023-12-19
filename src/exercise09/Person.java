package exercise09;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private long identityNumber;
    private int age;

    public Person(String firstName, String lastName, long identityNumber, int age) {
        if (firstName == null) {
            throw new NullPointerException("firstName must not be null");
        }
        if (lastName == null) {
            throw new NullPointerException("lastName must not be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullPointerException("firstName must not be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullPointerException("lastName must not be null");
        }
        this.lastName = lastName;
    }

    public long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return identityNumber == person.identityNumber &&
                age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, identityNumber, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identityNumber=" + identityNumber +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        // first compare last name
        int lastNameComparison = this.lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        // if last names are equal, compare by first name
        return this.firstName.compareTo(other.firstName);
    }
}
