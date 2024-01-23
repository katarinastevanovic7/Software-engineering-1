package exercise12;

import exercise08.IpvqAddress;
import exercise09.Person;
import exercise10.CharacterType;
import exercise10.Player;
import exercise10.Special;
import exercise10.Team;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        Player player = new Player("Spieler", CharacterType.ELF, List.of(Special.EXTRA_POWER, Special.INVISIBILITY), new Team("Team", 1));
        System.out.println(Reflections.stringify(player));

        Person person = new Person("Max", "Mustermann", 1000, 23);
        System.out.println(Reflections.stringify(person));

        IpvqAddress ipvq = new IpvqAddress("74;416;386;372;5");
        System.out.println(Reflections.stringify(ipvq));
    }
}
