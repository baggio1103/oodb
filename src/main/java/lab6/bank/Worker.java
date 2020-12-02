package lab6.bank;

import lab6.annotation.Column;
import lab6.annotation.Entity;

@Entity
public class Worker extends Person{

    @Column
    private Long id;

    @Column
    private String position;

    @Column
    private String code;

    Worker(String firstName, String lastName, String phoneNumber, String email, String position, String code) {
        super(firstName, lastName, phoneNumber, email);
        this.position = position;
        this.code = code;
    }


}
