import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        Engine[] engines = readEngines(reader);
        Car[] cars = readCars(reader, engines);
        String carsInfo = collectionToString(cars);
        System.out.println(carsInfo);

    }

    public static Engine[] readEngines(BufferedReader reader) throws IOException {
        int inputEnginesNumber = Integer.parseInt(reader.readLine());
        List<Engine> engines = new ArrayList<>(inputEnginesNumber);

        for (int i = 0; i < inputEnginesNumber; i++) {
            String[] splitInput = reader.readLine().split("\\s+");
            String model = splitInput[0];
            String power = splitInput[1];

            Engine engine = new Engine(model, power);

            if(splitInput.length >= 3){
                if (splitInput[2].matches("\\d+")){
                    engine.setDisplacement(splitInput[2]);

                    if(splitInput.length == 4){
                        engine.setEfficiency(splitInput[3]);
                    }
                }
                else{
                    engine.setEfficiency(splitInput[2]);
                }
            }

            engines.add(engine);
        }

        return engines.toArray(new Engine[0]);
    }
    public static Car[] readCars(BufferedReader reader, Engine[] engines) throws IOException {
        int inputCarsNumber = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>(inputCarsNumber);

        for (int i = 0; i < inputCarsNumber; i++) {
            String[] splitInput = reader.readLine().split("\\s+");
            String model = splitInput[0];
            String engineModel = splitInput[1];

            // check for existing engine before findFirst
            Engine engine =
                    Arrays.stream(engines)
                            .filter(e -> e.getModel().equals(engineModel))
                            .findFirst()
                            .get();
            Car car = new Car(model, engine);

            if(splitInput.length >= 3){
                if(splitInput[2].matches("\\d+")){
                    car.setWeight(splitInput[2]);

                    if (splitInput.length == 4){
                        car.setColor(splitInput[3]);
                    }
                }
                else{
                    car.setColor(splitInput[2]);
                }
            }

            cars.add(car);
        }

        return cars.toArray(new Car[0]);
    }
    public static String collectionToString(Car[] cars){
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb
                    .append(car)
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
