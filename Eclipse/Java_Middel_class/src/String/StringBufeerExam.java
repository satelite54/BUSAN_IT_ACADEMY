package String;

public class StringBufeerExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		sb.append("hello"); // 자기 자신을 반환했었네!
		sb.append(" ");
		sb.append("world");
		
		String str = sb.toString();
		
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = sb2.append("hello"); //자기 자신 this를 반환했음
		if(sb2 == sb3) {
			System.out.println("sb2 == sb3");
		}
		
		String str2= new StringBuffer().append("hello").toString();
		// 생성자 뒤에서도 클래스의 메소드를 호출할 수 있네.. 처음 알았다.
	}
}
