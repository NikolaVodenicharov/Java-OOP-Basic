import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = readPeople(reader);
        increasePeopleSalary(reader, people);
        String formated = toStringCollection(people);
        System.out.println(formated);
    }

    private static List<Person> readPeople(BufferedReader reader) throws IOException {
        int inputLineNumber = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>(inputLineNumber);

        for (int i = 0; i < inputLineNumber; i++) {
            String[] splitInput = reader.readLine().split(" ");

            String firstName = splitInput[0];
            String lastName = splitInput[1];
            Integer age = Integer.parseInt(splitInput[2]);
            Double salary = Double.parseDouble(splitInput[3]);

            Person person = new Person(firstName, lastName, age, salary);
            people.add(person);
        }

        return people;
    }
    private static void increasePeopleSalary (BufferedReader reader, List<Person> people) throws IOException {
        int bonus = Integer.parseInt(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
        }
    }
    private static <E> String toStringCollection (List<E> collection){
        StringBuilder formated = new StringBuilder();
        for (E element : collection) {
            formated
                    .append(element)
                    .append(System.lineSeparator());
        }

        return formated.toString().trim();
    }
}
