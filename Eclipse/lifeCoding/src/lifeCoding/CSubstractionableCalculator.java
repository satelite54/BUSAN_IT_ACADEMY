package lifeCoding;

public class CSubstractionableCalculator extends CCalculator {

	public void substract() {
		System.out.println(this.left - this.right);// CCalculator에 있는 left와 right를 가져다 썼다.
	}
	
	// 매소드 오버라이딩 // 부모클래스의 매소드 기능을 재정의(동일한 이름을 가진 매소드의 스코프 내의 내용을 재정의)
	public void sum() {
		System.out.println("실행 결과는 " + (this.left + this.right) + "입니다.");
	}
	// 매소드 오버라이딩
	public int avg() {
		// 부모클래스의 매소드의 기능을 그대로 가져온다.
		return super.avg(); //super 키워드 부모클래스의 주소에 있는 avg 매소드 호출
	}
	
	// 오버라이딩 제약조건
	// 매소드 구조가 같아야함 이름, 매개변수, 리턴타입 같아야함
	
	// 오버라이딩이란 부모클래스의 기능을 자식 클래스에서 확장하는 것.
}
