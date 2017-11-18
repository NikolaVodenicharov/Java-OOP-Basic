import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.printf(
                    "Chicken %s (age %d) can produce 1 eggs per day.",
                    chicken.getName(),
                    chicken.getAge());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
