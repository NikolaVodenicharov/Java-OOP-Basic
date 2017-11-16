public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount;

    private int id;
    private double balance;

    public BankAccount(){
        this.id = ++bankAccountCount;
    }

    public int getId(){
        return this.id;
    }

    public void deposit(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("Amount of money can not be negative number.");
        }
        this.balance += amount;
    }
    public double getInterest(Integer years){
        return this.balance * rate * years;
    }
    public String toString(){
        return "ID" + this.id;
    }
    public static void setInterestRate(Double interest){
        rate = interest;
    }

}
