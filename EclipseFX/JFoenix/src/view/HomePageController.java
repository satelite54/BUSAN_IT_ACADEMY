package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jfoenix.controls.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CStudent;
import model.DBConnect;


public class HomePageController {

	@FXML
	private JFXButton btnShow;

	@FXML
	private TableView<CStudent> tvStduent;

	@FXML
	private TableColumn<CStudent, String> colFname;

	@FXML
	private TableColumn<CStudent, String> colPass;

	@FXML
	private TableColumn<CStudent, String> colEmail;

	@FXML
	public void handleButton(ActionEvent event) {
		showStudents();
	}

    private DBConnect connection= new DBConnect();


	// DB�� �����ؼ� ��� �����͸� �����´�. ( 1. DB ���� 2.sql���� �ۼ� 3.sql���� �����ϰ� ����� �޾ƿ´�.)
	public ObservableList<CStudent> getStudentList(){
		//fx���� ���̺��信 ǥ���ϱ� ���� ����Ʈ�� oblservableList �� ����Ѵ�.(Ư¡ �̺�Ʈ�� ������ ��밡��)
		ObservableList<CStudent> stList = FXCollections.observableArrayList();

		//������ �ۼ�
		String sql = "SELECT * FROM student";
		//DB ����
		Connection conn = connection.getConnection();
		Statement stmt;          //DB�� ���� ���� ��ü
		ResultSet rs;            //DB���� ����� �޾ƿ� ��ü

		try {
			stmt = conn.createStatement(); //������ü ����
			rs = stmt.executeQuery(sql);   //stl������ �־ �����ϰ� ����� rs�� ��ƿ�
			CStudent st;
			while(rs.next()) {
				st = new CStudent( rs.getString("fullname"), rs.getString("password"), rs.getString("email"));
				stList.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stList;
	}
	@FXML
	public void showStudents() {
		ObservableList<CStudent> list = getStudentList();
		//���̺��� ����Ʈ�� �Է��Ѵ�.
		tvStduent.setItems(list);
		//������ ���鿡 �´� ���� �����͸� �������� �Ѵ�.
		colFname.setCellValueFactory(new PropertyValueFactory<CStudent, String>("fullname"));
		colPass.setCellValueFactory(new PropertyValueFactory<CStudent, String>("password"));
		colEmail.setCellValueFactory(new PropertyValueFactory<CStudent, String>("email"));

	}
}