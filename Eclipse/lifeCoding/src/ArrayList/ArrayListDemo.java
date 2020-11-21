package ArrayList;

import java.util.ArrayList;
import lifeCoding.*;;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayObj = new String[2];
		arrayObj[0] = "one";
		arrayObj[1] = "two";
//		arrayObj[2] = "three"; // 오류가 발생한다.
		for(int i = 0; i < arrayObj.length; i++) {
			System.out.println(arrayObj[i]);
		}
		
		ArrayList al = new ArrayList(); // 명시적으로 제네릭 설정가능

		
		al.add("one");// ArrayList에 데이터 추가하기 위해서는 .add("") object 타입으로 저장된다.
		al.add("two");
		al.add("three");
		for(int i = 0; i < al.size(); i++) {// ArrayList는 길이구하기위해 size()
			String value = (String)al.get(i);// object 타입으로 저장되기 때문에 형변환 시켜줘야한다.(옛날 방식)
			System.out.println(al.get(i));
		}
		
		ArrayList<String> al2= new ArrayList<String>();
		al2.add("one");// ArrayList에 데이터 추가하기 위해서는 .add("") object 타입으로 저장된다.
		al2.add("two");
		al2.add("three");
		for(int i = 0; i < al2.size(); i++) {// ArrayList는 길이구하기위해 size()
			String value = al2.get(i);
			System.out.println(al2.get(i));
		}
	}
}
