package lab7.hotel;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.annotation.ManyToOne;
import lab6.annotation.OneToMany;

@Entity
public class Staff {

    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @ManyToOne
    private Reception reception;

}
