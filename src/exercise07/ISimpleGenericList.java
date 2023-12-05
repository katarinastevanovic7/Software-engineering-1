package exercise07;

import java.util.NoSuchElementException;

/**
 * An interface for simple list implementations
 *
 * @param <T> the data type of the elements to store in the list
 */
public interface ISimpleGenericList<T> {

    /**
     * returns the size of the list
     *
     * @return a non-negative integer
     */
    int size();

    /**
     * returns the element at the given position
     *
     * @param pos the position in the list
     * @return the element
     * @throws NoSuchElementException if no element exists at the given position
     */
    T get(int pos) throws NoSuchElementException;

    /**
     * adds an element to the given position by possibly shifting elements.
     * It is <br>{@code newList.get(i) = oldList.get(i)} for every 0 &lt;= i &lt; pos<br>
     * {@code newList.get(pos) = element}, and<br>
     * {@code newList.get(i) = oldList.get(i-1)} for every pos &lt; i &lt;= oldList.size()
     *
     * @param pos must be between 0 and list.size();
     * @param element the element to be added
     * @throws IllegalArgumentException for invalid positions
     */
    void add(int pos, T element) throws IllegalArgumentException;

    /**
     * returns a String with the list values. The values are separated by a comma
     * in case that the list has more than one element.<br>
     * E.g. "hello,world,!" for a list with {@code list.get(0) = "hello", list.get(1) = "world", list.get(2) = "!", list.size() = 3},<br>
     * "abc" for a list containing only the element "abc", or<br>
     * "" (the empty string) for an empty list.
     *
     * @return never {@code null}
     */
    String toCommaSeparatedString();
}
