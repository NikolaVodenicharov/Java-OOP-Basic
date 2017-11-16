public class Person {
    public String name;
    public Integer age;

    public Person(){
        this(1);
    }
    public Person(Integer age){
        this("No name", age);
    }
    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
