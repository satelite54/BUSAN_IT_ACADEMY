package LeetCode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		
	}
	
	public static int reversInteger (int x) {
		// dwadwa
		String str;
		if(x < 0) {
			//String은 특정위치에 문자 삽입 불가하다.
			//그래서 StringBuilder를 사용했다.
			str = Integer.toString(Math.abs(x)); // 절대값
		}
		else {
			str = Integer.toString(x);
		}
		char tempChar = ' ';
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {// 역순으로 변경
			tempChar = str.charAt(i);
			sb.append(str.charAt(str.length() - 1 - i));
		}
		if(x < 0) {
			sb.insert(0, '-');
		}
		int result;
		try {
			result = Integer.parseInt(sb.toString());
		} catch (Exception e) {
			return 0;
		}
		return result;
	}
}
