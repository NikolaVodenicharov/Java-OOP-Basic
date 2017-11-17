public class Car {
    private final String DEFAULT_VALUE = "n/a";

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = DEFAULT_VALUE;
        this.color = DEFAULT_VALUE;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        StringBuilder formated = new StringBuilder();
        formated
                .append(String.format("%s:",this.model))
                .append(System.lineSeparator())
                .append(String.format("  %s",this.engine))
                .append(System.lineSeparator())
                .append(String.format("  Weight: %s",this.weight))
                .append(System.lineSeparator())
                .append(String.format("  Color: %s",this.color));

        return formated.toString();
    }
}
