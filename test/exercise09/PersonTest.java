package exercise09;

import org.junit.Assert;
import org.junit.Test;

    public class PersonTest {

        @Test
        public void testPerson() {
            //GIVEN: Person Uli Schulz, 22 Jahre alt mit ID 123456789
            Person person = new Person("Uli", "Schulz", 123456789, 22);

            //WHEN: Vorname wird auf null geändert.
            //THEN: NullPointerException fliegt.
            Assert.assertThrows(NullPointerException.class, () -> {
                person.setFirstName(null);
            });


            //WHEN: Nachname wird auf null geändert.
            //THEN: NullPointerException fliegt.
            Assert.assertThrows(NullPointerException.class, () -> {
                person.setLastName(null);
            });

        }


//


//Assert.assertThrows(Name der Exception.class, () -> {
//        Code mit erwarteter Exception
//    });

    }
