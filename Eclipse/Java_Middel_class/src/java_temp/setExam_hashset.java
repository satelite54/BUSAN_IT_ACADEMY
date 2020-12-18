package java_temp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam_hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<>(); // Set은 인터페이스이기 떄문에 객체생성 불가 Set의 구현 클래스인 HashSet을 이용 
		boolean flag1 = set1.add("Kang"); //저장 할때 마다 boolean 값을 리턴 같은 값이 존재하면 false 반환
		boolean flag2 = set1.add("kim");
		boolean flag3 = set1.add("Kang");
		
		System.out.println(set1.size());
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);
		
		Iterator<String> iter = set1.iterator(); //iterator() 이터레이터 인터페이스가 구현한 객체가 리턴됨.
		while (iter.hasNext()) {
			String string = iter.next(); //값을 하나씩 꺼네서 사용한다.
			System.out.println(string);
		}
	}
}
