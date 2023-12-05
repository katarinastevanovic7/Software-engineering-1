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
        this.data = createGenericArray(type, 2); // this is the equivalent for data = new T[size]
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
    public T get(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= size) {
            throw new NoSuchElementException();
        }
        return data[pos];
    }


    @Override
    public void add(int pos, T element) throws IllegalArgumentException {
        if(pos < 0 || pos > size) {
            throw new IllegalArgumentException();
        }
        if(size == data.length) {
            T[] newData = createGenericArray(type, data.length * 2);
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(data[i]);
        }
        return sb.toString();
    }
}

