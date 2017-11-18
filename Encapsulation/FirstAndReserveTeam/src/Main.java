import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Person> people = readPeople(reader);

        Team team = new Team("Minior");
        for (Person person : people) {
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }

    private static List<Person> readPeople(BufferedReader reader) throws IOException {
        int inputLineNumber = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>(inputLineNumber);

        for (int i = 0; i < inputLineNumber; i++) {
            try{
                String[] splitInput = reader.readLine().split(" ");
                // is splitInput containing 4 elements

                String firstName = splitInput[0];
                String lastName = splitInput[1];
                Integer age = Integer.parseInt(splitInput[2]);

                Person person = new Person(firstName, lastName, age);
                people.add(person);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        return people;
    }
}
