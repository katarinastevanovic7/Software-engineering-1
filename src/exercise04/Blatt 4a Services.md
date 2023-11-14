# SWEN1-WIN (Prof. Schneider), Blatt 4

Abgabe bis 18.4. per Git-Commit.

## Hinweis: Tipps für die Aufgaben

Einige der Aufgaben auf diesem Blatt sind etwas knifflig. Daher gibt es ein zweites
Blatt [Blatt 4b Services, Tipps](./Blatt 4b Services,&#32;Tipps.md), auf dem Sie weitere Hinweise zu 1a) und 1b)
erhalten, wenn Sie mit einer der Aufgaben nicht weiterkommen.

## Dateien von Git ausschließen

In jedem Projekt können Sie im Hauptverzeichnis eine Datei `.gitignore` anlegen. Dateinamen, die hier gelistet sind,
werden von Git nicht berücksichtigt und landen daher nicht in der Versionskontrolle. In Ihrem Projekt gibt es diese
Datei schon - hier ist z.B. konfiguriert, dass keine .class-Dateien im Git landen. Wie Sie sehen, kann man hier auch
mit `*` arbeiten, was für beliebige Zeichen stehen kann.

Fügen Sie ganz unten in der Datei noch zwei Zeilen

```
person.txt
person_list.txt
```

hinzu, damit diese Dateien, die der Code aus Aufgabe 1 erzeugt, nicht im Git landen.

**Hinweis:** Wenn Sie Dateien, die schon einmal in Git committet wurden, nachträglich ausschließen wollen, müssen Sie
diese zuerst aus git löschen
(durch `git rm Dateiname` oder über IntelliJ) und den Dateinamen anschließend zur `.gitignore` hinzufügen.

## Aufgabe 1, Package service

a) Im Package `exercise04.service` finden Sie den Code aus der Vorlesung, der eine Person in eine Textdatei `person.txt`
speichern und daraus wieder laden kann. Führen Sie den Unit-Test `OnePersonTextFileRepositoryTest`
aus. Wie die Ausgabe des Tests auf der Kommandozeile zeigt, ist der Inhalt von `max` (Person, die gespeichert wird)
und `maxLoadedAgain`
(Person, die wieder aus der Text-Datei geladen wurde) identisch. Trotzdem schlägt das `Assert.assertEquals` fehl. Woran
liegt das? Wie können Sie den Fehler beheben, ohne den Code im Test zu verändern?

b) Erstellen Sie ein neues Paket `exercises04.service_persons` (liegt dann also parallel zu dem `service`-Paket aus a).
Kopieren Sie alle Klassen aus `service`
nach `service_persons`, also auch die Person-Klasse mit den Änderungen aus a). Ändern Sie sowohl in `IPersonRepository`
als auch in `IPersonService` und allen davon abgeleiteten Klassen die Signaturen der loadPerson- und savePerson-Methoden
wie folgt:

```
Person[] loadPersons();
void savePersons(Person[] persons);
```

Passen Sie die Implementierung so an, dass ein Array von Personen gespeichert und geladen werden kann. Dazu speichern
Sie in einer Datei
`person_list.txt` jeweils eine Person pro Zeile. Achtung: Denken Sie daran, im kopierten `PersonTextFileRepository` oben
den `PERSON_FILE_PATH`
in `person_list.txt` zu ändern, ansonsten überschreiben Sie die Daten aus a).

c) In dieser Teilaufgabe soll das Laden und Speichern getestet werden. Sie können dazu folgenden Code verwenden (oder
selbst eigene Personen anlegen):

```
Person tobias = new Person("Tobias", "Tritschler", 18, Person.Gender.MALE);
Person josephine = new Person("Josephine", "Juhnke", 19, Person.Gender.FEMALE);
Person axel = new Person("Axel", "Alter", 20, Person.Gender.MALE);
Person franziska = new Person("Franziska", "Froese", 42, Person.Gender.FEMALE);
Person waltraut = new Person("Waltraut", "Weidinger", 74, Person.Gender.FEMALE);
Person justin = new Person("Justin", "Jahnke", 11, Person.Gender.MALE);
Person claudia = new Person("Claudia", "Coordt", 33, Person.Gender.FEMALE);
Person rene = new Person("Rene", "Reinsch", 27, Person.Gender.OTHER);
Person christian = new Person("Christian", "Cebulla", 101, Person.Gender.MALE);

Person[] persons = new Person[]{tobias, josephine, axel, franziska, waltraut, 
                                justin, claudia, rene, christian};
```

Legen Sie eine Test-Klasse
`test/exercise04/service_persons/PersonTextFileRepositoryTest.java` an mit einer Methode, in der das `people`-Array mit
dem `PersonTextFileRepository`
erst gespeichert und dann wieder geladen wird. Testen Sie zunächst, ob das geladene Array dieselbe Länge wie das
ursprüngliche Array hat. Dann vergleichen Sie (mit einer Schleife) den 0. Eintrag des ursprünglichen Arrays mit dem 0.
Eintrag des geladenen Arrays, den 1. Eintrag, den 2. Eintrag... Beide Überprüfungen können in einer Test-Methode
stattfinden.

d) Implementieren Sie eine `default`-Methode(*) im `IPersonService`-Interface

```
default Person findByLastName(String lastName) { ... }
```

welche die erste Person mit dem übergebenen Nachnamen zurückgibt (oder null, falls keine solche Person vorhanden ist).
Testen Sie diese Methode mit folgendem JUnit-Test:

```
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
```

**(*) Hinweis**: Seit Java-Version 8 können Interfaces Methoden mit Implementierung beinhalten. Diese Methoden werden
dann direkt im Interface
(z.B. `IPersonService`) definiert und müssen nicht von den Implementierungen
(z.B. `PersonService`) implementiert werden.

Hier die entsprechende Vorlesungsfolie zu dem Thema:

![Default-Methoden](default-methods.png)