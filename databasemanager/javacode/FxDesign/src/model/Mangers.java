package model;

public class Mangers {
    private String number;
    private String password;
    private String name;

    public Mangers() {
    }

    public Mangers(String number, String password, String name) {
        this.number = number;
        this.password = password;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mangers{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
