package java_temp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam_hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<>(); // Set�� �������̽��̱� ������ ��ü���� �Ұ� Set�� ���� Ŭ������ HashSet�� �̿� 
		boolean flag1 = set1.add("Kang"); //���� �Ҷ� ���� boolean ���� ���� ���� ���� �����ϸ� false ��ȯ
		boolean flag2 = set1.add("kim");
		boolean flag3 = set1.add("Kang");
		
		System.out.println(set1.size());
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);
		
		Iterator<String> iter = set1.iterator(); //iterator() ���ͷ����� �������̽��� ������ ��ü�� ���ϵ�.
		while (iter.hasNext()) {
			String string = iter.next(); //���� �ϳ��� ���׼� ����Ѵ�.
			System.out.println(string);
		}
	}
}
