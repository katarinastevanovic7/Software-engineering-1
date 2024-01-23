package exercise12;

public enum UniversityType {

    UNIVERSITY_OF_APPLIED_SCIENCE("University of applied science"),
    TECHNICAL_UNIVERSITY("Technical University"),
    UNIVERSITY("University");

    private final String displayString;

    UniversityType(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    }
}
