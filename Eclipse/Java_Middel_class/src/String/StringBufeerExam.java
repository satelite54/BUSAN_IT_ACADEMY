package String;

public class StringBufeerExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		sb.append("hello"); // �ڱ� �ڽ��� ��ȯ�߾���!
		sb.append(" ");
		sb.append("world");
		
		String str = sb.toString();
		
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = sb2.append("hello"); //�ڱ� �ڽ� this�� ��ȯ����
		if(sb2 == sb3) {
			System.out.println("sb2 == sb3");
		}
		
		String str2= new StringBuffer().append("hello").toString();
		// ������ �ڿ����� Ŭ������ �޼ҵ带 ȣ���� �� �ֳ�.. ó�� �˾Ҵ�.
	}
}
