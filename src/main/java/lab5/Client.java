package lab5;

public class Client {
    private String firstName;
    private String lastName;
    private char gender;
    private String email;

    public Client(String firstName, String lastName, String email, char gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    private Client() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
