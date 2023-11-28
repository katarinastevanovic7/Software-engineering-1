package exercise06;

import java.util.Locale;
import java.util.Objects;

public class Worker implements INameInMultipleCases {

    private String name;

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
     * Returns the name of this worker in upper case letters.
     * Note that {@link Worker#initialize(String)} has to be called first
     *
     * @return
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
        }
    }

    @Override
    public String getNameInLowerCase() {
        //TODO b) indicate that this method is not implemented appropriately and document this behaviour
        try {
            if (Objects.equals(name, name.toLowerCase())) {
                throw new UnsupportedOperationException();
            }
            return name.toLowerCase();
        } catch (UnsupportedOperationException uoe) {
            throw new UnsupportedOperationException("Method is not implemented");
        }
    }

    /**
     * Call this method to do the work
     */
    public void doTheWork() {
        String name = this.name != null ? this.name : "Anonymous worker";
        System.out.println(name + " is doing the work!");
    }
}
