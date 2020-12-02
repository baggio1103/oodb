package lab6.bank;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.OneToMany;

import java.util.List;

@Entity
public class Bank {

    @Column
    private String name;

    @Column
    @OneToMany
    private static List<Worker> workers;

    @Column
    @OneToMany
    private static List<Transaction> transactions;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
