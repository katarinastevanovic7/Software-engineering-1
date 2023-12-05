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
    public String get(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= size) {
            throw new NoSuchElementException();
        }
        return data[pos];
    }


    @Override
    public void add(int pos, String element) throws IllegalArgumentException {
        if(pos < 0 || pos > size) {
            throw new IllegalArgumentException();
        }
        if(size == data.length) {
            String[] newData = new String[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        for (int i = size - 1; i >= pos; i--) {
            data[i + 1] = data[i];
        }
        data[pos] = element;
        size++;

        }

    @Override
    public String toCommaSeparatedString() {
        if(size == 0) {
            return"";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(data[0]);
        for (int i = 1; i < size; i++) {
            sb.append(",").append(data[i]);
        }
        return sb.toString();
    }
}

