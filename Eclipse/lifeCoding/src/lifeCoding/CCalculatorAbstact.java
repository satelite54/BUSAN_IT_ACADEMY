package lifeCoding;

public class CCalculatorAbstact extends CCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void sum() { // CCalculator가 추상클래스 이므로 오버라이딩을 강제함.
		System.out.println("+ sum :" + (this.left + this.right));
	}
	public void avg() {
		System.out.println("+ avg :" + (this.left + this.right)/2);
	}
}
