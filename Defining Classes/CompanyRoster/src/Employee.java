public class Employee {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    public Employee(String name, Double salary, String position, String department){
        this(name, salary, position, department, "n/a", -1);
    }
    public Employee(String name, Double salary, String position, String department, String email){
        this(name, salary, position, department, email, -1);
    }
    public Employee(String name, Double salary, String position, String department, Integer age){
        this(name, salary, position, department, "n/a", age);
    }
    public Employee(String name, Double salary, String position, String department, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public Double getSalary() {
        return salary;
    }
    public String getPosition() {
        return position;
    }
    public String getDepartment() {
        return department;
    }
    public String getEmail() {
        return email;
    }
    public Integer getAge() {
        return age;
    }

    public String toString(){
        String formated = String.format(
                "%s %.2f %s %d",
                this.name,
                this.salary,
                this.email,
                this.age);
        return formated;
    }
}
