package java_temp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExam_ArarryList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("kim");
		list.add("kim");
		list.add("kang");
		
		System.out.println(list.size()); // list의 부모 인터페이스인 Collectioninterface가 가지고 있는 메서드
		
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
