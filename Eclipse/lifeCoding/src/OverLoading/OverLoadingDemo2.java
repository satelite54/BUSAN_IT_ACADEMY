package OverLoading;

public class OverLoadingDemo2 extends OverLoadingDemo {

	void A (String arg1, String arg2) { // 
		System.out.println("sub class : void A (String arg1, String arg2)");
	}
	void A () {// ���ڰ� ���� �żҵ� �θ�Ŭ������ �����ϱ� ������ �����ε��ȴ�
		System.out.println("sub class : void A ()"); // �Ű����� X
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
//�����ε��̶�� ���� ���� �̸� �ٸ� �żҵ�
// �������̵��̶�� ���� �θ�Ŭ������ ������ �Է°��� �̸��� ���� �żҵ带 �ڽ�Ŭ�������� ������ �ϴ°�
	// �������̵� �ö�ź��
	// �����ε� �����̸� ������ �ٸ� �Ű������� ���� �żҵ带 ���� Ŭ������ �ε��Ѵ�.
}
