package CollectionsFramework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CSetAndListAndIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Integer> AHash = new HashSet<Integer>(); //A : HashSetContainer
		ArrayList<Integer> AAryList = new ArrayList<Integer>();
		AHash.add(1);
		AHash.add(2);
		AHash.add(3);
		AHash.add(3);
		AHash.add(3);
		AHash.add(3);
		AHash.add(3);
//		A = {1, 2, 3} //Set은 집합의 특성을 가지고 있다. 각각의 값이 중복되어서는 안된다!
		System.out.println("----------------------------");
		
		AAryList.add(1);
		AAryList.add(2);
		AAryList.add(3);
		AAryList.add(3);
		AAryList.add(3);
		AAryList.add(3);
		AAryList.add(3);
//		hashSet = 1, 2, 3
//		기존에 들어있는 값이 있을 경우 무시
//		ArrayList = 1 , 2 , 3, 3, 3, 3, 3
//		List는 입력한 모든 값이 저장이 되는 특성을 가짐.
//		Set는 입력한 값이 고유의 값이 되어야한다는 특성을 가짐.
		HashSet<Integer> B = new HashSet<Integer>();
		B.add(3);
		B.add(4);
		B.add(5);
		HashSet<Integer> C = new HashSet<Integer>();
		C.add(1);
		C.add(2);
		
		System.out.println(AHash.containsAll(B)); // false B는 A의 부분집합이 아니다.
		System.out.println(AHash.containsAll(C)); // true C는 A의 부분집합이다.
		
//		AHash.addAll(B); // A 와 B의 합집합 A = {1, 2, 3, 4, 5}
//		AHash.retainAll(B); // A와 B의 교집합 A = {3}
		AHash.removeAll(B); // A와 B의 차집합 A = {1, 2, 3}
		Iterator hi = (Iterator) AHash.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
			System.out.println("HASH");
		}
		// Iterator는 공통 인터페이스로 정의되어 있음.
		// HashSet, ArrayList 등 모두 사용가능하다.
		Iterator hA = (Iterator) AAryList.iterator();
		while(hA.hasNext()) {
			System.out.println(hA.next());
			System.out.println("AryList");
		}
		
		//Iterator는 반복
		//컨테이너에 있는 값을 하나하나 꺼내서 처리할 수 있음.
	}
	//Set은 순차적으로 저장하는 것을 보장할 수 없다.
	//List은 순차적으로 저장
}
