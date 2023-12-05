package exercise06;

import java.util.Locale;
import java.util.Objects;

public class Worker implements INameInMultipleCases {

    private String name;

    // Ein leerer Konstruktor, der ein Objekt der Klasse Worker initialisiert
    public Worker() {
    }

    /**
     * Gives a name to this worker.
     *
     * @param name the name, must not be {@code null}
     * @throws NullPointerException if name is null
     */
    public void initialize(String name) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("name must not be null");
        }
        this.name = name;
    }


    /**
     * Gibt den Namen dieses Workers in Großbuchstaben zurück.
     * Beachten Sie, dass zuerst die Methode {@link Worker#initialize(String)} aufgerufen werden muss.
     *
     * @return Der Name des Workers in Großbuchstaben.
     * @throws IllegalStateException, wenn die Methode {@link Worker#initialize(String)} nicht korrekt aufgerufen wurde.
     *         Dies weist darauf hin, dass der Zustand der aktuellen Klasse den Methodenaufruf nicht erlaubt.
     */
    public String getNameInUpperCase() {
        //TODO a) implement method and handle the case that initialize was not called correctly.
        try {
            if (name == null) {
                throw new IllegalStateException();
            }
            String upperName = name.toUpperCase();
            return upperName;
        } catch (IllegalStateException ise) {
            throw new IllegalStateException("initialize has to be called first");
            // IllegalStateException: der Zustand der aktuellen Klasse, erlaubt den Methodenaufruf nicht
        }
    }

    /**
     * Gibt den Namen dieses Workers in Kleinbuchstaben zurück.
     * Beachten Sie, dass zuerst die Methode {@link Worker#initialize(String)} aufgerufen werden muss.
     *
     * @return Der Name des Workers in Kleinbuchstaben.
     * @throws UnsupportedOperationException, wenn der Name bereits in Kleinbuchstaben ist.
     *         Dies deutet darauf hin, dass die Methode nicht angemessen implementiert ist.
     */
    @Override
    public String getNameInLowerCase() {
        //TODO b) indicate that this method is not implemented appropriately and document this behaviour
        throw new UnsupportedOperationException("Not implemented");
//        try {
//            if (Objects.equals(name, name.toLowerCase())) {
//                throw new UnsupportedOperationException();
//            }
//            return name.toLowerCase();
//        } catch (UnsupportedOperationException uoe) {
//            throw new UnsupportedOperationException("Method is not implemented");
//            UnsupportedOperationException: wenn der Name des Workers bereits in Kleinbuchstaben vorliegt
//            allgemein: Methodenaufruf nicht unterstützt
//        }
    }

    /**
     * Call this method to do the work
     */
    public void doTheWork() {
        String name = this.name != null ? this.name : "Anonymous worker";
        System.out.println(name + " is doing the work!");
    }
}
