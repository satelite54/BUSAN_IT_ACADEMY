package PolymorphismOverloadingDemo;

interface I {
	
}

class C implements I {
	
}

public class PolaymorphismDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I obj = new C(); // C Ŭ������ �ν��Ͻ�ȭ�ؼ� I �������̽��� ��Ҵ�.
		// �̷��� �� �� �ִ� ������ C�� I�� �����ϱ� �����̴�.
	}
}
