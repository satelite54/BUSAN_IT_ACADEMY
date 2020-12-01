package application;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class demoController {
	@FXML
	private Label lbresult;
	// Scene에서 버튼에 on Action에 함수명 입력하고 컨트롤 생성하면 버튼 클릭 시 메소드 실행
	// Event Listener on Button.onAction
	
	private double number1 = 0.0;
	private double number2 = 0.0;
	private String operator = "";
	model model1 = new model();
	
	@FXML
	public void numbers(ActionEvent event) { // 숫자를 눌렀을 때 // 뭔가 이벤트가 발생했을 때
		String num = ((Button)event.getSource()).getText(); // 이벤트 발생했을 때 겟소스로 가져오는데 텍스트로 가져오겠다. 버튼으로 치환도 해주겠다.
		lbresult.setText(lbresult.getText() + num);
	}
	@FXML
	public void operator(ActionEvent event) { // 계산 오퍼레이터를 눌렀을 때
		String value = ((Button)event.getSource()).getText();
		
		if(!value.equals("=")) {
			if(value.equals("C")) {
				lbresult.setText("");
				return;
			}
			
			operator = value;
			number1 = Double.parseDouble(lbresult.getText());
			lbresult.setText("");
		}
		else { // "=" 오퍼레이터 계산
			number2 = Double.parseDouble(lbresult.getText());
			double result = model1.calculate(number1, number2, operator);
			
			lbresult.setText(String.valueOf(result));
			operator = "";
		}
	} 
	// XML에서 source -> 제너래이터 컨트롤러하면 컨트롤러가 자동으로 만들어진다.
}
