package Section1;

public class code01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0; // 프리미티브 타입은 변수에 값을 직접 저장
		
		// 클래스 타입은 변수에 값을 직접 저장하는게 아니라 생성된 객체
		// 주소를 저장하는거다.
		
		// 프리미티브 타입이 아닌 모든 변수는
		// 참조변수이다.
		Person1 person1 = new Person1();
		person1.name = "김태헌";
		person1.number = "01034845022";
		
		System.out.println(person1.name + person1.number);
	}
}
