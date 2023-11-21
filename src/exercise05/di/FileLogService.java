package exercise05.di;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogService extends ConsoleLogService implements ILogService { // 1b implementiert ILogService und überschreibt log-Methode

    //log Methode nimmt eine Nachricht entgegen und erstellt einen log Eintrag mit aktuellem Datum, Uhrzeit und Nachricht
    public void log(String message) {
        String logMessage = String.format("%s: %s%n",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                message);
        //der Eintrag kommt in die logfile.txt Datei, logfile.txt wird erstellt,
        // falls bereits vorhanden dann wird der Eintrag ans Ende der Datei angehängt
        try {
            Files.writeString(Paths.get("logfile.txt"), logMessage,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            //falls IOException, dann wird es in UncheckedIOException umgewandelt
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
