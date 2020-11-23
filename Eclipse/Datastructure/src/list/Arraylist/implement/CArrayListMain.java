package list.Arraylist.implement;

import java.util.ArrayList;
import java.util.Iterator;

public class CArrayListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		System.out.println("add(값)");
		System.out.println(numbers);
		
		numbers.add(1, 50);
		System.out.println("\nadd(인덱스, 값)");
		System.out.println(numbers);
		
		numbers.remove(3); // 
		System.out.println(numbers);
		
		int n = numbers.get(2);// 데이터 꺼내오기
		System.out.println(n);
		
		int nlistSize = numbers.size();// 사이즈
		System.out.println(nlistSize);
		
		Iterator it = numbers.iterator(); // Iterator 인터페이스
		System.out.println("\niterator");
		while(it.hasNext()) {
			int value = (int)it.next();
			if(value == 20) {
				it.remove();
			}
			System.out.println(value);
		}
		System.out.println(numbers);
		
		System.out.println("\nfor each");
		for(int value : numbers ) {
			System.out.println(value);
		}
		
		for(int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
	}
}
