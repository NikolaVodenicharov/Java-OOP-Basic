import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private final Integer FIRST_TEAM_MAXIMUM_PLAYER_AGE = 39;

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public List<Person> getFirstTeam(){
        return Collections.unmodifiableList(this.firstTeam);
    }
    public List<Person> getReserveTeam(){
        return Collections.unmodifiableList(this.reserveTeam);
    }
    public void addPlayer(Person person){
        if (person.getAge() <= FIRST_TEAM_MAXIMUM_PLAYER_AGE){
            firstTeam.add(person);
        }
        else{
            reserveTeam.add(person);
        }
    }
}
