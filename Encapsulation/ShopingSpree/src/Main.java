import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        try {
            List<Person> people = readPeople(reader);
            List<Product> products = readProducts(reader);
            executeCommands(reader, people, products);
            String report = getPurchasingReport(people);
            System.out.println(report);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Person> readPeople(BufferedReader reader) throws IOException {
        String[] splitInput = reader.readLine().split("[=;]+");
        List<Person> people = new ArrayList<>(splitInput.length/2);

        for (int i = 0; i < splitInput.length; i+=2) {
            String name = splitInput[i];
            Double money = Double.parseDouble(splitInput[i + 1]);

            Person person = new Person(name, money);
            people.add(person);
        }

        return people;
    }
    public static List<Product> readProducts(BufferedReader reader) throws IOException {
        String[] splitInput = reader.readLine().split("[=;]+");
        List<Product> products = new ArrayList<>(splitInput.length/2);

        for (int i = 0; i < splitInput.length; i+=2) {
            String name = splitInput[i];
            Double price = Double.parseDouble(splitInput[i + 1]);

            Product product = new Product(name, price);
            products.add(product);
        }

        return products;
    }
    public static void executeCommands(BufferedReader reader, List<Person> people, List<Product> products) throws IOException {
        while(true){
            String inputLine = reader.readLine();

            boolean isBreakLoop = inputLine.equals("END");
            if (isBreakLoop){
                break;
            }

            String[] splitInput = inputLine.split("\\s+");
            String personName = splitInput[0];
            String productName = splitInput[1];

            Person person =
                    people
                            .stream()
                            .filter(p -> p.getNmae().equals(personName))
                            .findFirst()
                            .get();
            Product product =
                    products
                            .stream()
                            .filter(p -> p.getName().equals(productName))
                            .findFirst()
                            .get();

            if (person.canAfford(product)){
                person.buyProduct(product);
                System.out.println(
                        String.format(
                                "%s bought %s", personName, productName));
            }
            else{
                System.out.println(
                        String.format(
                                "%s can't afford %s", personName, productName));
            }
        }
    }
    public static String getPurchasingReport(List<Person> people){
        StringBuilder formated = new StringBuilder();
        for (Person person : people) {
            formated
                    .append(person)
                    .append(System.lineSeparator());
        }

        return formated.toString().trim();
    }
}
