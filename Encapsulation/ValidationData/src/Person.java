public class Person {
    private final Integer FULL_BONUS_MINIMUM_AGE = 30;
    private final Double REDUCED_BONUS_COEFFICIENT = 0.5;

    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age, Double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private void setFirstName(String firstName) {
        if(firstName == null){
            throw new NullPointerException("First name cannot be null");
        }
        if (firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }

        this.firstName = firstName;
    }
    private void setLastName(String lastName) {
        if(lastName == null){
            throw new NullPointerException("Last name cannot be null");
        }
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }
    private void setAge(Integer age) {
        if(age == null){
            throw new NullPointerException("Age cannot be null");
        }
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }

        this.age = age;
    }
    private void setSalary(Double salary) {
        if (salary == null){
            throw new NullPointerException("Salary cannot be null");
        }
        if (salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }

        this.salary = salary;
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
