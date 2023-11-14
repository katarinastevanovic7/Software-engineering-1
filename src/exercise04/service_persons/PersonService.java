package exercise04.service_persons;

public class PersonService implements IPersonService {

    private IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person[] loadPersons() {
        return personRepository.loadPersons();
    }

    @Override
    public void savePersons(Person[] person) {
        personRepository.savePersons(person);
    }

    public boolean isAllowedToDriveAloneInACar(Person person) {
        return person.getAge() >= 18;
    }
}
