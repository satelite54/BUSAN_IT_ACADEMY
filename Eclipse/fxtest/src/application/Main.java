package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent root = fxmlLoader.load(getClass().getResource("demo.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("fx");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// https://m.blog.naver.com/pmw9440/221981411851 ���̺귯�� ����Ʈ ���� ���� ��..
	// https://we-always-fight-with-code.tistory.com/36 ���� �ȵ� ��..
	// �ڸ��Ű�µ� ���� �����ϴµ� �ʹ� �ð� ���� �ɸ��� �Ф�
	public static void main(String[] args) {
		launch(args);  
	}
}