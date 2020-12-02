package lab5;

import org.postgresql.util.PGobject;

public class Person extends PGobject {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

    public Person(){
        setType("person");
    }

    

}
