package exercise12;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests für Reflections.stringify mit University-Instanzen
 */
public class ReflectionsTest {

    @Test
    public void testWithAllAttributes() {
        University htwg = new University("HTWG Konstanz", "Konstanz",
                UniversityType.UNIVERSITY_OF_APPLIED_SCIENCE,
                4866, 6, 1906);

        Assert.assertEquals(
                "University{city=Konstanz,foundationYear=1906,name=HTWG Konstanz,nrOfFaculties=6," +
                        "nrOfStudents=4866,universityType=University of applied science}",
                Reflections.stringify(htwg));
    }

    @Test
    public void testWithCityNull() {
        University uni1 = new University("HTWG Konstanz", null,
                UniversityType.UNIVERSITY_OF_APPLIED_SCIENCE,
                123, 6, 1906);

        Assert.assertEquals(
                "University{city=null,foundationYear=1906,name=HTWG Konstanz,nrOfFaculties=6," +
                        "nrOfStudents=123,universityType=University of applied science}",
                Reflections.stringify(uni1));
    }

    @Test
    public void testWithNameNull() {
        University uni2 = new University(null, "München",
                UniversityType.UNIVERSITY_OF_APPLIED_SCIENCE,
                123, 6, 1906);

        Assert.assertEquals(
                "University{city=München,foundationYear=1906,name=null,nrOfFaculties=6," +
                        "nrOfStudents=123,universityType=University of applied science}",
                Reflections.stringify(uni2));
    }

    @Test
    public void testWithNameAndUniversityTypeNull() {
        University uni3 = new University(null, "München",
                null, 123, 6, 1906);

        Assert.assertEquals(
                "University{city=München,foundationYear=1906,name=null,nrOfFaculties=6," +
                        "nrOfStudents=123,universityType=null}",
                Reflections.stringify(uni3));
    }
}