import java.util.Scanner;

public class Box_exam {

	public static void main(String[] args) { // 클래스에서 다양한
		// TODO Auto-generated method stub
//		Box_Generic box = new Box_Generic();
//		
//		box.setOdj(new Object());
//		Object obj = box.getObj();
//		
//		box.setOdj("hello");
//		 String str=(String)box.getObj();
//		 System.out.println(str);
//		 
//		 box.setOdj(1);
//		 int value = (int)box.getObj();
		
		Box_Generic<Object> box = new Box_Generic<>();
		box.setOdj(new Object());
		Object obj = box.getObj();
		
		Box_Generic<String> box2 = new Box_Generic<String>();
		box2.setOdj("hello");
		String str = (String) box2.getObj();
		
		Scanner kb = new Scanner(System.in);
		String n = kb.next();
		char a = n.charAt(0);
		System.out.println(a);
		
		int a1 = 0;
		String str1 = "";
	}
}
