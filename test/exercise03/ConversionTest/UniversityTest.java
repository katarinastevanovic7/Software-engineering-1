package exercise03.ConversionTest;

import exercise03.university.University;
import exercise03.university.UniversityBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class UniversityTest {
    @Test
    public void testToStringAndDisplayString() {
        University university1 = new UniversityBuilder()
                .setUniversityName("HTWG-Konstanz")
                .setCity("Konstanz")
                .setUniversityType("Hochschule für Technik, Wirtschaft und Gestaltung")
                .setNumberOfStudents(4876)
                .setNumberOfFaculties(6)
                .setFoundingYear(1906)
                .build();

        // Überprüfen, ob toString() und displayString() die richtigen Rückgaben liefern
        assertEquals("HTWG-Konstanz (Hochschule für Technik, Wirtschaft und Gestaltung) in Konstanz with 4876 students at 6 faculties, founded in 1906", university1.toString());
    }

    @Test
    public void testConstructorEqualsBuilder() {
        // Erstellen von zwei Instanzen für die HTWG, eine per Konstruktor und eine per Builder
        University universityConstructor = new University("HTWG-Konstanz", "Konstanz", "Hochschule für Technik, Wirtschaft und Gestaltung", 4876, 6, 1906);

        University universityBuilder = new UniversityBuilder()
                .setUniversityName("HTWG-Konstanz")
                .setCity("Konstanz")
                .setUniversityType("Hochschule für Technik, Wirtschaft und Gestaltung")
                .setNumberOfStudents(4876)
                .setNumberOfFaculties(6)
                .setFoundingYear(1906)
                .build();

        // Testen, dass equals() true zurückgibt, da die beiden Instanzen identisch sind
        assertTrue(universityConstructor.equals(universityBuilder));

        // Ändern Sie die Anzahl der Studenten in einer Instanz
        universityBuilder.setNumberOfStudents(5000);

        // Testen, dass equals() nun false zurückgibt, da die Anzahl der Studenten unterschiedlich ist
        assertFalse(universityConstructor.equals(universityBuilder));
    }

    @Test
    public void testCopyConstructor() {
        // Erstellen einer University-Instanz für die HTWG
        University university1 = new UniversityBuilder()
                .setUniversityName("HTWG-Konstanz")
                .setCity("Konstanz")
                .setUniversityType("Hochschule für Technik, Wirtschaft und Gestaltung")
                .setNumberOfStudents(4876)
                .setNumberOfFaculties(6)
                .setFoundingYear(1906)
                .build();

        // Erstellen einer zweiten Instanz mit dem Copy-Konstruktor
        University universityCopy = new University(university1);

        // Testen, dass equals() true zurückgibt, da die beiden Instanzen identisch sind
        assertTrue(university1.equals(universityCopy));

        // Ändern Sie den Gründungsjahr der kopierten Instanz
        universityCopy.setFoundingYear(1910);

        // Testen, dass equals() nun false zurückgibt, da das Gründungsjahr unterschiedlich ist
        assertFalse(university1.equals(universityCopy));
    }
}

