public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre[] tyres;

    public Car(String model, Engine engine, Cargo cargo, Tyre[] tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;

    }

    public Tyre[] getTyres() {
        return tyres;
    }
}
