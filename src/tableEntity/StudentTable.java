package tableEntity;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;

public class StudentTable {

    private int stt;
    private ImageView avatar;
    private String rollNumber;
    private String name;
    private String phone;
    private String email;
    private JFXButton delete;

    public StudentTable() {
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
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

    public JFXButton getDelete() {
        return delete;
    }

    public void setDelete(JFXButton delete) {
        this.delete = delete;
    }
}
