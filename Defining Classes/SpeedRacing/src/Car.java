public class Car {
    private final double DEFAULT_MILEAGE = 0;

    private String model;
    private double fuelVolume;
    private double fuelConsumption;
    private double mileage;

    public Car(String model, double fuelVolume, double fuelConsumption) {
        this.model = model;
        this.fuelVolume = fuelVolume;
        this.fuelConsumption = fuelConsumption;
        this.mileage = this.DEFAULT_MILEAGE;
    }

    public void drive(Double distance){
        double consumedFuel = this.fuelConsumption * distance;
        boolean isFuelSufficient = consumedFuel <= this.fuelVolume;

        if (isFuelSufficient){
            this.fuelVolume -= consumedFuel;
            this.mileage += distance;
        }
        else{
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String toString(){
        String formated =
                String.format(
                "%s %.2f %.0f",
                this.model,
                this.fuelVolume,
                this.mileage);

        return formated;
    }
}
