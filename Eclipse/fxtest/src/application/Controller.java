package application;


import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

	@FXML
	Button btn;
	
    @FXML
    void ButtonClick(ActionEvent event) {
    	Random random = new Random();
    	int rand = random.nextInt(1000) + 1; // 1~1000
    	System.out.println(rand);
    }
}
