public class StartUp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.id = 1;
        account.balance = 15;

        System.out.printf("Account ID%s, balance %.2f", account.id, account.balance);
    }
}