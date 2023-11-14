package exercise04.service;

public class PersonService implements IPersonService {

    private IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person loadPerson() {
        return personRepository.loadPerson();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.savePerson(person);
    }

    public boolean isAllowedToDriveAloneInACar(Person person) {
        return person.getAge() >= 18;
    }
}
