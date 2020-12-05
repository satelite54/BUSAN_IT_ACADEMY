package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DBConnect;
import application.Message;

public class LoginController {

	@FXML
    private AnchorPane anPane;

    @FXML
    private JFXTextField tfFname;

    @FXML
    private JFXPasswordField tfPass;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnLogin;


    Message msg = new Message();
    DBConnect connection= new DBConnect();
    private Connection conn;
    private PreparedStatement pstmt;


    @FXML
    void createLogin(ActionEvent event) throws SQLException, IOException {

    	conn = connection.getConnection();

    	String sql = "SELECT *FROM STUDENT where email=? and password=?";

    	pstmt = conn.prepareStatement(sql);

    	pstmt.setString(1, tfFname.getText());
        pstmt.setString(2, tfPass.getText());

        ResultSet rs = pstmt.executeQuery();


        boolean isValid = false;

        while(rs.next())
        {
        	isValid = true;
        }/* */

        if(isValid)
        {

        	btnLogin.getScene().getWindow().hide();

        	Stage home = new Stage();
        	Parent root = FXMLLoader.load(getClass().getResource("../view/HomePage.fxml"));
        	home.setScene(new Scene(root));
        	home.show();
        }
        else
        {
        	msg.setMessage("Login is failed");
        }

    }

    @FXML
    void createregister(ActionEvent event) throws IOException {

    	btnRegister.getScene().getWindow().hide();

    	Stage signup = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/SignUP.fxml"));
    	Scene scene = new Scene(root);
    	signup.setScene(scene);
    	signup.show();

    }


}
