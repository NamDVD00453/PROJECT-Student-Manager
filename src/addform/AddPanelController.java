package addform;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPanelController implements Initializable{

    @FXML
    private Label lb_Title;

    @FXML
    private JFXTextField txt_RollNumber;

    @FXML
    private Label lb_ErrPhone;

    @FXML
    private Label lb_ErrRollNumber;

    @FXML
    private JFXTextField txt_Phone;

    @FXML
    private Label lb_Email;

    @FXML
    private JFXButton btn_Refresh;

    @FXML
    private Label lb_Name;

    @FXML
    private JFXTextField txt_Email;

    @FXML
    private JFXButton btn_Add;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Label lb_Phone;

    @FXML
    private ImageView img_Avatar;

    @FXML
    private JFXButton btn_Exit;

    @FXML
    private Label lb_ErrName;

    @FXML
    private Label lb_RollNumber;

    @FXML
    private JFXButton btn_Upload;

    @FXML
    private Label lb_ErrEmail;

    @FXML
    private JFXTextField txt_Name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
