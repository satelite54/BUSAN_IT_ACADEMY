package java_temp;

import java.lang.reflect.Method; // �޼ҵ��� ������ �� �� �ִ� Ŭ����

public class MyHellowExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myhello hello = new Myhello();
		
		try {
			Method method = hello.getClass().getDeclaredMethod("hello");
			// getClass�� ������Ʈ Ŭ������ ������ ����.
			// �ش��ν��Ͻ��� ���鶧 ����� Ŭ������ ����
			// getDeclaredMethod
			
			if(method.isAnnotationPresent(Count100.class)) {
			// Ư�� ������̼��� �޼ҵ忡 ����Ǿ� �ִ��� �˾� �� �� �ִ�.
			// ���� �Ǿ� ������ true
				for(int i = 0; i < 100; i++) {
					hello.hello();
					// ������̼��� ���� �Ǿ� ������ 100�� ���
				}
			} else {
				// �ƴϸ� 1����
				hello.hello();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
