package Generic;

class StudentInfo {
	public int grade;
	StudentInfo(int grade){this.grade = grade;}
}

//class StudentPerson {
//	public StudentInfo info;// 똑같은 코드의 중복
//	StudentPerson(StudentInfo info){this.info = info;}
//}

class EmployeeInfo{
	public int rank;
	EmployeeInfo(int rank) {this.rank = rank;}
}

class Person1 {
	public Object info; // 어떠한 클래스라도 올 수 있다.
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
//		Person1 p1 = new Person1("부장");
//		EmployeeInfo ei = (EmployeeInfo)p1.info; // 컴파일단계에서는 오류 검출 안됨
		// 타입이 안전하지 않음
		Integer id = new Integer(1); // 정수를 래퍼런스 데이터 타입으로 만듬
//		Person2<EmployeeInfo, Integer> p1 = new Person2<EmployeeInfo, Integer>(new EmployeeInfo(1), id);
		//제네릭은 생략가능하다.
		Person2 p1 = new Person2(new EmployeeInfo(1), id);
//		System.out.println(p1.id.intValue()); // inValue = 래퍼클래스가 담고 있는 원래의 숫자를 기본 데이터타입 1로 돌려주는 매소드
		
		EmployeeInfo e = new EmployeeInfo(1);
		Integer i = new Integer(1);
		Person2 p2 = new Person2(e, i);
		p2.printInfo(e);
		
	}
	// 제네릭은 타입이 안전하다는 장점과 코드의 중복을 방지하지 위해 도입된것이 제네릭
	
}

class Person2<T, S> { //제네릭은 참조 데이터 타입만 올 수 있다.
	public T info;
	public S id;
	public Person2(T info, S id) { this.info = info; this.id = id;
		// TODO Auto-generated constructor stub
	}
	
	public <U> void printInfo (U info) {
		System.out.println(info);
	}
}