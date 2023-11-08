package exercise03.university;

public class UniversityBuilder {
    private String universityName;
    private String city;
    private String universityType;
    private int numberOfStudents;
    private int numberOfFaculties;
    private int foundingYear;

    public UniversityBuilder setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }

    public UniversityBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public UniversityBuilder setUniversityType(String universityType) {
        this.universityType = universityType;
        return this;
    }

    public UniversityBuilder setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public UniversityBuilder setNumberOfFaculties(int numberOfFaculties) {
        this.numberOfFaculties = numberOfFaculties;
        return this;
    }

    public UniversityBuilder setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
        return this;
    }

    public University build() {
        return new University(universityName, city, universityType, numberOfStudents, numberOfFaculties, foundingYear);
    }

}

