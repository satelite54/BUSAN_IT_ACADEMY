package OverLoading;

public class OverLoadingDemo { // �����ε�

	void A () {System.out.println("Void A()");}
	void A (int arg1) {System.out.println("void A (int arg1)");}
//	void A (int param1) {System.out.println("void A (int arg1)");} // �Ű����� �̸��� �ٲ㵵 �ȵȴ�. �ڹٿ����� � �żҵ带 ������� ���� ���Ѵ�. �Ű������̸��� �ۿ��� ���ڸ� �ٶ� �𸥴�.
	void A (String arg1) {System.out.println("void A (String arg1)");}
//	int A () {System.out.println("void A()");} �̰Ŵ� �ȵ�
	// �����ε� ��������
	// �żҵ� �̸��� ���� �Ű������� �޶���Ѵ�. ���ϰ��� ���ƾ��Ѵ�.
	
	public static void main(String[] args) {
		OverLoadingDemo od = new OverLoadingDemo();
		od.A();
		od.A(1);
		od.A("coiding everybody");
	}
	
}
