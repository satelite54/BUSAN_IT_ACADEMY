package chapter13;

import com.sun.org.apache.xpath.internal.axes.WalkingIterator;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human tom = new Human();
		walking(tom);
		Robot sam = new Robot();
		walking(sam);
		
		walking(() -> {
			
			System.out.println("코드가 두 줄 이상일 때 사용");
			System.out.println("이름 없는 클래스 객체가 걷느다.");
		});
		
		walking(() -> {
			System.out.println("이름없는 객체가 걷는다.");
		});
		
		walking(new Walkable() {
			
			@Override
			public void walk() {
				// TODO Auto-generated method stub
				System.out.println("이름없는 클래스 객체가 걷는다.");
			}
		}); // 자바7버전 까지의 람다식
		
		walking(() -> System.out.println("이름없는 클래스 객체가 걷는다."));
	}	//  자바8버전 까지의 람다식
	public static void walking(Walkable any) {
		any.walk();
	}
	// Human 클래스와 Robot클래스 둘다 사용가능 둘 다 인터페이스를 구현해 주었기 때문에
	
	 // Walkable은 인터페이스라서 실제 객체를 만들 수 없다.
	
	
	// 람다식이란
	// 함수인데 함수를 따로 만들지 않고 코드한줄에 함수를 써서 그것을 호출하는 방식이라고 생각하시면 되겠습니다.
	//자바에서의 람다식은 함수형 인터페이스의 메소드를 간편하게 구현하여 사용하는데에 그 목적이 있습니다. 
	//람다식은 메소드의 매개변수와 반환값이 될 수 있어 메소드를 변수처럼 다룰 수 있게 한다.
	// 람다식은 간단히 말해 함수를 변수처럼 사용할수 있는 개념이다. 
}

//장점
//효율적인 람다 함수의 사용으로 불필요한 루프문의 삭제가 가능하며, 함수의 재활용이 용이.
//
//필요한 정보만을 사용하는 방식을 통한 성능 향상됨.
//일반적으로 다중 cpu를 활용하는 형태로 구현되어 병렬 처리에 유리함.
//코드가 간결해져 개발자의 의도가 명확히 드러나므로 가독성이 향상


//단점
//람다를 사용하여 만든 무명함수는 재사용이 불가능함.
//지나치게 남발하면 코드가 이해하기 어렵고 지저분해짐.

//() 는 파라미터에 해당하는데, 2.1의 run() 이라는 익명클래스의 메소드가 아무런 파라미터를 취하지 않는다는 의미이다.
// -> 는 람다식 시작전에 나타나는 람다식 시작토큰이다. 뒤에는 한줄짜리 람다식혹은 { }안에 포함된 여러 람다식들이 올수 있다.
//System.out.println("Lambda Thread") 는 람다식의 내용부분으로 이 안에는 A의 파라미터값이 사용될수 있다.

//(중요)람다식을 사용하는 이유는 1회용 익명 메소드가 필요하기 때문 > 
//하지만 자바는 독립적인 메소드만을 생성하지 못하기 때문에 익명객체를 이용해서 만든다.

// 사용법 예시

//MyType my3 = () -> { 이런식으로 익명객체를 생성 후 그 안에 오버라이딩 메소드 내용을 기재
//
//	System.out.println("안녕하세요 아무개입니다.");
//
//}; // 단일라인 메소드

//ex) 
//(int num) -> {System.out.println()};  가장 기본형태

// YourType 이라는 인터페이스에 선언된 단일 메소드를 구현015

//YourType you = (String name) -> { System.out.printf("내이름은 %s입니다.",name); }
//
//you.talk("홍길동");