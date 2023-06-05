package model;

public class Students {
    private String name;
    private String gender;
    private String classRoom;
    private String number;
    private String password;
    private double g_Chinese;
    private double g_Math;
    private double g_English;
    private double g_history;
    private double g_music;
    private double g_computer;
    private double g_polity;
    private double g_Sum;
    private double g_Avg;
    private String chinese_date_place;
    private String math_date_place;
    private String english_date_place;


    public Students() {
    }

    public Students(String name, String gender, String classRoom, String number, String password, double g_Chinese, double g_Math, double g_English, double g_history, double g_music, double g_computer, double g_polity, double g_Sum, double g_Avg, String chinese_date_place, String math_date_place, String english_date_place) {
        this.name = name;
        this.gender = gender;
        this.classRoom = classRoom;
        this.number = number;
        this.password = password;
        this.g_Chinese = g_Chinese;
        this.g_Math = g_Math;
        this.g_English = g_English;
        this.g_history = g_history;
        this.g_music = g_music;
        this.g_computer = g_computer;
        this.g_polity = g_polity;
        this.g_Sum = g_Sum;
        this.g_Avg = g_Avg;
        this.chinese_date_place = chinese_date_place;
        this.math_date_place = math_date_place;
        this.english_date_place = english_date_place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
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

    public double getG_Chinese() {
        return g_Chinese;
    }

    public void setG_Chinese(double g_Chinese) {
        this.g_Chinese = g_Chinese;
    }

    public double getG_Math() {
        return g_Math;
    }

    public void setG_Math(double g_Math) {
        this.g_Math = g_Math;
    }

    public double getG_English() {
        return g_English;
    }

    public void setG_English(double g_English) {
        this.g_English = g_English;
    }

    public double getG_history() {
        return g_history;
    }

    public void setG_history(double g_history) {
        this.g_history = g_history;
    }

    public double getG_music() {
        return g_music;
    }

    public void setG_music(double g_music) {
        this.g_music = g_music;
    }

    public double getG_computer() {
        return g_computer;
    }

    public void setG_computer(double g_computer) {
        this.g_computer = g_computer;
    }

    public double getG_polity() {
        return g_polity;
    }

    public void setG_polity(double g_polity) {
        this.g_polity = g_polity;
    }

    public double getG_Sum() {
        return g_Sum;
    }

    public void setG_Sum(double g_Sum) {
        this.g_Sum = g_Sum;
    }

    public double getG_Avg() {
        return g_Avg;
    }

    public void setG_Avg(double g_Avg) {
        this.g_Avg = g_Avg;
    }

    public String getChinese_date_place() {
        return chinese_date_place;
    }

    public void setChinese_date_place(String chinese_date_place) {
        this.chinese_date_place = chinese_date_place;
    }

    public String getMath_date_place() {
        return math_date_place;
    }

    public void setMath_date_place(String math_date_place) {
        this.math_date_place = math_date_place;
    }

    public String getEnglish_date_place() {
        return english_date_place;
    }

    public void setEnglish_date_place(String english_date_place) {
        this.english_date_place = english_date_place;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classRoom='" + classRoom + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", g_Chinese=" + g_Chinese +
                ", g_Math=" + g_Math +
                ", g_English=" + g_English +
                ", g_history=" + g_history +
                ", g_music=" + g_music +
                ", g_computer=" + g_computer +
                ", g_polity=" + g_polity +
                ", g_Sum=" + g_Sum +
                ", g_Avg=" + g_Avg +
                ", chinese_date_place='" + chinese_date_place + '\'' +
                ", math_date_place='" + math_date_place + '\'' +
                ", english_date_place='" + english_date_place + '\'' +
                '}';
    }
}
