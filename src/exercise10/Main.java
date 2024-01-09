package exercise10;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("ExpectoPatronum", 2);

        List<Special> specials1 = new ArrayList<>();
        specials1.add(Special.MAGIC_WAND);
        specials1.add(Special.EXTRA_POWER);

        Player player1 = new Player("Tina", CharacterType.DWARF, specials1 , team);

        List<Special> specials2 = new ArrayList<>();
        specials2.add(Special.FAIRY_DUST);
        specials2.add(Special.INVISIBILITY);

        Player player2 = new Player("Kathi", CharacterType.ELF, specials2, team);

        System.out.println(player1.toString());;
        System.out.println(player2.toString());

    }
}
