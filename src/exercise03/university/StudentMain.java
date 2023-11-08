package exercise03.university;

public class StudentMain {

    public static void main(String[] args) {
        // TODO
            University university1 = new UniversityBuilder()
                    .setUniversityName("HTWG-Konstanz")
                    .setCity("Konstanz")
                    .setUniversityType("Hochschule für Technik, Wirtschaft und Gestaltung")
                    .setNumberOfStudents(4876)
                    .setNumberOfFaculties(6)
                    .setFoundingYear(1906)
                    .build();

            Student student1 = new Student("Max", "Mustermann", university1);

            University university2 = new UniversityBuilder()
                    .setUniversityName("Universität-Stuttgart")
                    .setCity("Stuttgart")
                    .setUniversityType("Informatics University")
                    .setNumberOfStudents(27800)
                    .setNumberOfFaculties(7)
                    .setFoundingYear(1833)
                    .build();

            Student student2 = new Student("Anna", "Müller", university2);

            // Ausgabe der toString-Methode auf der Konsole
            System.out.println(student1.toString());
            System.out.println(student2.toString());

            // Ausgabe der toDisplayString-Methode auf der Konsole
            System.out.println(university1.toDisplayString());
            System.out.println(university2.toDisplayString());
        }
    }

