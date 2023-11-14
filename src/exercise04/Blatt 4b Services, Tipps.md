# SWEN1-WIN (Prof. Schneider), Blatt 4, Tipps

## Bitte zuerst lesen

Versuchen Sie es doch erst einmal ohne die Tipps! Sie lernen dabei mehr, als beim Abtippen dieser Hinweise. Auch wenn
Sie diese Hinweise verwenden, müssen Sie dennoch verstehen und mir erklären können, was der Code tut.

## Tipp für Aufgabe 1a)

Suchen Sie die Folie "JUnit und equals" der Vorlesung SWEN1 03 und sehen Sie nach, was dort über assertEquals steht.
Beheben Sie den Fehler durch geeignete Anpassung der Person-Klasse.

## Tipps für Aufgabe 1b)

Tipp 1: Zum Speichern hilft Ihnen folgender Code-Schnipsel:

```
String stringToSave = "";
for (Person person : persons) {
    stringToSave += ein String aus der aktuellen person der mit \n endet
}
```

Tipp 2: Zum Laden können Sie erst die komplette Datei als String laden und dann anhand von dem Newline-Zeichen in
einzelne Zeilen zerlegen:

```
String completeFile = Files.readString(path);
String[] lines = completeFile.split("\n");
Person[] persons = new Person[lines.length];
```

Jetzt über lines iterieren (for-Schleife) und diese weiter zerlegen.
