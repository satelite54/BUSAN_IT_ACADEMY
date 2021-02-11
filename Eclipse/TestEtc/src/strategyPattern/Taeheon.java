package strategyPattern;

public class Taeheon {
	private Wearing wearing;
	
	public void setcloth(Wearing wearing) {
		this.wearing = wearing;
	}
	
	public void showFashion() {
		if(wearing == null) {
			System.out.println("태헌이는 옷을 입고 있지 않습니다.");
		} else {
			wearing.showFashion();
		}
	}
}
