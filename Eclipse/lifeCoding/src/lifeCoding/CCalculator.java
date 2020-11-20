package lifeCoding;

public class CCalculator {

	static double PI = 3.14; // static 키워드를 선언하게 되면 모든 인스턴스 객체에서 동일한 맴버변수를 참조
	
	int left, right, third;
	
//	public CCalculator(int left, int right) { // 생성자
//		this.left = left;
//		this.right = right;
//	}
	
	public void setOprands(int left, int right) {
		this.left = left; // this는 생성된 인스턴스를 가르킨다. 인스턴스 자신을 의미함.
		this.right = right;
	}
	
	public void setOprands(int left, int right, int third) {// 오버로딩 매소드 이름은 같지만 매개변수가 다르다.
		this.setOprands(left, right); // 이런식으로 중복된 로직을 제거할 수 있다. 유지보수성 업!
		this.third = third;
	}
	
	public void sum() {
		System.out.println(this.left+this.right);
	}

	public int avg() {
		System.out.println((this.left+this.right)/2);
		return left;
	}
	
	public static void sticsum(int left, int right) {
		System.out.println(left+right);
	}

	public static void sticavg(int left, int right) {
		System.out.println((left+right)/2);
	}
}
