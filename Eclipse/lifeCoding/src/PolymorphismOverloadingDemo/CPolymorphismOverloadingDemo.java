package PolymorphismOverloadingDemo;

class O{ // �������̵�, �����ε� ��ǥ���� ������
	public void a(int param) {
		System.out.println("�������");
		System.out.println(param);
	}
	public void a(String param) {
		System.out.println("�������");
		System.out.println("param");		
	}
}
public class CPolymorphismOverloadingDemo {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		O o = new O();
		o.a(1);
		o.a("one");
	}
}
