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
//		A = {1, 2, 3} //Set�� ������ Ư���� ������ �ִ�. ������ ���� �ߺ��Ǿ�� �ȵȴ�!
		System.out.println("----------------------------");
		
		AAryList.add(1);
		AAryList.add(2);
		AAryList.add(3);
		AAryList.add(3);
		AAryList.add(3);
		AAryList.add(3);
		AAryList.add(3);
//		hashSet = 1, 2, 3
//		������ ����ִ� ���� ���� ��� ����
//		ArrayList = 1 , 2 , 3, 3, 3, 3, 3
//		List�� �Է��� ��� ���� ������ �Ǵ� Ư���� ����.
//		Set�� �Է��� ���� ������ ���� �Ǿ���Ѵٴ� Ư���� ����.
		HashSet<Integer> B = new HashSet<Integer>();
		B.add(3);
		B.add(4);
		B.add(5);
		HashSet<Integer> C = new HashSet<Integer>();
		C.add(1);
		C.add(2);
		
		System.out.println(AHash.containsAll(B)); // false B�� A�� �κ������� �ƴϴ�.
		System.out.println(AHash.containsAll(C)); // true C�� A�� �κ������̴�.
		
//		AHash.addAll(B); // A �� B�� ������ A = {1, 2, 3, 4, 5}
//		AHash.retainAll(B); // A�� B�� ������ A = {3}
		AHash.removeAll(B); // A�� B�� ������ A = {1, 2, 3}
		Iterator hi = (Iterator) AHash.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
			System.out.println("HASH");
		}
		// Iterator�� ���� �������̽��� ���ǵǾ� ����.
		// HashSet, ArrayList �� ��� ��밡���ϴ�.
		Iterator hA = (Iterator) AAryList.iterator();
		while(hA.hasNext()) {
			System.out.println(hA.next());
			System.out.println("AryList");
		}
		
		//Iterator�� �ݺ�
		//�����̳ʿ� �ִ� ���� �ϳ��ϳ� ������ ó���� �� ����.
	}
	//Set�� ���������� �����ϴ� ���� ������ �� ����.
	//List�� ���������� ����
}
