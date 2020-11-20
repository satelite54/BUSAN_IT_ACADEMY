package lifeCoding;

public class CCalculator {

	static double PI = 3.14; // static Ű���带 �����ϰ� �Ǹ� ��� �ν��Ͻ� ��ü���� ������ �ɹ������� ����
	
	int left, right, third;
	
//	public CCalculator(int left, int right) { // ������
//		this.left = left;
//		this.right = right;
//	}
	
	public void setOprands(int left, int right) {
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

	public int avg() {
		System.out.println((this.left+this.right)/2);
		return left;
	}
	
	public static void sticsum(int left, int right) {
		System.out.println(left+right);
	}

	public static void sticavg(int left, int right) {
		System.out.println((left+right)/2);
	}
}
