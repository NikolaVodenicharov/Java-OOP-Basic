import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        Map<String, Car> cars = readCars(reader);
        executeCommands(cars, reader);
        printCars(cars);
    }

    public static LinkedHashMap<String, Car> readCars (BufferedReader reader) throws IOException {
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int inputCarsNumber = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputCarsNumber; i++) {
            String[] splitInput = reader.readLine().split("\\s+");

            String model = splitInput[0];
            double fuelVolume = Double.parseDouble(splitInput[1]);
            double fuelConsumption = Double.parseDouble(splitInput[2]);

            Car car = new Car(model, fuelVolume, fuelConsumption);
            cars.put(model, car);
        }

        return cars;
    }
    public static void executeCommands(Map<String, Car> cars, BufferedReader reader) throws IOException {
        while(true){
            String inputLine = reader.readLine();

            boolean isLoopBreak = inputLine.equals("End");
            if (isLoopBreak){
                break;
            }

            String[] splitInput = inputLine.split("\\s+");
            String model = splitInput[1];
            double distance = Double.parseDouble(splitInput[2]);

            boolean isCarExist = cars.containsKey(model);
            if (isCarExist){
                cars.get(model).drive(distance);
            }
        }
    }
    public static void printCars(Map<String, Car> cars){
        StringBuilder formated = new StringBuilder();
        for (Car car : cars.values()) {
            formated
                    .append(car)
                    .append(System.lineSeparator());
        }

        System.out.println(formated.toString().trim());
    }
}
