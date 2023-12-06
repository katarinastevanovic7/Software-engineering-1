package exercise07;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class GenericArrayList<T> implements ISimpleGenericList<T> {

    // TODO: Diese Klasse müssen Sie anpassen, bis alle Tests durchlaufen
    private T[] data;
    private int size;
    private Class<T> type;

    //2a
    public GenericArrayList(Class<T> type) {
        this.size = 0;
        this.type = type;
        // this is the equivalent for data = new T[size]
        this.data = createGenericArray(type, 2);
    }
    // This is a limitation of Java's type system:
    // Types are erased during compilation,
    // hence, the compiler does not know what T stands for.
    // Thus, we cannot just write "data = new T[size]".
    @SuppressWarnings("unchecked")
    private T[] createGenericArray(Class<T> type, int length) {
        return (T[]) Array.newInstance(type, length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    // Gibt das Element an der angegebenen Position zurück
    // Wirft eine NoSuchElementException, wenn kein Element an der angegebenen Position existiert
    public T get(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= size) {
            throw new NoSuchElementException();
        }
        return data[pos];
    }


    @Override
    // IllegalArgumentException für ungültige Positionen
    public void add(int pos, T element) throws IllegalArgumentException {
        if(pos < 0 || pos > size) {
            throw new IllegalArgumentException();
        }
        //Überprüfen ob array voll ist
        if(size == data.length) {
            T[] newData = createGenericArray(type, data.length * 2);
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }

        //durchläuft die Elemente des Arrays rückwärts, beginnt beim letzten Element (size - 1) bis pos
        for (int i = size - 1; i >= pos; i--) {
        // das Element wird an der Position i um eine Position nach rechts verschoben
            data[i + 1] = data[i];
        }
        //das neue Element wird in das Array an der gewünschten Position eingefügt,
        // und die Größe der Liste wird entsprechend erhöht
        data[pos] = element;
        size++;

    }

    @Override
    public String toCommaSeparatedString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
        //  Vor jedem Element außer dem ersten wird ein Komma eingefügt
            if (i > 0) {
                sb.append(",");
            }
        // das aktuelle Element der Liste wird dem StringBuilder hinzugefügt
            sb.append(data[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Beispiel für die Verwendung der GenericArrayList mit dem Typ String
        GenericArrayList<String> stringList = new GenericArrayList<>(String.class);
        stringList.add(0, "Element 1"); // Hinzufügen an Index 0
        stringList.add(1, "Element 2"); // Hinzufügen an Index 1
        System.out.println("Size: " + stringList.size());
        System.out.println("Element at index 1: " + stringList.get(1));
        System.out.println("Comma-separated string: " + stringList.toCommaSeparatedString());
    }
}

