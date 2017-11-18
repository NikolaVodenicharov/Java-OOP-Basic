public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Integer getAge() {
        return this.age;
    }

    public String toString(){
        String formated =
                String.format(
                        "%s %s is %d years old.",
                        this.firstName,
                        this.lastName,
                        this.age);
        return formated;
    }
}
