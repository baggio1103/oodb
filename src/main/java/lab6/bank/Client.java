package lab6.bank;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.OneToMany;

import java.util.List;

@Entity
public class Client extends Person{

    @Column
    @OneToMany
    private List<BankAccount> bankAccountList;


    Client(String firstName, String lastName, String phoneNumber, String email) {
        super(firstName, lastName, phoneNumber, email);
    }

    public long createBankAccount(){
        long newAccountNumber = BankAccount.currentAccountNumber++;

        bankAccountList.add(new BankAccount(newAccountNumber));

        return newAccountNumber;
    }

    private BankAccount findBankAccount(long accountNumber){
        for (BankAccount account : bankAccountList){
            if (account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

}
