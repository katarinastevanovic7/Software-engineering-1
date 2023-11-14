package exercise04.service;

public interface IPersonService {

    Person loadPerson();

    void savePerson(Person person);

    boolean isAllowedToDriveAloneInACar(Person person);
}
