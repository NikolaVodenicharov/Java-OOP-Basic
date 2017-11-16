public class StartUp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setId(1);
        account.deposit(15);
        account.withdraw(5);

        System.out.printf("Account %s banalce %.2f", account, account.getBalance());
    }
}
