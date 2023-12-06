package exercise07;

import java.util.NoSuchElementException;

public class StringArrayList implements ISimpleStringList {

    // TODO: Diese Klasse müssen Sie anpassen, bis alle Tests durchlaufen
    private String[] data;
    private int size;

    public StringArrayList() {
        this.data = new String[10];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    // Gibt das Element an der angegebenen Position zurück
    // Wirft eine NoSuchElementException, wenn kein Element an der angegebenen Position existiert
    public String get(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= size) {
            throw new NoSuchElementException();
        }
        return data[pos];
    }


    @Override
    // IllegalArgumentException für ungültige Positionen
    public void add(int pos, String element) throws IllegalArgumentException {
        if(pos < 0 || pos > size) {
            throw new IllegalArgumentException();
        }
        //Überprüfen ob array voll ist
        if(size == data.length) {
            String[] newData = new String[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        //verschiebt Elemente um Platz zu machen
        //durchläuft die Elemente des Arrays rückwärts, beginnt beim letzten Element (size - 1) bis pos
        for (int i = size - 1; i >= pos; i--) {
        //i wird um eine Position nach rechts verschoben
            data[i + 1] = data[i];
        }
       //das neue Element wird an der gewünschten Position eingefügt
       // und die Größe der Liste wird erhöht
        data[pos] = element;
        size++;

        }

    @Override
    public String toCommaSeparatedString() {
        // wenn Liste leer ist, dann wird eine leere Zeichenkette zurückgegeben
        if(size == 0) {
            return"";
        }
        StringBuilder sb = new StringBuilder();
        // fügt das erste Element der Liste dem StringBuilder hinzu
        sb.append(data[0]);
        //Durchläuft die restlichen Elemente der Liste
        // und fügt sie dem StringBuilder hinzu, vor jedem Element wird ein Komma eingefügt
        for (int i = 1; i < size; i++) {
            sb.append(",");
            sb.append(data[i]);
        }
        return sb.toString();
    }
}

