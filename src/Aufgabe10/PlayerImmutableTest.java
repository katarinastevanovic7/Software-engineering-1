package Aufgabe10;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class PlayerImmutableTest {

    @Test
    public void immutableClassHasNoSetters() {
        // checking all methods of IpvqAddress. There should not be a setter method.
        for (Method method : Player.class.getDeclaredMethods()) {
            if (method.getName().startsWith("set")) {
                Assert.fail("An immutable class should not have a setter method. " +
                        "Remove " + method.getName() + "!");
            }
        }
    }

    @Test
    public void immutableClassHasOnlyPrivateFinalField() {
        // checking all fields of IpvqAddress.
        // All fields should be final.
        // All non-static fields should be private.
        for (Field field : Player.class.getDeclaredFields()) {
            if (!Modifier.isFinal(field.getModifiers())) {
                Assert.fail("An immutable class should only have final fields. " +
                        "Found non-final field " + field.getName());
            }
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers())) {
                Assert.fail("A data class should only have private non-static fields. " +
                        "Found non-private field " + field.getName());
            }
        }
    }

    @Test
    public void allGettersArePresentAndWorking() {
        Player player = new Player("A", CharacterType.WARRIOR,
                List.of(Special.EXTRA_POWER, Special.INVISIBILITY), new Team("T", 1));

        Assert.assertEquals("A", player.getName());
        Assert.assertEquals(CharacterType.WARRIOR, player.getType());
        Assert.assertEquals(List.of(Special.EXTRA_POWER, Special.INVISIBILITY), player.getSpecials());
        Assert.assertNotNull(player.getTeam());
        Assert.assertEquals("T", player.getTeam().getName());
        Assert.assertEquals(1, player.getTeam().getNrOfMembers());
    }

    @Test
    public void specialsViaConstructorCannotBeChanged() {
        // new ArrayList macht die Liste veränderbar
        List<Special> specials = new ArrayList<>(List.of(Special.EXTRA_POWER));
        Player player = new Player("A", CharacterType.WARRIOR, specials, new Team("T", 1));

        // Wenn wir jetzt die specials ändern...
        specials.set(0, Special.INVISIBILITY);
        // ...sollte in player immer noch die ursprüngliche Liste sein!
        Assert.assertEquals(List.of(Special.EXTRA_POWER), player.getSpecials());
    }

    @Test
    public void specialsViaGetterCannotBeChanged() {
        // new ArrayList macht die Liste veränderbar
        List<Special> specials = new ArrayList<>(List.of(Special.EXTRA_POWER));
        Player player = new Player("A", CharacterType.WARRIOR, specials, new Team("T", 1));

        // Wenn wir jetzt die specials über die Referenz, die wir von getSpecials bekommen, ändern...
        try {
            player.getSpecials().clear();
            // ... sollte entweder die Liste immer noch unverändert sein...
            Assert.assertEquals(List.of(Special.EXTRA_POWER), player.getSpecials());
        } catch (UnsupportedOperationException ex) {
            // ...oder eine UnsupportedOperationException fliegen.
        }
    }

    @Test
    public void teamIsStillMutable() {
        Team team = new Team("test", 2);
        Assert.assertEquals("test", team.getName());
        Assert.assertEquals(2, team.getNrOfMembers());

        // Dieser Setter-Aufruf sollte immer noch möglich sein
        team.setName("abc");
        Assert.assertEquals("abc", team.getName());

        // Dieser auch.
        team.setNrOfMembers(0);
        Assert.assertEquals(0, team.getNrOfMembers());
    }

    @Test
    public void teamViaConstructorCannotBeChanged() {
        Team team = new Team("test", 2);
        Player player = new Player("A", CharacterType.WARRIOR,
                new ArrayList<Special>(List.of(Special.EXTRA_POWER)), team);

        // Wenn wir jetzt das Team ändern
        team.setName("abc");
        team.setNrOfMembers(0);
        // ...sollte in player immer noch das ursprüngliche Team sein!
        Assert.assertEquals("test", player.getTeam().getName());
        Assert.assertEquals(2, player.getTeam().getNrOfMembers());
    }

    @Test
    public void teamViaGetterCannotBeChanged() {
        Team team = new Team("test", 2);
        Player player = new Player("A", CharacterType.WARRIOR,
                new ArrayList<Special>(List.of(Special.EXTRA_POWER)), team);

        // Wenn wir jetzt das Team ändern über die Referenz, die wir von getTeam bekommen...
        player.getTeam().setName("abc");
        player.getTeam().setNrOfMembers(0);
        // ...sollte in player immer noch das ursprüngliche Team sein!
        Assert.assertEquals("test", player.getTeam().getName());
        Assert.assertEquals(2, player.getTeam().getNrOfMembers());
    }
}
