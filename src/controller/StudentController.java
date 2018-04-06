package controller;

import com.jfoenix.controls.JFXButton;
import entity.Student;
import entityGet.StudentData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tableEntity.StudentTable;
import utility.ConnectionHandle;
import utility.JSONHandle;

import java.util.ArrayList;

public class StudentController {

    public static final String url = "https://too-late-to-apologize.appspot.com/_api/v1/users?page=1&limit=50";
    public static final String url1 = "https://too-late-to-apologize.appspot.com/_api/v1/users";


    public static ArrayList getListStudent(){

        String respone = ConnectionHandle.getContentFromUrl(url);
        ArrayList<StudentData> listStudentData = JSONHandle.parseJson(respone);
        ArrayList<Student> listStudent = new ArrayList<>();

        if(listStudentData != null){
            for (int i = 0; i < listStudentData.size(); i++) {
                Student student = new Student(listStudentData.get(i).getId(),
                        (i+1),
                        listStudentData.get(i).getAttributes().getRollNumber(),
                        listStudentData.get(i).getAttributes().getName(),
                        listStudentData.get(i).getAttributes().getPhone(),
                        listStudentData.get(i).getAttributes().getEmail(),
                        listStudentData.get(i).getAttributes().getAvatar());
                listStudent.add(student);
            }
        }
        return listStudent;
    }

    public static ArrayList tableFromList(){

        ArrayList<StudentTable> stTable = new ArrayList<>();
        ArrayList<Student> listStudent = getListStudent();

        if (listStudent != null) {
            for (int i = 0; i < listStudent.size(); i++) {
                StudentTable st = new StudentTable();
                Student student = listStudent.get(i);

                st.setStt(i+1);
                st.setName(student.getName());
                st.setRollNumber(student.getRollNumber());
                st.setPhone(student.getPhone());
                st.setEmail(student.getEmail());

                Image avt = new Image("http://lh3.googleusercontent.com/3tt6JIOzb8LKpSs07XfuweNUWYZ7ptbr54qE4J33ysYiQnXVt__MrxQhp47EyCGYthR6bfB3WUl4rEQ4wix_YG9uNvWQ2VYm6eD1hw");
                if (student.getAvatar().length() > 20) {
                    avt = new Image(student.getAvatar());
                }
                ImageView avatar = new ImageView(avt);
                avatar.setFitHeight(30);
                avatar.setFitWidth(30);

                st.setAvatar(avatar);

                JFXButton del = new JFXButton();
                del.setStyle(
                        "-fx-min-width: 32px; " +
                                "-fx-min-height: 32px; " +
                                "-fx-max-width: 32px; " +
                                "-fx-max-height: 32px; " +
                                "-fx-graphic: url('/resource/delete.png');" +
                                "-fx-graphic-size:30px 30px ;" +
                                "-fx-background-insets: 0px; " +
                                "-fx-padding: 0px;"
                );

                st.setDelete(del);

                stTable.add(st);


            }
        }

        return stTable;

    }
}
