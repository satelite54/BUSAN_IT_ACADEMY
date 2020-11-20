package ValueReferece;

class A {
	public int id;
	A(int id) {
		this.id = id;
	}
}

public class ValueReference {
	
	int[] ab = {1, 2, 3, 4, 5};
	
	public static void _value(int b) { // Call by Value
		b = 2; // 변수를 복사해서 2를 집어넣는다.
		// b에 저장된 2는 함수 소멸 시 소멸된다.
	}
	
	public static void runValue() { // Value
		int a = 1;
//		int b = a;
//		b = 2;
		_value(a); //
		System.out.println("runValue, " + a);
	}
	public static void _Reference (A b) {// Call by Reference
		b.id = 2; // b가 가르키고 있는 곳에 2를 넣는다.
	}
	public static void runReference() { // Reference
		A a= new A(1);
		_Reference(a);
//		A b= a;
//		b.id = 2;
		System.out.println("runReference, " + a.id);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runValue();
		runReference();
	}
	
}