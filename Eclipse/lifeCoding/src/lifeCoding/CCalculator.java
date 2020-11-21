package lifeCoding;


//abstract 
public class CCalculator {

	static final double PI = 3.14; // static 키워드를 선언하게 되면 모든 인스턴스 객체에서 동일한 맴버변수를 참조
	int left, right, third;
	
//	public CCalculator(int left, int right) { // 생성자
//		this.left = left;
//		this.right = right;
//	}
	
	public void setOprands(int left, int right) {
		if(right == 0) { // 사용자 예외처리
			throw new IllegalArgumentException("두 번째 인자는" + right + "을 허용하지 않습니다.");
		}
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

	public void avg() {
		System.out.println((this.left+this.right)/2);
	}
	
	public String toString() {
		return super.toString() + "left:" + this.left + ", right:" + this.right;
	}
	
	public void divide() {
		try {
		System.out.println("계산결과는");
		System.out.println(this.left/this.right);
		System.out.println("입니다.");
		} catch (ArithmeticException e) {
			System.out.println("오류가 났습니당!" + e.getMessage() //by zero 간단한 정보
			+"\n" + e.toString()); //java.lang.ArithmeticException: / by zero 상세정보
			e.printStackTrace(); //오류뜬 위치 출력
		} finally {
			System.out.println("무슨일이 있어도 실행됨");
		}

	}
	public void run() {
		sum();
		avg();
	}
	
	public static void sticsum(int left, int right) {
		System.out.println(left+right);
	}

	public static void sticavg(int left, int right) {
		System.out.println((left+right)/2);
	}
}

class A {
	final void b() {
		Object ob = new Object();
	}
}
//class B extends A {
//	void b() { // A에서 b는 final 메소드이기 때문에 오버라이딩을 하지 못한다.
//		
//	}
//}

final class C {
	
}

//class D extends C { //final 클래스는 상속안된다.
//	
//}

// F1키는 자바 기본 클래스나 메소드에 대해 볼 수 있는 Help 창이 뜬다.