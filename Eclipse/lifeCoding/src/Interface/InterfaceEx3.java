package Interface;

public class InterfaceEx3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface I1 {
	public void x();
}
interface I2 { 
	public void z();
}

class B implements I1, I2 { // �ϳ��� Ŭ������ �������� �������̽��� ������ �� �ִ�.
	public void x() {
		
	}
	public void z() {
		
	}
}

interface I3 {
	void x();
}
interface I4 extends I3, I1 {// �������̽��� ����� �����ϴ�. Ŭ������ ���̰� �ִ�. ���� Ŭ������ �ϳ��� �θ�Ŭ�������� ����Ҽ� �ִ�.
	// �������̽��� ���� ����� �����ϴ�.
}

//abstract�� interface�� ��������� �ٸ���.
//abstract class�� ���� Ŭ������ �̱����� �޼ҵ带 �����ϱ⸦ ����ϸ鼭 �ڱ⵵ ������ �޼ҵ带 �������ִ�.
//interface�� ������ Ŭ������ �޼ҵ带 �����ؾ���.