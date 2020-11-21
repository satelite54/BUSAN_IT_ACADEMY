package Generic;

public class CGeneric {
// 클래스 내부에서 사용할 데이터 타입을 나중에 인스턴스를 생성할 때 확정하는 것을 의미
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person<String> p1 = new Person<String>();
		Person<StringBuilder> p2 = new Person<StringBuilder>();
	}

}

class Person <T> { // 나중에 class를 사용할 때 데이터 타입을 지정
  public T info; // 제네릭 T
}