public class Engine {
    private final String DEFAULT_VALUE = "n/a";

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = DEFAULT_VALUE;
        this.efficiency = DEFAULT_VALUE;
    }

    public String getModel() {
        return model;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }
    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String toString(){
        StringBuilder formated = new StringBuilder();
        formated
                .append(String.format("%s:",this.model))
                .append(System.lineSeparator())
                .append(String.format("    Power: %s",this.power))
                .append(System.lineSeparator())
                .append(String.format("    Displacement: %s",this.displacement))
                .append(System.lineSeparator())
                .append(String.format("    Efficiency: %s",this.efficiency));

        return formated.toString();
    }
}
