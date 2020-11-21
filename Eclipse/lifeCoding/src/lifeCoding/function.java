package lifeCoding;

public class function {

	public static void main(String[] args) {// Run Configuration에서 파라미터를 줄 수 있다.
		// TODO Auto-generated method stub
		int i = 4;
		name(i); // 여기서는 인자라고 함
		PrintStringAry(args);
	}
	
	public static void name(int limit) { // 매서드의 입력 값은 매개변수, 파라미터
		int i = 0;
		while (i < limit) {
			System.out.println(i);
			i++;
		}
	}
	public static void PrintStringAry(String[] str) { // 매서드의 입력 값은 매개변수, 파라미터
		for(int i = 0; i < str.length; i++)
		System.out.println(str[i]);
	}
}
// java 프로그램을 실행할 때
// cmd
// 프로그램내
//java -cp bin 패키지명.클래스명 [입력값1, 입력값2...]