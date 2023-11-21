package exercise05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vertikalkalkstein {

    public static void main(String[] args) {
        String text = "VERTIKALKALKSTEIN";
        Pattern pattern = Pattern.compile("KALK");
        Matcher matcher = pattern.matcher(text);

        int counter = 0;
        int go = 0;

        //Aufgabe 5
        // TODO

        while (matcher.find(go)) {
            counter++;
            go = matcher.start() + 1;
        }

        System.out.println(counter);
    }
}
