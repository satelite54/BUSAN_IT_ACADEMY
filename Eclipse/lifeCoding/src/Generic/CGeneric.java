package Generic;

public class CGeneric {
// Ŭ���� ���ο��� ����� ������ Ÿ���� ���߿� �ν��Ͻ��� ������ �� Ȯ���ϴ� ���� �ǹ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person<String> p1 = new Person<String>();
		Person<StringBuilder> p2 = new Person<StringBuilder>();
	}

}

class Person <T> { // ���߿� class�� ����� �� ������ Ÿ���� ����
  public T info; // ���׸� T
}