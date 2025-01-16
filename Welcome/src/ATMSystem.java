import java.util.*;

public class ATMSystem {
    private final List<UserAccount> userAccounts;
    private final FileHandler fileHandler;

    public ATMSystem() {
        fileHandler = new FileHandler();
        userAccounts = fileHandler.loadAccounts();
    }

    public void createNewAccount(String fullName, String phoneNumber, String password, double initialBalance) {
        String accountNumber = generateAccountNumber();
        UserAccount newUser = new UserAccount(fullName, phoneNumber, password, accountNumber, initialBalance);
        userAccounts.add(newUser);
        fileHandler.saveAccounts(userAccounts);
        System.out.println("Account created successfully! Your Account Number: " + accountNumber);
    }

    public UserAccount login(String accountNumber, String password) {
        for (UserAccount user : userAccounts) {
            if (user.getAccountNumber().equals(accountNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void performTransaction(UserAccount user, String action, double amount) {
        switch (action.toLowerCase()) {
            case "deposit":
                user.deposit(amount);
                System.out.println("Deposit successful! New Balance: " + user.getBalance());
                break;
            case "withdraw":
                if (user.withdraw(amount)) {
                    System.out.println("Withdrawal successful! New Balance: " + user.getBalance());
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
            case "balance":
                System.out.println("Current Balance: " + user.getBalance());
                break;
            default:
                System.out.println("Invalid transaction type.");
        }
        fileHandler.saveAccounts(userAccounts);
    }

    private String generateAccountNumber() {
        return String.format("%07d", new Random().nextInt(9999999));
    }
}
