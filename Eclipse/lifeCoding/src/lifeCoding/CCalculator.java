package lifeCoding;


//abstract 
public class CCalculator {

	static final double PI = 3.14; // static Ű���带 �����ϰ� �Ǹ� ��� �ν��Ͻ� ��ü���� ������ �ɹ������� ����
	int left, right, third;
	
//	public CCalculator(int left, int right) { // ������
//		this.left = left;
//		this.right = right;
//	}
	
	public void setOprands(int left, int right) {
		if(right == 0) { // ����� ����ó��
			throw new IllegalArgumentException("�� ��° ���ڴ�" + right + "�� ������� �ʽ��ϴ�.");
		}
		this.left = left; // this�� ������ �ν��Ͻ��� ����Ų��. �ν��Ͻ� �ڽ��� �ǹ���.
		this.right = right;
	}
	
	public void setOprands(int left, int right, int third) {// �����ε� �żҵ� �̸��� ������ �Ű������� �ٸ���.
		this.setOprands(left, right); // �̷������� �ߺ��� ������ ������ �� �ִ�. ���������� ��!
		this.third = third;
	}
	

	public void sum() {
		System.out.println(this.left+this.right);
	}

	public void avg() {
		System.out.println((this.left+this.right)/2);
	}
	
	public String toString() {
		return super.toString() + "left:" + this.left + ", right:" + this.right;
	}
	
	public void divide() {
		try {
		System.out.println("�������");
		System.out.println(this.left/this.right);
		System.out.println("�Դϴ�.");
		} catch (ArithmeticException e) {
			System.out.println("������ �����ϴ�!" + e.getMessage() //by zero ������ ����
			+"\n" + e.toString()); //java.lang.ArithmeticException: / by zero ������
			e.printStackTrace(); //������ ��ġ ���
		} finally {
			System.out.println("�������� �־ �����");
		}

	}
	public void run() {
		sum();
		avg();
	}
	
	public static void sticsum(int left, int right) {
		System.out.println(left+right);
	}

	public static void sticavg(int left, int right) {
		System.out.println((left+right)/2);
	}
}

class A {
	final void b() {
		Object ob = new Object();
	}
}
//class B extends A {
//	void b() { // A���� b�� final �޼ҵ��̱� ������ �������̵��� ���� ���Ѵ�.
//		
//	}
//}

final class C {
	
}

//class D extends C { //final Ŭ������ ��Ӿȵȴ�.
//	
//}

// F1Ű�� �ڹ� �⺻ Ŭ������ �޼ҵ忡 ���� �� �� �ִ� Help â�� ���.