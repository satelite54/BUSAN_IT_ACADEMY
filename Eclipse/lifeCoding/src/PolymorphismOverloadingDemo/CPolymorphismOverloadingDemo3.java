package PolymorphismOverloadingDemo;

interface I2 {
	public String A();
}
interface I3 {
	public String B();
}

class D implements I2, I3 {
	public String A() {
		return "A";
	}
	public String B() {
		return "B";
	}
	
}

public class CPolymorphismOverloadingDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D obj = new D();
		I2 objI2 = new D();
		I3 objI3 = new D();
		// �������̽��� �ɹ����� ������ �ִ� Ŭ���� ó�� ��밡��
		// D���� �������̽��� ������ �־��� ����
		// �̷������� �����ϸ� Ŭ�������� �ɹ��� ���ԵǾ� �ְ� ���ÿ�
		// �������̽� ���� �ִ� �ɹ��鸸
		// ��밡�� �ٸ� Ŭ���� �ɹ����� ���� �� ó�� �� �� �ִ�.
		obj.A();
		obj.B();
		
		objI2.A();
//		objI2.B();//���ȵ�
//		
//		objI3.A();//���ȵ�
		objI3.B();
	}
	
	//�̷��� �����ϸ� ����ϱ� ���ϴ�.
	// �����̿��� ����Ʈ���� �ָ鼭 �̰� ���ӱ�� �̷��� ���ϸ�
	// �����̴� �װ� ���ӱ��� �� �˰� ���Ӹ� �Ѵ�.
	// ����Ʈ���̶�� Ŭ�������� ��ȭ, �����̶�� �������̽��� �ִµ� 
	// �����̴� ���Ӹ� �̿��� ��
	
	
	//
}
