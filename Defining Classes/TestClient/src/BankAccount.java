public class BankAccount {
    private int id;
    private double balance;

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("Amount of money can not be negative number.");
        }
        this.balance += amount;
    }
    public void withdraw(double amount){
        if (this.balance < amount){
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public String toString(){
        return "ID" + this.id;
    }
}
