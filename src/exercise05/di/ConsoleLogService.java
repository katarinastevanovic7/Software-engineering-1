package exercise05.di;

//1c
public class ConsoleLogService implements ILogService {
    public void log(String message) {

        System.out.println(message);

        // um Log Nachrichten auf der Konsole auszugeben
    }
}
