package PolymorphismOverloadingDemo;
// Ŭ������ ������
class A{
	public String x() {
		return "A.x";
	}
}
class B extends A{
	public String x() {
		return "B.x";
	}
	public String y() {
		return "y";
	}
}
class B2 extends A{
	public String x() {
		return "B2.x";
	}
}

public class CPolymorphismOverloadingDemoclass { // Ŭ������ ������

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new B(); // B��� ��ü�� �ν��Ͻ�ȭ ��Ű�� obj��� ������ ��Ҵµ� obj�� A��� ������ Ÿ���� ������.
		System.out.println(obj.x());
		A obj2 = new B2(); // �θ��� �༼�� �ϱ� ������ �ڽ�Ŭ������ ��� �޼ҵ�� ȣ���� �Ұ����ϴ�.
		System.out.println(obj.x()); // �ڽ�Ŭ�������� �������̵��� B.x�� ���
		System.out.println(obj2.x());// �θ�Ŭ������ �ִ� B2.x�� ���
	}
	// 1. ��� Ŭ������ �ν��Ͻ�ȭ ��ų�� �θ�Ŭ������ ����� �� �� �ִ�.
	// 2. 
}
