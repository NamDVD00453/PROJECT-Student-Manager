package entity;

public class Student {

    private String id;
    private int stt;
    private String rollNumber;
    private String name;
    private String phone;
    private String email;
    private String avatar;
    public Student() {

    }

    public Student(String id, int stt, String rollNumber, String name, String phone, String email, String avatar) {
        this.id = id;
        this.stt = stt;
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
