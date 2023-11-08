package exercise02.person_initials;

public class Exercise {

    public static void main(String[] args) {
        Person fullName = new Person();
        fullName.setFirstName("Beate");
        fullName.setLastName("Beispiel");

        Person onlyFirstName = new Person();
        onlyFirstName.setFirstName("Beate");
        onlyFirstName.setLastName(null);

        Person onlyLastName = new Person();
        onlyLastName.setFirstName(null);
        onlyLastName.setLastName("Beispiel");

        Person bothNamesNull = new Person();
        bothNamesNull.setFirstName(null);
        bothNamesNull.setLastName(null);

        // Make the following lines work (no exception should be thrown!)
        System.out.println(fullName.getInitials());

        System.out.println(onlyFirstName.getInitials());

        System.out.println(onlyLastName.getInitials());

        System.out.println(bothNamesNull.getInitials());
    }
}