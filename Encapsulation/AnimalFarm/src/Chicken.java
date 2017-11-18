public class Chicken {
    private String name;
    private Integer age;

    public Chicken(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }
    private void setName(String name) {
        if (name == null){
            throw new NullPointerException("Name can not be null.");
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if(name.matches("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty.");      //("Name cannot be whitespace.");
        }

        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }
    private void setAge(Integer age) {
        if(age == null){
            throw new NullPointerException("Age can not be null.");
        }
        if (age > 15 || age < 0){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    private double calculateProductPerDay(){
        double production = 0;
        if (this.age <= 6){
            production = 2;
        }
        else if (this.age <= 12){
            production = 1;
        }
        else{
            production = 0.75;
        }

        return production;
    }
    public double productionPerDay(){
        double production = this.calculateProductPerDay();
        return production;
    }
}
