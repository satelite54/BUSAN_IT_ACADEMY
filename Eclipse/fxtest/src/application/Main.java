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
	// https://m.blog.naver.com/pmw9440/221981411851 라이브러리 임포트 오류 났을 때..
	// https://we-always-fight-with-code.tistory.com/36 실행 안될 때..
	// 자리옮겼는데 새로 세팅하는데 너무 시간 많이 걸린다 ㅠㅠ
	public static void main(String[] args) {
		launch(args);  
	}
}