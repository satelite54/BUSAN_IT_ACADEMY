package lifeCoding;

public class ClassBaseMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CCalculator c1 = new CCalculator(10, 20); // 생성자에 값을 넣어준다. // 인스턴스를 생성하는자.
		CCalculator c1 = new CCalculator();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		
//		CCalculator c2 = new CCalculator(10, 20);
		CCalculator c2 = new CCalculator();
		c1.setOprands(30, 40);
		c1.sum();
		c1.avg();
		
		double PIc1 = c1.PI; //static 키워드를 붙인 맴버변수를 참고하는 방법
		double PIc2 = c2.PI; //다 같은 값을 참고한다.
		double PIclass = CCalculator.PI;// 인스턴스를 생성하지 않고 직접 참고가능
		System.out.println(PIc1+ ":" + PIc2 + ":" + PIclass);
		
		CCalculator.sticavg(40, 70); // 왜 클래스에 static을 사용하냐???
		// 간단하게 클래스내에 메소드만 이용하고 싶을 경우
		// 인스턴스화할 경우는 각각의 객체가 다른 상태를 가져서 동일한 값을 입력해도 다르게 출력해야만할 때 해야함
		// new해서 클래스를 인스턴스화하는 것보다. 성능도 더 좋다. 메모리 IO가 줄어드니까
		
		C1 c = new C1();
		c.static_static();
//		c.static_instance(); 안됌 왜냐 instance는 힙 메모리에 상주안하니까.
		C1.static_static();
		c.instance_static(); // 이건 된다 왜? 인스턴가 생성되서 힙 메모리에 올라가니까.
		c.instance_instance();
		
		// 인스턴스 변수-> Non-Static Field
		// 클래스 변수-> Static Field
		
		CSubstractionableCalculator cs1 = new CSubstractionableCalculator();
		cs1.setOprands(10, 20);
		cs1.sum();
		cs1.avg();
		
		MultiplicationableCalsulator cs2 = new MultiplicationableCalsulator();
		cs2.setOprands(30, 40);
		cs2.sum();
		cs2.avg();
		cs2.multiplication();
		
		CDivisionableCalculator cs3 = new CDivisionableCalculator();
		cs3.setOprands(80, 80);
		cs3.sum();
		cs3.avg();
		cs3.multiplication();
		cs3.division();
		
		// 만약에 부모 클래스가 생성자 매개변수를 가지고 있는 경우는 오류를 뿜는다.
		// 하위클래스에서 부모 클래스의 생성자를 만들어주고 싶으면 자식클래스 생성자 쪽에서
		// super(매개변수1, 매개변수2.. 이런식으로 가면된다.)
		
	}
}
