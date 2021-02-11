package strategyPattern;

public class Main { //전략패턴

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Taeheon taeheon = new Taeheon(); //태헌은 접근점 클래스
		
		taeheon.showFashion();
		
		taeheon.setcloth(new swimSuit()); //옷 클래스들은 Wearing 인터페이스 구현 클래스들
		taeheon.showFashion();
		
		taeheon.setcloth(new tunderWear());
		taeheon.showFashion();
		
		taeheon.setcloth(new burberryCoat());
		taeheon.showFashion();
	}

}
