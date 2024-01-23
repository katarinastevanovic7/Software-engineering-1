package exercise12;

import java.util.Objects;

public class University {

    private String name;
    private String city;
    private UniversityType universityType;
    private int nrOfStudents;
    private int nrOfFaculties;
    private int foundationYear;

    public University(String name, String city, UniversityType universityType,
                      int nrOfStudents, int nrOfFaculties, int foundationYear) {
        this.name = name;
        this.city = city;
        this.universityType = universityType;
        this.nrOfStudents = nrOfStudents;
        this.nrOfFaculties = nrOfFaculties;
        this.foundationYear = foundationYear;
    }

    public University(University universityToCopyFrom) {
        this.name = universityToCopyFrom.name;
        this.city = universityToCopyFrom.city;
        this.universityType = universityToCopyFrom.universityType;
        this.nrOfStudents = universityToCopyFrom.nrOfStudents;
        this.nrOfFaculties = universityToCopyFrom.nrOfFaculties;
        this.foundationYear = universityToCopyFrom.foundationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UniversityType getUniversityType() {
        return universityType;
    }

    public void setUniversityType(UniversityType universityType) {
        this.universityType = universityType;
    }

    public int getNrOfStudents() {
        return nrOfStudents;
    }

    public void setNrOfStudents(int nrOfStudents) {
        this.nrOfStudents = nrOfStudents;
    }

    public int getNrOfFaculties() {
        return nrOfFaculties;
    }

    public void setNrOfFaculties(int nrOfFaculties) {
        this.nrOfFaculties = nrOfFaculties;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof University)) {
            return false;
        }
        University that = (University) o;
        return nrOfStudents == that.nrOfStudents &&
                nrOfFaculties == that.nrOfFaculties &&
                foundationYear == that.foundationYear &&
                Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                universityType == that.universityType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, universityType, nrOfStudents,
                nrOfFaculties, foundationYear);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", universityType=" + universityType +
                ", nrOfStudents=" + nrOfStudents +
                ", nrOfFaculties=" + nrOfFaculties +
                ", foundationYear=" + foundationYear +
                '}';
    }

    public String toDisplayString() {
        return String.format("%s (%s) in %s, gegründet %d mit %d Studierenden an %d Fakultäten", name,
                universityType, city, foundationYear, nrOfStudents, nrOfFaculties);
    }
}
