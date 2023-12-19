package exercise08;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents an IPvQ address. Immutable data class.
 */
public class IpvqAddress implements Comparable<IpvqAddress> {
    private final int component1;
    private final int component2;
    private final int component3;
    private final int component4;
    private final int component5;

    /**
     * constructs an IPvQ address from a string. A valid address has the form a;b;c;d;e where
     * a, b, c, d and e are number from 0 to 511 without leading zeros.
     *
     * @param address the address to construct from. Must no be {@code null}
     * @throws NullPointerException     if address is {@code null}
     * @throws IllegalArgumentException if address has the wrong format
     */
    public IpvqAddress(String address) {
        // überprüft, ob die Adresse dem regex entspricht
        // [0-9] wert von 0 bis 9
        // [1-9][0-9] zweistelliger wert von 10 bis 99
        // [1-4][0-9][0-9] dreistelliger wert 100 bis 499
        // 50[0-9] 500 bis 509
        // 510 oder 511
        // 4 mal wiederholt getrennt durch ;
        // danach eine fünfte Komponente ohne Semikolon
        final String ipvqPattern = "((([0-9]|[1-9][0-9]|[1-4][0-9][0-9]|50[0-9]|510|511);){4}([0-9]|[1-9][0-9]|[1-4][0-9][0-9]|50[0-9]|510|511))";
        if (!address.matches(ipvqPattern)) {
            throw new IllegalArgumentException("Invalid adress: " + address);
        }
        if (address == null) {
            throw new NullPointerException("Address cannot be null");
        }
        String[] components = address.split(";");
        if (components.length != 5) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
        try {
            // in 5 Komponenten aufteilen und in Integer konvertieren
            this.component1 = Integer.parseInt(components[0]);
            this.component2 = Integer.parseInt(components[1]);
            this.component3 = Integer.parseInt(components[2]);
            this.component4 = Integer.parseInt(components[3]);
            this.component5 = Integer.parseInt(components[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid address: " + address, e);
        }
    }

    /**
     * the first component of the address. E.g. 11 for the address 11;22;33;44;55.
     *
     * @return a number between 0 and 511
     */
    public int getComponent1() {
        return component1;
    }

    /**
     * the second component of the address. E.g. 22 for the address 11;22;33;44;55.
     *
     * @return a number between 0 and 511
     */
    public int getComponent2() {
        return component2;
    }

    /**
     * the third component of the address. E.g. 33 for the address 11;22;33;44;55.
     *
     * @return a number between 0 and 511
     */
    public int getComponent3() {
        return component3;
    }

    /**
     * the fourth component of the address. E.g. 44 for the address 11;22;33;44;55.
     *
     * @return a number between 0 and 511
     */
    public int getComponent4() {
        return component4;
    }

    /**
     * the fifth component of the address. E.g. 55 for the address 11;22;33;44;55.
     *
     * @return a number between 0 and 511
     */
    public int getComponent5() {
        return component5;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        //überprüft, ob das übergebene Objekt null ist oder nicht vom gleichen Typ ist
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        //wenn es vom gleichen Typ ist, einzelne Komponenten vergleichen
        IpvqAddress other = (IpvqAddress) obj;
        return component1 == other.component1 &&
                component2 == other.component2 &&
                component3 == other.component3 &&
                component4 == other.component4 &&
                component5 == other.component5;
    }

    @Override
    //wird sichergestellt dass Objekte die gleich sind (nach equals), denselben Hashcode haben
    public int hashCode() {
        return Objects.hash(component1, component2, component3, component4, component5);
    }

    /**
     * returns a string representation of an IPvQ address in the format
     * component1;component2;component3;component4;component5, e.g. 1;0;500;3;7. This format is compatible
     * with the constructor {@link IpvqAddress#IpvqAddress(String)}.
     * @return
     */
    @Override
    public String toString() {
        return component1 + ";" + component2 + ";" + component3 + ";" + component4 + ";" + component5;
    }

    /**
     * Compares two IPvQ addresses component-wise, starting with the first component.
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(IpvqAddress o) {
        int result = Integer.compare(component1, o.component1);
        if (result != 0) {
            return result;
        }
        result = Integer.compare(component2, o.component2);
        if (result != 0) {
            return result;
        }
        result = Integer.compare(component3, o.component3);
        if (result != 0) {
            return result;
        }
        result = Integer.compare(component4, o.component4);
        if (result != 0) {
            return result;
        }
        return Integer.compare(component5, o.component5);
    }
}
