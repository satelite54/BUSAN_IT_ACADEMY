package application;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class demoController {
	@FXML
	private Label lbresult;
	// Scene���� ��ư�� on Action�� �Լ��� �Է��ϰ� ��Ʈ�� �����ϸ� ��ư Ŭ�� �� �޼ҵ� ����
	// Event Listener on Button.onAction
	
	private double number1 = 0.0;
	private double number2 = 0.0;
	private String operator = "";
	model model1 = new model();
	
	@FXML
	public void numbers(ActionEvent event) { // ���ڸ� ������ �� // ���� �̺�Ʈ�� �߻����� ��
		String num = ((Button)event.getSource()).getText(); // �̺�Ʈ �߻����� �� �ټҽ��� �������µ� �ؽ�Ʈ�� �������ڴ�. ��ư���� ġȯ�� ���ְڴ�.
		lbresult.setText(lbresult.getText() + num);
	}
	@FXML
	public void operator(ActionEvent event) { // ��� ���۷����͸� ������ ��
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
		else { // "=" ���۷����� ���
			number2 = Double.parseDouble(lbresult.getText());
			double result = model1.calculate(number1, number2, operator);
			
			lbresult.setText(String.valueOf(result));
			operator = "";
		}
	} 
	// XML���� source -> ���ʷ����� ��Ʈ�ѷ��ϸ� ��Ʈ�ѷ��� �ڵ����� ���������.
}
