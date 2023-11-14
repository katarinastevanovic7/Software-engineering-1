package exercise04.service_persons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersonTextFileRepository implements IPersonRepository {
    //IMPORTANT: This repository only works when the person has no ";" in firstName or lastName

    private static String PERSON_FILE_PATH = "./person_list.txt";

    @Override
    public Person[] loadPersons() {
        Path path = Paths.get(PERSON_FILE_PATH);
        try {
            List<String> lines = Files.readAllLines(path);
            Person[] persons = new Person[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                String[] part = lines.get(i).split(";");
                persons[i] = new Person(part[0], part[1], Integer.parseInt(part[2]), Person.Gender.valueOf(part[3]));
            }
            return persons;
        } catch (IOException e) {
            //TODO This will be improved in a later example
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void savePersons(Person[] persons) {
        Path path = Paths.get(PERSON_FILE_PATH);
        try {
            List<String> lines = new ArrayList<>();
            for (Person person : persons) {
                lines.add(String.format("%s;%s;%d;%s", person.getFirstName(), person.getLastName(),
                        person.getAge(), person.getGender()));
            }
            Files.write(path, lines);
        } catch (IOException e) {
            //TODO This will be improved in a later example
            e.printStackTrace();
        }
    }
}
