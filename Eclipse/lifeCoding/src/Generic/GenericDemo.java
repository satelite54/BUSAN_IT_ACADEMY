package Generic;

class StudentInfo {
	public int grade;
	StudentInfo(int grade){this.grade = grade;}
}

//class StudentPerson {
//	public StudentInfo info;// �Ȱ��� �ڵ��� �ߺ�
//	StudentPerson(StudentInfo info){this.info = info;}
//}

class EmployeeInfo{
	public int rank;
	EmployeeInfo(int rank) {this.rank = rank;}
}

class Person1 {
	public Object info; // ��� Ŭ������ �� �� �ִ�.
	Person1(Object info) {this.info = info;}
}

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		StudentInfo si = new StudentInfo(2);
//		StudentPerson sp = new StudentPerson(si);
//		System.out.println(sp.info.grade); // 2
//		EmployeeInfo ei = new EmployeeInfo(1);
//		EmployeePerson ep = new EmployeePerson(ei); // 1
//		System.out.println(ep.info.rank);
//		Person1 p1 = new Person1("����");
//		EmployeeInfo ei = (EmployeeInfo)p1.info; // �����ϴܰ迡���� ���� ���� �ȵ�
		// Ÿ���� �������� ����
		Integer id = new Integer(1); // ������ ���۷��� ������ Ÿ������ ����
//		Person2<EmployeeInfo, Integer> p1 = new Person2<EmployeeInfo, Integer>(new EmployeeInfo(1), id);
		//���׸��� ���������ϴ�.
		Person2 p1 = new Person2(new EmployeeInfo(1), id);
//		System.out.println(p1.id.intValue()); // inValue = ����Ŭ������ ��� �ִ� ������ ���ڸ� �⺻ ������Ÿ�� 1�� �����ִ� �żҵ�
		
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(1);
		Person2 p2 = new Person2(e, i);
		p2.printInfo(e);
		
	}
	// ���׸��� Ÿ���� �����ϴٴ� ������ �ڵ��� �ߺ��� �������� ���� ���ԵȰ��� ���׸�
	
}

class Person2<T, S> { //���׸��� ���� ������ Ÿ�Ը� �� �� �ִ�.
	public T info;
	public S id;
	public Person2(T info, S id) { this.info = info; this.id = id;
		// TODO Auto-generated constructor stub
	}
	
	public <U> void printInfo (U info) {
		System.out.println(info);
	}
}