import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Integer age;
    private List<BankAccount> accounts;

    public Person(String name, Integer age){
        this(name, age, new ArrayList<BankAccount>());
    }

    public Person(String name, Integer age, List<BankAccount> accounts){
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public double getBalance(){
        return this.accounts.stream().mapToDouble(acc -> acc.getBalance()).sum();
    }
}
