package lab6.bank;

import lab6.annotation.Column;
import lab6.annotation.Entity;

@Entity
public class BankAccount {

    public static long currentAccountNumber = 1000000000000000L;

    @Column
    private long accountNumber;

    @Column
    private double balance;

    BankAccount(long accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    protected void increaseBalance(double cash) {
        this.balance += cash;
    }

    protected boolean reduceBalance(double cash) {
        if (balance < cash) {
            return false;
        } else {
            this.balance -= cash;
            return true;
        }
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
