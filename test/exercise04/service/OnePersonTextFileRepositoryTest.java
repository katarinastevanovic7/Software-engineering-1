package exercise04.service;

import org.junit.Assert;
import org.junit.Test;

public class OnePersonTextFileRepositoryTest {

    @Test
    public void saveAndLoadPerson() {
        PersonTextFileRepository repository = new PersonTextFileRepository();

        Person max = new Person("Max", "Muster", 21, Person.Gender.MALE);
        repository.savePerson(max);
        Person personLoadedAgain = repository.loadPerson();

        System.out.println(max);
        System.out.println(personLoadedAgain);
        Assert.assertEquals(max, personLoadedAgain);
    }
}