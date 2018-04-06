package main;

import controller.StudentController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import props.LangController;
import tableEntity.StudentTable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private TableView<StudentTable> tableView;
    @FXML
    private TableColumn<StudentTable, String> col_Phone;

    @FXML
    private TableColumn<StudentTable, ImageView> col_Avatar;

    @FXML
    private TableColumn<StudentTable, Integer> col_Stt;

    @FXML
    private TableColumn<StudentTable, JFXButton> col_Delete;

    @FXML
    private TableColumn<StudentTable, String> col_RollNumber;

    @FXML
    private TableColumn<StudentTable, String> col_Name;

    @FXML
    private TableColumn<StudentTable, String> col_Email;

    @FXML
    private ImageView bk, bk_Selected, bk_0, bk_1, bk_2;

    @FXML
    private Label softwareName, softwareVer;
    @FXML
    private MenuItem menu_VN, menu_EN, bk_s0, bk_s1, bk_s2;
    @FXML
    private MenuButton menu_Button, menu_Bk;

    @FXML
    private JFXButton btn_Home, btn_Manager, btn_Attend, btn_Statistic, btn_Report, btn_AddNew, btn_Refresh, btn_About;

    @FXML
    private JFXTextField txt_Search;

    @FXML
    private Arc shadow_1, shadow_2, shadow_3, shadow_4, shadow_5;

    @FXML
    private AnchorPane home_Panel, manager_Panel, attend_Panel, statistic_Panel, report_Panel, about_Panel;


    private ObservableList<StudentTable> data;
    private ArrayList<StudentTable> tableArrayList = StudentController.tableFromList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LangController.loadLang("vi");

        loadDefault();

        initLang();

        initTable();

    }

    private void loadDefault() {
        hideAll();
        btn_Home.setStyle("-fx-background-color: #53e0b5");
        home_Panel.setVisible(true);
        shadow_1.setVisible(true);
    }

    public void initTable(){
        col_Stt.setCellValueFactory(new PropertyValueFactory<StudentTable, Integer>("stt"));
        col_Avatar.setCellValueFactory(new PropertyValueFactory<StudentTable, ImageView>("avatar"));
        col_RollNumber.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("rollNumber"));
        col_Name.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("name"));
        col_Phone.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("phone"));
        col_Email.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("email"));
        col_Delete.setCellValueFactory(new PropertyValueFactory<StudentTable, JFXButton>("delete"));

        col_Avatar.setStyle("-fx-alignment: CENTER;");
        col_Delete.setStyle("-fx-alignment: CENTER;");

        data = FXCollections.observableArrayList(tableArrayList);

        tableView.setItems(data);

    }

    private void initLang() {
        softwareName.setText(LangController.transLang("softwarename"));
        softwareVer.setText(LangController.transLang("softwarever"));

        col_Stt.setText(LangController.transLang("sttLabel"));
        col_Avatar.setText(LangController.transLang("avatarLabel"));
        col_RollNumber.setText(LangController.transLang("rollLabel"));
        col_Name.setText(LangController.transLang("nameLabel"));
        col_Phone.setText(LangController.transLang("phoneLabel"));
        col_Email.setText(LangController.transLang("emailLabel"));
        col_Delete.setText(LangController.transLang("deleteLabel"));

        btn_Home.setText(LangController.transLang("homePanel"));
        btn_Manager.setText(LangController.transLang("managerPanel"));
        btn_Attend.setText(LangController.transLang("attendPanel"));
        btn_Statistic.setText(LangController.transLang("statisticPanel"));
        btn_Report.setText(LangController.transLang("reportPanel"));

        btn_AddNew.setText(LangController.transLang("addStudent"));
        btn_Refresh.setText(LangController.transLang("refresh"));

        txt_Search.setPromptText(LangController.transLang("search"));

    }

    public void handlLang(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menu_VN) {
            LangController.loadLang("vi");
            initLang();
            menu_Button.setText("VN");

        } else
        if (actionEvent.getSource() == menu_EN){
            LangController.loadLang("en");
            initLang();
            menu_Button.setText("EN");
        }
    }

    public void handlBkChange(ActionEvent actionEvent){
        if (actionEvent.getSource() == bk_s0) {
            bk_Selected.setImage(new Image(getClass().getResourceAsStream("/resource/s_background.png")));
            bk.setImage(new Image(getClass().getResourceAsStream("/resource/background.png")));
        } else if (actionEvent.getSource() == bk_s1) {
            bk_Selected.setImage(new Image(getClass().getResourceAsStream("/resource/s_background1.png")));
            bk.setImage(new Image(getClass().getResourceAsStream("/resource/background1.png")));
        } else if (actionEvent.getSource() == bk_s2) {
            bk_Selected.setImage(new Image(getClass().getResourceAsStream("/resource/s_background2.png")));
            bk.setImage(new Image(getClass().getResourceAsStream("/resource/background2.png")));
        }
    }

    private void hideAll(){
        shadow_1.setVisible(false);
        shadow_2.setVisible(false);
        shadow_3.setVisible(false);
        shadow_4.setVisible(false);
        shadow_5.setVisible(false);

        btn_Home.setStyle("-fx-background-color: #5ea9ff");
        btn_Manager.setStyle("-fx-background-color: #5ea9ff");
        btn_Attend.setStyle("-fx-background-color: #5ea9ff");
        btn_Statistic.setStyle("-fx-background-color: #5ea9ff");
        btn_Report.setStyle("-fx-background-color: #5ea9ff");

        home_Panel.setVisible(false);
        manager_Panel.setVisible(false);
        attend_Panel.setVisible(false);
        statistic_Panel.setVisible(false);
        report_Panel.setVisible(false);

        about_Panel.setVisible(false);

    }

    public void handlSelect(ActionEvent actionEvent){
        if (actionEvent.getSource() == btn_Home){

            hideAll();
            shadow_1.setVisible(true);
            btn_Home.setStyle("-fx-background-color: #53e0b5");
            home_Panel.setVisible(true);

        } else if (actionEvent.getSource() == btn_Manager){

            hideAll();
            shadow_2.setVisible(true);
            btn_Manager.setStyle("-fx-background-color: #53e0b5");
            manager_Panel.setVisible(true);

        } else if (actionEvent.getSource() == btn_Attend){

            hideAll();
            shadow_3.setVisible(true);
            btn_Attend.setStyle("-fx-background-color: #53e0b5");
            attend_Panel.setVisible(true);

        } else if (actionEvent.getSource() == btn_Statistic){

            hideAll();
            shadow_4.setVisible(true);
            btn_Statistic.setStyle("-fx-background-color: #53e0b5");
            statistic_Panel.setVisible(true);

        } else if (actionEvent.getSource() == btn_Report){

            hideAll();
            shadow_5.setVisible(true);
            btn_Report.setStyle("-fx-background-color: #53e0b5");
            report_Panel.setVisible(true);

        }
    }

    public void handlAdd(ActionEvent actionEvent){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/addform/AddPanel.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Thêm sinh viên");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void about(ActionEvent actionEvent) {

        hideAll();
        about_Panel.setVisible(true);

    }
}
