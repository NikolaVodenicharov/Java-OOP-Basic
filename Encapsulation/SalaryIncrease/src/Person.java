public class Person {
    private final Integer FULL_BONUS_MINIMUM_AGE = 30;
    private final Double REDUCED_BONUS_COEFFICIENT = 0.5;

    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public Integer getAge() {
        return this.age;
    }

    public void increaseSalary(double bonus){
        if (this.age > FULL_BONUS_MINIMUM_AGE){
            this.salary += (this.salary * bonus) / 100;
        }
        else{
            this.salary += (this.salary * bonus * REDUCED_BONUS_COEFFICIENT) / 100;
        }
    }
    public String toString(){
        String formated =
                String.format(
                        "%s %s gets " + this.salary + " leva",
                        this.firstName,
                        this.lastName);
        return formated;
        // Asen Ivanov get 2640.0 leva
    }
}
