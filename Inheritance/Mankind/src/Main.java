import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        try {
            Student student = readStudent(reader);
            System.out.println(student);

            Worker worker = readWorker(reader);
            System.out.println(worker);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static Student readStudent(BufferedReader reader) throws IOException {
        String[] parameters = reader.readLine().split("\\s+");
        if (parameters.length != 3){
            // throw exception
        }

        String firstName = parameters[0];
        String lastName = parameters[1];
        String facultyNumber = parameters[2];
        Student student = new Student(firstName, lastName, facultyNumber);

        return student;
    }
    public static Worker readWorker(BufferedReader reader) throws IOException {
        String[] parameters = reader.readLine().split("\\s+");

        if (parameters.length != 4){
            // thorw exception
        }

        String firstName = parameters[0];
        String lastName = parameters[1];
        double weekSalary = Double.parseDouble(parameters[2]);
        double workingHoursDaily = Double.parseDouble(parameters[3]);

        Worker worker = new Worker(firstName, lastName, weekSalary, workingHoursDaily);

        return worker;
    }
}
