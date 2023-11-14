package exercise04.service_persons;

import org.junit.*;

import java.util.Arrays;

public class PersonTextFileRepositoryTest {
    @Test
    public void saveAndLoad() {
        IPersonRepository repository = new PersonTextFileRepository();

        Person tobias = new Person("Tobias", "Tritschler", 18, Person.Gender.MALE);
        Person josephine = new Person("Josephine", "Juhnke", 19, Person.Gender.FEMALE);
        Person axel = new Person("Axel", "Alter", 20, Person.Gender.MALE);
        Person franziska = new Person("Franziska", "Froese", 42, Person.Gender.FEMALE);
        Person waltraut = new Person("Waltraut", "Weidinger", 74, Person.Gender.FEMALE);
        Person justin = new Person("Justin", "Jahnke", 11, Person.Gender.MALE);
        Person claudia = new Person("Claudia", "Coordt", 33, Person.Gender.FEMALE);
        Person rene = new Person("Rene", "Reinsch", 27, Person.Gender.OTHER);
        Person christian = new Person("Christian", "Cebulla", 101, Person.Gender.MALE);

        Person[] persons = new Person[]{tobias, josephine, axel, franziska, waltraut,
                justin, claudia, rene, christian};
        repository.savePersons(persons);

        Assert.assertEquals(persons.length, repository.loadPersons().length);
        System.out.println("Urspruengliches Array: " + persons.length + " = " + "Geladenes Array: "
                + repository.loadPersons().length);
        Person[] loadedPersons = repository.loadPersons();

        for (int i = 0; i < persons.length; i++) {
            Assert.assertEquals(persons[i], loadedPersons[i]);
        }
    }
}
