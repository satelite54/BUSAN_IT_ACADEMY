package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class xx extends Main {

    @FXML
    private JFXTextField txid;

    @FXML
    private JFXPasswordField txps;

    @FXML
    private JFXButton login;

    @FXML
    private Label labelbtn;

    @FXML
    void loginClick(ActionEvent event) {
    	if(txid.getText().equals("myid") && (txps.getText().equals("mypass"))) {
    		labelbtn.setText("�α��� �Ϸ�!");
    		try {
				newPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Stage stage = (Stage) this.login.getScene().getWindow();
    		stage.close();
    	} else {
    		labelbtn.setText("�α��� ����!");
    	}
    }
}