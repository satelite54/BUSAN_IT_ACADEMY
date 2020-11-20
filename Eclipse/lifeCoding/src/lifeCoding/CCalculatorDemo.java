package lifeCoding;

public class CCalculatorDemo extends CCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CCalculator c1 = new CCalculator();
		c1.setOprands(10, 1);
		c1.divide();
		System.out.println(c1.toString());
	}
}
