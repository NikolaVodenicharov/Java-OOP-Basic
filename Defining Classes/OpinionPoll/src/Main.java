import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);

        HashSet<Person> inputPeople = readInputPeople(reader);

        int ageFilter = 30;
        List<Person> filteredPeople = filterPeopleByAge(inputPeople, ageFilter);

        printCollection(filteredPeople);
    }

    private static List<Person> filterPeopleByAge(HashSet<Person> inputPeople, int ageFilter) {
        return inputPeople
                .stream()
                .filter(p -> p.age > ageFilter)
                .sorted((a, b) -> a.name.compareTo(b.name))
                .collect(Collectors.toList());
    }

    public static HashSet<Person> readInputPeople(BufferedReader reader) throws IOException {
        HashSet<Person> inputPeople = new HashSet<Person>();

        int inputLinesNumber = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputLinesNumber; i++) {
            String[] splitInput = reader.readLine().split("\\s+");
            String name = splitInput[0];
            Integer age = Integer.parseInt(splitInput[1]);
            Person person = new Person(name, age);
            inputPeople.add(person);
        }

        return inputPeople;
    }
    public static void printCollection(Collection<Person> people){
        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
            sb
                    .append(person)
                    .append(System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }
}
