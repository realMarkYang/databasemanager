package model;

public class Teacher {
    private String name;
    private String number;
    private String gender;
    private String phone;
    private String task;

    public Teacher() {
    }

    public Teacher(String name, String number, String gender, String phone, String task) {
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.phone = phone;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
