package exercise12;


import org.junit.Assert;
import org.junit.Test;

/**
 * Tests für Reflections.stringify mit University-Instanzen
 */
public class ReflectionsSkipStringifyTest {

    @Test
    public void testWithAllAttributes() {
        University2 htwg = new University2("HTWG Konstanz", "Konstanz",
                UniversityType.UNIVERSITY_OF_APPLIED_SCIENCE,
                4866, 6, 1906);

        Assert.assertEquals(
                "University2{city=Konstanz,name=HTWG Konstanz,nrOfStudents=4866}",
                Reflections.stringify(htwg));
    }

    @Test
    public void testWithCityNull() {
        University2 uni1 = new University2("HTWG Konstanz", null,
                UniversityType.UNIVERSITY_OF_APPLIED_SCIENCE,
                123, 6, 1906);

        Assert.assertEquals(
                "University2{city=null,name=HTWG Konstanz,nrOfStudents=123}",
                Reflections.stringify(uni1));
    }

    @Test
    public void testWithNameNull() {
        University2 uni2 = new University2(null, "München",
                UniversityType.UNIVERSITY_OF_APPLIED_SCIENCE,
                123, 6, 1906);

        Assert.assertEquals(
                "University2{city=München,name=null,nrOfStudents=123}",
                Reflections.stringify(uni2));
    }

    @Test
    public void testWithNameAndUniversityTypeNull() {
        University2 uni3 = new University2(null, "München",
                null, 123, 6, 1906);

        Assert.assertEquals(
                "University2{city=München,name=null,nrOfStudents=123}",
                Reflections.stringify(uni3));
    }
}