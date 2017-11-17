import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Car> cars = readCars(reader);
        List<String> filteredModels = filterCarModels(cars, reader);
        printColelction(filteredModels);
    }

    public static List<Car> readCars (BufferedReader reader) throws IOException {
        int inputCarsNumber = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<Car>(inputCarsNumber);

        for (int i = 0; i < inputCarsNumber; i++) {
            String[] splitInput = reader.readLine().split("\\s+");

            String model = splitInput[0];
            Engine engine = createEngine(splitInput);
            Cargo cargo = createCargo(splitInput);
            Tyre[] tyres = createTyres(splitInput);

            Car car = new Car(model, engine, cargo, tyres);
            cars.add(car);
        }

        return cars;
    }
    public static Engine createEngine(String[] splitInput){
        int speed = Integer.parseInt(splitInput[1]);
        int power = Integer.parseInt(splitInput[2]);
        Engine engine = new Engine(speed, power);

        return engine;
    }
    public static Cargo createCargo(String[] splitInput){
        int weight = Integer.parseInt(splitInput[3]);
        String type = splitInput[4];
        Cargo cargo = new Cargo(type, weight);

        return cargo;
    }
    public static Tyre[] createTyres(String[] splitInput){
        List<Tyre> tyres = new ArrayList<>(4);

        for (int i = 5; i < splitInput.length; i +=2) {
            double tyrePressure = Double.parseDouble(splitInput[i]);
            int tyreAge = Integer.parseInt(splitInput[i +1]);
            Tyre tyre = new Tyre(tyrePressure, tyreAge);
            tyres.add(tyre);
        }

        return tyres.toArray(new Tyre[0]);
    }

    public static List<String> filterCarModels(List<Car> cars, BufferedReader reader) throws IOException {
        String command = reader.readLine();
        List<String> models = null;

        if (command.equals("fragile")){
            double tyrePressureLessThan = 1;
            models =
                    cars
                    .stream()
                    .filter(c -> Arrays.stream(c.getTyres()).allMatch(t -> t.getPressure() < tyrePressureLessThan))
                    .map(c -> c.getModel())
                    .collect(Collectors.toList());
        }
        else if(command.equals("flamable")){
            int enginePowerMoreThan = 250;
            models =
                    cars
                    .stream()
                    .filter(c -> c.getEngine().getPower() > enginePowerMoreThan)
                    .map(c -> c.getModel())
                    .collect(Collectors.toList());
        }
        else{
            // throw exception
        }

        return models;
    }
    public static void printColelction(List<String> models){
        StringBuilder sb = new StringBuilder();
        for (String model : models) {
            sb
                    .append(model)
                    .append(System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }
}
