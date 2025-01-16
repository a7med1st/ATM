import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "accounts.txt";

    public List<UserAccount> loadAccounts() {
        List<UserAccount> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String fullName = data[0];
                String phoneNumber = data[1];
                String password = data[2];
                String accountNumber = data[3];
                double balance = Double.parseDouble(data[4]);
                accounts.add(new UserAccount(fullName, phoneNumber, password, accountNumber, balance));
            }
        } catch (IOException e) {
            System.out.println("No existing accounts found or error loading accounts.");
        }
        return accounts;
    }

    public void saveAccounts(List<UserAccount> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (UserAccount account : accounts) {
                writer.write(String.format("%s,%s,%s,%s,%.2f",
                        account.getFullName(),
                        account.getPhoneNumber(),
                        account.getPassword(),
                        account.getAccountNumber(),
                        account.getBalance()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }
}
