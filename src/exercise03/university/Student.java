
package exercise03.university;

import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private University university;

    public Student() {
    }

    public Student(String firstName, String lastName, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", university=" + university +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName)
                && Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, university);
    }
}
