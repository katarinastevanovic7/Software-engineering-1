# SWEN1-WIN (Prof. Schneider), Blatt 0

Abgabe bis 17.10. per Git-Commit.

## Aufgabe 0

a) Diese Dinge sollten Sie bereits erledigt haben:

- Sie haben ein Foto von sich in das Profil-Bild von Moodle gesetzt. Das hilft mir, Sie besser zuordnen zu können. Wenn
  Sie kein echtes Foto verwenden wollen, gestalten Sie doch einen Avatar von sich unter
  <https://getavataaars.com/>.
- Sie haben eine:n Teampartner:in gefunden, in Moodle eine Gruppe gegründet und sich für einen Übungstermin angemeldet.
- Sie haben die Programme und Tools installiert:
    - Java in der aktuellen LTS-Version 17, z.B. als [OpenJDK Temurin 17](https://adoptium.net/). Geben Sie in der
      Kommandozeile/im Terminal den Befehl `java --version` ein. Hier sollte nun die Version 17 stehen und keine
      Fehlermeldung kommen.
    - Git, entweder über [die Git-Webseite](https://git-scm.com/downloads)
      oder über den Paket-Manager Ihrer Wahl (z.B.
      [Homebrew](https://brew.sh/) für MacOS). Geben Sie in der Kommandozeile/im Terminal den Befehl
      `git --version` ein. Hier sollte nun die Version von git stehen und keine Fehlermeldung kommen.
    - IntelliJ in der Community Edition (Download von der [IntelliJ-Webseite]
      (https://www.jetbrains.com/idea/download/), rechts der schwarze Button). Falls Sie IntelliJ schon installiert
      haben, starten Sie das Programm und wählen "Help -> Check for Updates" und installieren ggf. die neusten Updates.
      Evtl. müssen Sie "Check for Updated" mehrfach durchführen.
    - Sie können natürlich auch auf den Laborrechnern arbeiten, wo alle Tools vorinstalliert sind.
- Falls Sie Git noch nicht kennen, sehen Sie sich die Folien aus EPR dazu an (sind im SWEN1-Moodle-Kurs verlinkt) plus
  ein paar Git-Einführungsvideos auf YouTube.

b) Die folgenden Dinge erledigen wir gemeinsam in der ersten Übung. (Sie können das aber auch gerne schon im Alleingang
versuchen):

- Wir checken die Git-Projekte "material" (Link unter "Vorlesungen"), exercises (dieses Projekt, Link unter "Übungen")
  und Ihr Team-Projekt aus, und zwar in Verzeichnisse, die **nebeneinander** liegen:
  ```text
  └───SWEN1
      ├───exercises
      ├───material
      └───Team-Order (z.B. Area)
  ```
- Wir öffnen die Projekte in drei IntelliJ-Fenstern, so dass wir zwischen den Projekten wechseln können und Code vom
  einen in das andere Projekt kopieren können.
- Wir sehen uns dieses Übungsblatt in der MarkDown-Vorschau an.

## Aufgabe 1

Sie finden hier ein Java-Package "calculator" mit dem Code aus der Vorlesung.

a) Führen Sie den Code aus, um zu testen, ob alles funktioniert.

b) Ersetzen Sie diesen if-Abfragen-Block

```
if (operation==0) {
  result = first + second;
} else if (operation == 1) {
  result = first - second;
}
```

durch eine switch-case-Anweisung. (Die andere Prüfung auf `operation == 99`
können Sie als if-Abfrage lassen.) Verwenden Sie dazu die seit Java 14
eingeführte [neue switch-Anweisung](https://docs.oracle.com/en/java/javase/13/language/switch-expressions.html).

c) Erweitern Sie calculator.simple um die Operationen "Multiplication",
"Division", "Power". Power von "first" und "second" soll "first hoch second"
berechnen, also für die Eingaben 2 und 4 den Wert 16 (denn 2 hoch 4 ist gleich 16).
