package Interface;

public class CCalculatorDummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorDummy c = new CalculatorDummy();
		c.setOprands(10, 20, 30);
		System.out.println(c.sum() + c.avg());
	}
}

class CalculatorDummy { // 모조 클래스
	public void setOprands(int first, int second, int third) {
		
	}
	public int sum() {
		return 60;
	}
	public int avg() {
		return 20;
	}
}
