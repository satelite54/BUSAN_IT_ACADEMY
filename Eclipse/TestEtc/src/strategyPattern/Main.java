package strategyPattern;

public class Main { //��������

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Taeheon taeheon = new Taeheon(); //������ ������ Ŭ����
		
		taeheon.showFashion();
		
		taeheon.setcloth(new swimSuit()); //�� Ŭ�������� Wearing �������̽� ���� Ŭ������
		taeheon.showFashion();
		
		taeheon.setcloth(new tunderWear());
		taeheon.showFashion();
		
		taeheon.setcloth(new burberryCoat());
		taeheon.showFashion();
	}

}
