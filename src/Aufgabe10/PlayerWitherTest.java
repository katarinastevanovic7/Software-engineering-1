package Aufgabe10;

import java.util.List;

public class PlayerWitherTest {

    @Test
    public void withName() {
        Player player1 = new Player("A", CharacterType.WARRIOR,
                List.of(Special.EXTRA_POWER, Special.INVISIBILITY), new Team("T", 1));

        Player player2 = player1.withName("B");

        Assert.assertTrue("A new player object with different memory " +
                "address (different reference) should be created", player1 != player2);

        Assert.assertEquals("A", player1.getName());
        Assert.assertEquals("B", player2.getName());
        Assert.assertEquals(player1.getType(), player2.getType());
        Assert.assertEquals(player1.getSpecials(), player2.getSpecials());
        Assert.assertEquals(player1.getTeam().getName(), player2.getTeam().getName());
        Assert.assertEquals(player1.getTeam().getNrOfMembers(), player2.getTeam().getNrOfMembers());
    }

    @Test
    public void withCharacterType() {
        Player player1 = new Player("A", CharacterType.WARRIOR,
                List.of(Special.EXTRA_POWER, Special.INVISIBILITY), new Team("T", 1));

        Player player2 = player1.withType(CharacterType.SORCERER);

        Assert.assertTrue("A new player object with different memory " +
                "address (different reference) should be created", player1 != player2);

        Assert.assertEquals(CharacterType.WARRIOR, player1.getType());
        Assert.assertEquals(CharacterType.SORCERER, player2.getType());
        Assert.assertEquals(player1.getName(), player2.getName());
        Assert.assertEquals(player1.getSpecials(), player2.getSpecials());
        Assert.assertEquals(player1.getTeam().getName(), player2.getTeam().getName());
        Assert.assertEquals(player1.getTeam().getNrOfMembers(), player2.getTeam().getNrOfMembers());
    }

    @Test
    public void withSpecials() {
        Player player1 = new Player("A", CharacterType.WARRIOR,
                List.of(Special.EXTRA_POWER, Special.INVISIBILITY), new Team("T", 1));

        Player player2 = player1.withSpecials(List.of(Special.MAGIC_WAND));

        Assert.assertTrue("A new player object with different memory " +
                "address (different reference) should be created", player1 != player2);

        Assert.assertEquals(List.of(Special.EXTRA_POWER, Special.INVISIBILITY), player1.getSpecials());
        Assert.assertEquals(List.of(Special.MAGIC_WAND), player2.getSpecials());
        Assert.assertEquals(player1.getName(), player2.getName());
        Assert.assertEquals(player1.getType(), player2.getType());
        Assert.assertEquals(player1.getTeam().getName(), player2.getTeam().getName());
        Assert.assertEquals(player1.getTeam().getNrOfMembers(), player2.getTeam().getNrOfMembers());
    }

    @Test
    public void withTeam() {
        Player player1 = new Player("A", CharacterType.WARRIOR,
                List.of(Special.EXTRA_POWER, Special.INVISIBILITY), new Team("T", 1));

        Player player2 = player1.withTeam(new Team("U", 2));

        Assert.assertTrue("A new player object with different memory " +
                "address (different reference) should be created", player1 != player2);

        Assert.assertEquals("T", player1.getTeam().getName());
        Assert.assertEquals(1, player1.getTeam().getNrOfMembers());
        Assert.assertEquals("U", player2.getTeam().getName());
        Assert.assertEquals(2, player2.getTeam().getNrOfMembers());
        Assert.assertEquals(player1.getName(), player2.getName());
        Assert.assertEquals(player1.getType(), player2.getType());
        Assert.assertEquals(player1.getSpecials(), player2.getSpecials());

    }

}
