package lab7.hotel;

import lab6.annotation.Column;
import lab6.annotation.ManyToOne;
import lab6.annotation.OneToOne;

public class Room {

    @Column
    private Long id;

    @Column
    private int roomCount;

    @Column
    @OneToOne
    private Client client;

    @Column
    @ManyToOne
    private Reception reception;

}
