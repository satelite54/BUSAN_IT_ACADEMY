package lifeCoding;

public class CSubstractionableCalculator extends CCalculator {

	public void substract() {
		System.out.println(this.left - this.right);// CCalculator�� �ִ� left�� right�� ������ ���.
	}
	
	// �żҵ� �������̵� // �θ�Ŭ������ �żҵ� ����� ������(������ �̸��� ���� �żҵ��� ������ ���� ������ ������)
	public void sum() {
		System.out.println("���� ����� " + (this.left + this.right) + "�Դϴ�.");
	}
	// �żҵ� �������̵�
	public int avg() {
		// �θ�Ŭ������ �żҵ��� ����� �״�� �����´�.
		return super.avg(); //super Ű���� �θ�Ŭ������ �ּҿ� �ִ� avg �żҵ� ȣ��
	}
	
	// �������̵� ��������
	// �żҵ� ������ ���ƾ��� �̸�, �Ű�����, ����Ÿ�� ���ƾ���
	
	// �������̵��̶� �θ�Ŭ������ ����� �ڽ� Ŭ�������� Ȯ���ϴ� ��.
}
