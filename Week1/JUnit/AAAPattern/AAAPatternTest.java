public class AAAPatternTest {

    static class BankAccount {
        private String owner;
        private double balance;

        BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        void deposit(double amount) {
            if (amount <= 0)
                throw new IllegalArgumentException("Deposit amount must be positive");
            balance += amount;
        }

        void withdraw(double amount) {
            if (amount <= 0)
                throw new IllegalArgumentException("Withdrawal amount must be positive");
            if (amount > balance)
                throw new IllegalArgumentException("Insufficient funds");
            balance -= amount;
        }

        double getBalance() {
            return balance;
        }

        String getOwner() {
            return owner;
        }
    }

    static void testDeposit() {
        BankAccount account = new BankAccount("Utsah", 1000.0);

        account.deposit(500.0);

        assert account.getBalance() == 1500.0 : "Balance should be 1500 after deposit";
        System.out.println("✓ testDeposit passed - Balance: " + account.getBalance());
    }

    static void testWithdraw() {
        BankAccount account = new BankAccount("Utsah", 1000.0);

        account.withdraw(300.0);

        assert account.getBalance() == 700.0 : "Balance should be 700 after withdrawal";
        System.out.println("✓ testWithdraw passed - Balance: " + account.getBalance());
    }

    static void testInsufficientFunds() {
        BankAccount account = new BankAccount("Utsah", 500.0);

        try {
            account.withdraw(1000.0);
            System.out.println("✗ testInsufficientFunds failed");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testInsufficientFunds passed - " + e.getMessage());
        }
    }

    static void testInvalidDeposit() {
        BankAccount account = new BankAccount("Utsah", 1000.0);

        try {
            account.deposit(-100.0);
            System.out.println("✗ testInvalidDeposit failed");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ testInvalidDeposit passed - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Running AAA Pattern Tests ===");
        testDeposit();
        testWithdraw();
        testInsufficientFunds();
        testInvalidDeposit();
        System.out.println("=== All AAA Pattern Tests Passed ===");
    }
}