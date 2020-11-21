package Enum;

//class Fruit{
////	int APPLE = 1, PEACH = 2, BANANA = 3;
//	public static final Fruit APPLE = new Fruit();// 자기자신을 인스턴스화 시킨 것을 애플에 집어 넣음
//	public static final Fruit PEACH = new Fruit();
//	public static final Fruit BANANA = new Fruit();
// 각각의 맴버는 배열처럼 열거할 수 없다.
//}
// enum과 같다.
enum Fruit {// 하나의 클래스임 열거형 상수
	APPLE("red"), PEACH("pink"), BANANA("yellow");//APPLE에 red 값을 생성자 매개변수에 넣어줌 // enum은 이렇게 생성자에 배개변수 전달가능
//	public static final Fruit APPLE = new Fruit();// 자기자신을 인스턴스화 시킨 것을 애플에 집어 넣음
//	public static final Fruit PEACH = new Fruit();
//	public static final Fruit BANANA = new Fruit();
	// 와 같다. 상수들이 생성 될 때 마다 인스턴스화 됨
	// 인스턴스를 생성하기위한 생성자를 3번 호출함
	Fruit(String color) {
		System.out.println("Call Constructor " + this); //여기서 this는 인스턴스를 가리킴
		this.color = color;
	}	
	private String color;
	public String getColor() {
		return this.color;
	}
	// enum은 필드와 매소드가 다 들어갈 수 있는 온전한 클래스다.
}
enum Company {// 하나의 클래스임 열거형 상수
	GOOGLE, APPLE, ORECALE
}


//class Company {
//	public static final Company GOOGLE = new Company();// 자기자신을 인스턴스화 시킨 것을 애플에 집어 넣음
//	public static final Company APPLE = new Company();
//	public static final Company ORACLE = new Company();
//}

public class ConstantDemo {
	
//	private final static int FRUIT_APPLE = 1;
//	private final static int FRUIT_PEACH = 2;
//	private final static int FRUIT_BANANA = 3;

//	private final static int COMPANY_GOOGLE = 1;
//	private final static int COMPANY_APPLE = 2;
//	private final static int COMPANY_ORECALE = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		for(Fruit f : Fruit.values()) { // enum에서 values 매소드를 사용하면 enum안의 데이터를 뽑아준다.
			// 열거형은 이런식으로 항샹된 for문을 사용할 수 있다.
			System.out.println(f);
		}
		
// 주석이 필요없는 상수 가독성이 좋다.
//		Fruit type = Fruit.APPLE;
//		switch(type) { //
//		case APPLE: 
//			System.out.println(57 + "kcal, color : " + Fruit.APPLE.getColor());
//			break;
//		case PEACH:
//			System.out.println(34+ "kcal, color : " + Fruit.PEACH.getColor());
//			break;
//		case BANANA:
//			System.out.println(93 + "kcal, color : " + Fruit.BANANA.getColor());
//			break;
//		default: System.out.println("no input");
//		}
	}
	
	//enum을 사용하면 코드가 간결해진다.
}
