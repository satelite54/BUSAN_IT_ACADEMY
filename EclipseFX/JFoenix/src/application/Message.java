package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Message {
	public void setMessage(String str) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText("Alert Message");
		alert.setContentText(str);
		alert.show();
	}
}
