package lab8.hotel;

import lab6.annotation.ManyToOne;
import lab8.annotation.Column;
import lab8.annotation.Entity;
import lab8.annotation.Id;

@Entity
public class Staff implements BaseEntity{

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    @ManyToOne
    private Reception reception;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    @Override
    public String toString() {
        return "" + id + "";
    }


    public String getDescription() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", reception=" + reception.getDescription() +
                '}';
    }

}
