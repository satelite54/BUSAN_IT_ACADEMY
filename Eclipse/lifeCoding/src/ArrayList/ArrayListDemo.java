package ArrayList;

import java.util.ArrayList;
import lifeCoding.*;;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayObj = new String[2];
		arrayObj[0] = "one";
		arrayObj[1] = "two";
//		arrayObj[2] = "three"; // ������ �߻��Ѵ�.
		for(int i = 0; i < arrayObj.length; i++) {
			System.out.println(arrayObj[i]);
		}
		
		ArrayList al = new ArrayList(); // ��������� ���׸� ��������

		
		al.add("one");// ArrayList�� ������ �߰��ϱ� ���ؼ��� .add("") object Ÿ������ ����ȴ�.
		al.add("two");
		al.add("three");
		for(int i = 0; i < al.size(); i++) {// ArrayList�� ���̱��ϱ����� size()
			String value = (String)al.get(i);// object Ÿ������ ����Ǳ� ������ ����ȯ ��������Ѵ�.(���� ���)
			System.out.println(al.get(i));
		}
		
		ArrayList<String> al2= new ArrayList<String>();
		al2.add("one");// ArrayList�� ������ �߰��ϱ� ���ؼ��� .add("") object Ÿ������ ����ȴ�.
		al2.add("two");
		al2.add("three");
		for(int i = 0; i < al2.size(); i++) {// ArrayList�� ���̱��ϱ����� size()
			String value = al2.get(i);
			System.out.println(al2.get(i));
		}
	}
}
