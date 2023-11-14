package exercise04.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonTextFileRepository implements IPersonRepository {
    //IMPORTANT: This repository only works when the person has no ";" in firstName or lastName

    private static String PERSON_FILE_PATH = "./person.txt";

    @Override
    public Person loadPerson() {
        Path path = Paths.get(PERSON_FILE_PATH);
        try {
            String csvString = Files.readString(path);
            String[] parts = csvString.split(";");
            return new Person(parts[0], parts[1], Integer.valueOf(parts[2]), Person.Gender.valueOf(parts[3]));
        } catch (IOException e) {
            //TODO This will be improved in a later example
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void savePerson(Person person) {
        Path path = Paths.get(PERSON_FILE_PATH);
        try {
            Files.writeString(path, String.format("%s;%s;%d;%s",
                    person.getFirstName(), person.getLastName(),
                    person.getAge(), person.getGender()));
        } catch (IOException e) {
            //TODO This will be improved in a later example
            e.printStackTrace();
        }
    }
}
