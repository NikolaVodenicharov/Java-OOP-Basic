import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while(true){
            String inputLine = reader.readLine();

            boolean isLoopBreak = inputLine.equals("End");
            if (isLoopBreak){
                break;
            }

            String[] splitInput = inputLine.split("\\s");
            String command = splitInput[0];

            switch (command){
                case "Create":
                    addNewBankAccount(accounts);
                    break;
                case "Deposit":
                    deposit(accounts, splitInput);
                    break;
                case "SetInterest":
                    setInterest(splitInput);
                    break;
                case "GetInterest":
                    printInterest(accounts, splitInput);
                    break;
                default:
                    break;
            }
        }
    }

    private static void addNewBankAccount(HashMap<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf(
                "Account ID%d created" +
                        System.lineSeparator(),
                account.getId());
    }
    private static void deposit (HashMap<Integer, BankAccount> accounts, String[] splitInput){
        Integer id = Integer.parseInt(splitInput[1]);
        Integer amount = Integer.parseInt(splitInput[2]);

        if(accounts.containsKey(id)){
            try{
                accounts.get(id).deposit(amount);
                System.out.printf(
                        "Deposited %d to ID%d"
                                + System.lineSeparator(),
                        amount,
                        id);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Account does not exist");
        }
    }
    private static void setInterest(String[] splitInput) {
        Double interest = Double.parseDouble(splitInput[1]);
        BankAccount.setInterestRate(interest);
    }
    private static void printInterest(HashMap<Integer, BankAccount> accoutns, String[] splitInput){
        Integer id = Integer.parseInt(splitInput[1]);
        Integer years = Integer.parseInt(splitInput[2]);

        if(accoutns.containsKey(id)){
            Double interest = accoutns.get(id).getInterest(years);
            System.out.printf(
                    "%.2f" +
                    System.lineSeparator(),
                    interest);
        }
        else{
            System.out.println("Account does not exist");
        }
    }
}
