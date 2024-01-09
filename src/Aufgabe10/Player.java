package Aufgabe10;

public final class Player {

    private final String name;
    private final CharacterType type;
    private final List<Special> specials;
    private final Team team;


    public Player(String name, CharacterType type, List<Special> specials, Team team) {
        this.name = name;
        this.type = type;

        this.specials = new ArrayList<>(specials); // Konstruktor erstellt eine Kopie der übergebenen specials-Liste
        this.team = new Team(team); //Kopie des Team-Objekts

    }

    public String getName() {
        return name;
    }
    public CharacterType getType() {
        return type;
    }

    public List<Special> getSpecials() {
        return new ArrayList<>(specials);   //Kopie der specials-Liste zurückgeben
    }

    public Team getTeam() {
        return new Team(team);      //Kopie des Team-Objekts zurückgeben
    }

    // Wither Methoden: wie setter, erzeugen eine neue Instanz mit geänderten Attributwerten (ursprüngliche Instanz bleibt unverändert)
    public Player withName(String name) {
        return new Player(name, this.type, this.specials, this.team);   //neue Player-Instanz mit geändertem Namen
    }

    public Player withType(CharacterType type) {
        return new Player(this.name, type, this.specials, this.team);
    }

    public Player withSpecials(List<Special> specials) {
        return new Player(this.name, this.type, specials, this.team);
    }

    public Player withTeam(Team team) {
        return new Player(this.name, this.type, this.specials, team);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name) && type == player.type && Objects.equals(specials, player.specials) && Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, specials, team);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", specials=" + specials +
                ", team=" + team +
                '}';
    }
}
