package exercise04.service_persons;

public interface IPersonRepository {
    Person[] loadPersons();

    void savePersons(Person[] persons);
}
