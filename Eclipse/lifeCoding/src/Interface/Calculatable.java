package Interface;

public interface Calculatable { // 개발자 간의 약속같은거임 //클래스는 이런 변수와 기능으로 
	//개발할꺼야~
	public void setOprands(int first, int second, int third);
	public int sum(); // 인터페이스의 접근제어자는 무조건 public이다.
	int avb();
	int b = 0;
	//인터페이스를 implements 시키면 구현을 무조건 강제한다.
}
