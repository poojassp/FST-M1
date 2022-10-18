package activities;


import org.testng.annotations.Test;
import activities.BankAccount;
import activities.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

public class activity2 {

    @org.testng.annotations.Test
    void notEnoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(9);

        // Assertion for exception
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(100);

        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}