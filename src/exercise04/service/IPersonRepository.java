package exercise04.service;

public interface IPersonRepository {
    Person loadPerson();

    void savePerson(Person person);
}
