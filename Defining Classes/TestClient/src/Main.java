import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accoutns = new HashMap<>();

        while(true){
            String inputLine = reader.readLine();

            boolean isLoopBreak = inputLine.equals("End");
            if (isLoopBreak){
                break;
            }

            String[] splitInput = inputLine.split("\\s");
            String command = splitInput[0];
            Integer id = Integer.valueOf(splitInput[1]);
            int amount = splitInput.length == 3 ? Integer.parseInt(splitInput[2]) : 0;

            switch (command){
                case "Create":
                    addNewBankAccount(accoutns, id);
                case "Deposit":
                    deposit(accoutns, id, amount);
                    break;
                case "Withdraw":
                    withdraw(accoutns, id, amount);
                    break;
                case "Print":
                    printBankAccount(accoutns, id);
                    break;
                default:
                    break;
            }
        }
    }

    private static void addNewBankAccount(HashMap<Integer, BankAccount> accoutns, int id) {
        if(!accoutns.containsKey(id)){
            BankAccount account = new BankAccount();
            account.setId(id);
            accoutns.put(id, account);
        }
        else{
            System.out.println("Account already exists");
        }
    }
    private static void deposit (HashMap<Integer, BankAccount> accoutns, int id, int amount){
        if(accoutns.containsKey(id)){
            try{
                accoutns.get(id).deposit(amount);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Account does not exist");
        }
    }
    private static void withdraw (HashMap<Integer, BankAccount> accoutns, int id, int amount){
        if(accoutns.containsKey(id)){
            try{
            accoutns.get(id).withdraw(amount);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Account does not exist");
        }
    }
    private static void printBankAccount(HashMap<Integer, BankAccount> accoutns, int id){
        if(accoutns.containsKey(id)){
            System.out.printf(
                    "Account ID%d, balance %.2f"
                    + System.lineSeparator(),
                    id,
                    accoutns.get(id).getBalance());
        }
        else{
            System.out.println("Account does not exist");
        }


    }
}



