package exercise04.service_persons;

import org.junit.Assert;
import org.junit.Test;

public class PersonServiceTest {

    @Test
    public void findByLastName() {
        IPersonService personService = new PersonService(new PersonTextFileRepository());

        Person[] persons = new Person[]{
                new Person("Tobias", "Tritschler", 18, Person.Gender.MALE),
                new Person("Josephine", "Juhnke", 19, Person.Gender.FEMALE),
                new Person("Jana", "Juhnke", 21, Person.Gender.FEMALE)
        };

        personService.savePersons(persons);

        Assert.assertEquals(persons[1], personService.findByLastName("Juhnke"));
        Assert.assertNull(personService.findByLastName("Jahnke"));
    }
}
