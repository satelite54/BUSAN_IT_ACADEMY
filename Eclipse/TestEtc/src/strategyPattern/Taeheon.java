package strategyPattern;

public class Taeheon {
	private Wearing wearing;
	
	public void setcloth(Wearing wearing) {
		this.wearing = wearing;
	}
	
	public void showFashion() {
		if(wearing == null) {
			System.out.println("�����̴� ���� �԰� ���� �ʽ��ϴ�.");
		} else {
			wearing.showFashion();
		}
	}
}
