package java_temp;

public class cStudent {
	String name;
	String number;
	int birthYear;
	
	public static void main(String[] args) {
		cStudent s1 = new cStudent();
		s1.name = "홍길동";
		s1.number = "1234";
		s1.birthYear = 1995;
		
		cStudent s2 = new cStudent();
		s2.name = "홍길동";
		s2.number ="1234";
		s2.birthYear=1995;
		
		if(s1.equals(s2)) {
			System.out.println("s1 == s2");
		} else {
			System.out.println("s1 != s2");
		};
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s1); // 내부적으로 객체가 호출 될때 toString 메소드가 호출됨을 알 수 있음
		System.out.println(s1.toString());
	}

	@Override
	public String toString() { // 
		return "cStudent [name=" + name + ", number=" + number + ", birthYear=" + birthYear + "]";
	} //

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // obj와 자기 자신을 비교
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())// class의 정보를 가져옴// 자기 자신의 클래스와 obj의 클래스를 비교
			return false;
		cStudent other = (cStudent) obj; //obj를 cStudent로 형변환
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
}
