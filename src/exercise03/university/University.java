package exercise03.university;

import java.util.Locale;
import java.util.Objects;

public class University {

    //TODO
    private String universityName;
    private String city;
    private String universityType;
    private int numberOfStudents;
    private int numberOfFaculties;
    private int foundingYear;


    // Konstruktor
    public University(String universityName, String city, String universityType, int numberOfStudents, int numberOfFaculties, int foundingYear) {
        this.universityName = universityName;
        this.city = city;
        this.universityType = universityType;
        this.numberOfStudents = numberOfStudents;
        this.numberOfFaculties = numberOfFaculties;
        this.foundingYear = foundingYear;
    }

    // Get-Methoden
    public String getUniversityName() {
        return universityName;
    }

    public String getCity() {
        return city;
    }

    public String getUniversityType() {
        return universityType;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getNumberOfFaculties() {
        return numberOfFaculties;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    // Set-Methoden
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setNumberOfFaculties(int numberOfFaculties) {
        this.numberOfFaculties = numberOfFaculties;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public String toDisplayString() {
        String universityTypeString = universityType.toLowerCase();
        if (universityTypeString.startsWith("university of ")) {
            universityTypeString = universityTypeString.replace("university of ", "");
        }

        return universityName + " (" + universityTypeString + ") in " + city + " mit " + numberOfStudents + " Studierenden an " + numberOfFaculties + " Fakultäten, gegründet im Jahr " + foundingYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        University university = (University) obj;
        return numberOfStudents == university.numberOfStudents &&
                numberOfFaculties == university.numberOfFaculties &&
                foundingYear == university.foundingYear &&
                Objects.equals(universityName, university.universityName) &&
                Objects.equals(city, university.city) &&
                Objects.equals(universityType, university.universityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityName, city, universityType, numberOfStudents, numberOfFaculties, foundingYear);
    }

    @Override
    public String toString() {
        return universityName + " (" + universityType + ") in " + city +
                " with " + numberOfStudents + " students at " + numberOfFaculties + " faculties, founded in " + foundingYear;
    }

    public University(University universityToCopyFrom) {
        this(universityToCopyFrom.getUniversityName(), universityToCopyFrom.getCity(),
                universityToCopyFrom.getUniversityType(), universityToCopyFrom.getNumberOfStudents(),
                universityToCopyFrom.getNumberOfFaculties(), universityToCopyFrom.getFoundingYear());
    }

}