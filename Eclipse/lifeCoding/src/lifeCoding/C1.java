package lifeCoding;

public class C1 {

	static int static_variable = 1;
	int instance_variable = 2;
	static void static_static() {
		// Ŭ���� �޼ҵ忡���� �ν��Ͻ� ������ ���� X
//		System.out.println(instance_variable);
		System.out.println(static_variable);
	}
	void instance_static() {
		// �ν��Ͻ� �޼ҵ忡���� Ŭ���� ������ ���� �� �� �ִ�.
		System.out.println(static_variable);
	}
	void instance_instance() {
		System.out.println(instance_variable);
	}
}
