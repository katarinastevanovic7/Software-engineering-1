package Aufgabe10;
import java.util.Objects;

public class Team {

    private String name;
    private int nrOfMembers;

    public Team(String name, int nrOfMembers) {
        this.name = name;
        this.nrOfMembers = nrOfMembers;
    }

    public Team(Team teamToCopyFrom) {
        this(teamToCopyFrom.name, teamToCopyFrom.nrOfMembers);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfMembers() {
        return nrOfMembers;
    }

    public void setNrOfMembers(int nrOfMembers) {
        this.nrOfMembers = nrOfMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return nrOfMembers == team.nrOfMembers && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nrOfMembers);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", nrOfMembers=" + nrOfMembers +
                '}';
    }
}

