package String;

public class StringExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "hello world";
		String str2 = str1.substring(5);
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = str1 + str2;
		System.out.println(str3);
		
		String str4 = new StringBuffer().append(str1).append(str2).toString();
		System.out.println(str4);
		
		String str5="";
		
		for(int i = 0; i < 100; i++) {
			str5 = str5 + "*";
			// 100번 동안 스트링버퍼 클래스가 생성된다.
		}
		System.out.println(str5);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 100; i++) {
			sb.append("*"); //반복적으로 문자를 더해야하는 경우는 이렇게 하는게 성능상으로 좋다.
		}// 하지만 문자열을 반복문 안에서 처리하게 된다면 성능상에 문제가 발생할 수 있다!
		
		String str6 = sb.toString();
		System.out.println(str6);
	}
}
