class UserAccount {
    String fullName;
    String phoneNumber;
    String password;
    String accountNumber;
    double balance;

    public UserAccount(String fullName, String phoneNumber, String password, String accountNumber, double balance) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}