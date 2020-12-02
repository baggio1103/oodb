package lab6.bank;

import lab6.annotation.Column;
import lab6.annotation.Entity;

import java.util.Date;

@Entity
public class Transaction {

    @Column
    private BankAccount bankAccount;

    @Column
    private Worker worker;

    @Column
    private Date transactionDate;

    @Column
    private Client client;

    @Column
    private double amount;

    public Transaction(BankAccount bancAccount, Worker worker, Client client, double amount) {
        this.bankAccount = bancAccount;
        this.worker = worker;
        this.transactionDate = new Date();
        this.client = client;
        this.amount = amount;
        if (amount > 0) {
            increaseBalance(amount);
        } else {
            reduceBalance(amount);
        }
    }

    private void increaseBalance(double amount) {
        bankAccount.increaseBalance(amount);
    }

    private boolean reduceBalance(double amount) {
        return bankAccount.reduceBalance(amount);
    }

    public BankAccount getBancAccount() {
        return bankAccount;
    }

    public void setBancAccount(BankAccount bancAccount) {
        this.bankAccount = bancAccount;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
