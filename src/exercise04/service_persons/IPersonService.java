package exercise04.service_persons;

public interface IPersonService {

    Person[] loadPersons();

    void savePersons(Person[] persons);

    boolean isAllowedToDriveAloneInACar(Person person);

    default Person findByLastName(String lastName) {
        Person[] persons = loadPersons();
        for (Person person : persons) {
            if (person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

}
