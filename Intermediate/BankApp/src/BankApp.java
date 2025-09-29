import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// ----------------------
// Banking Logic
// ----------------------
class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactions = new ArrayList<>();
    private double overdraftLimit = -500.0; // max negative balance

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        transactions.add("Account opened with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit must be > 0");
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdraw must be > 0");
        if (balance - amount < overdraftLimit)
            throw new IllegalStateException("Overdraft limit reached");
        balance -= amount;
        transactions.add("Withdrew: " + amount);
    }

    public void addInterest(double rate) {
        if (rate < 0)
            throw new IllegalArgumentException("Rate must be positive");
        double interest = balance * rate / 100;
        balance += interest;
        transactions.add("Interest added: " + interest);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }
}

// ----------------------
// JUnit Tests
// ----------------------
class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount("123", 1000);
    }

    @Test
    void testDepositIncreasesBalance() {
        account.deposit(200);
        assertEquals(1200, account.getBalance(), 0.001);
    }

    @Test
    void testDepositNegativeAmountThrows() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    void testWithdrawDecreasesBalance() {
        account.withdraw(300);
        assertEquals(700, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawBeyondOverdraftThrows() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(2000));
    }

    @Test
    void testAddInterestWorks() {
        account.addInterest(10); // 10% of 1000 = 100
        assertEquals(1100, account.getBalance(), 0.001);
    }

    @Test
    void testTransactionHistoryTracks() {
        account.deposit(100);
        account.withdraw(50);
        assertTrue(account.getTransactions().size() >= 3); // includes initial
    }
}
