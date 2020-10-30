import java.util.Scanner;

public class Code02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hellow";
		Scanner keyboard = new Scanner(System.in);
		
		String input = keyboard.next();
		
//		if(input == number) {
//			System.out.println("Numbers match! :-");
//		} else {
//			System.out.print("Numbers do not match! :-(");
//		}
		
		
		// 프리미티브 타입 은 == 연산자로 동일성 판단가능
		// String은 primitive type 이 아니기 때문에 equals()로 비교
		if(input.equals(str)) {
			System.out.println("Numbers match! :-");
		} else {
			System.out.print("Numbers do not match! :-(");
		}
		
		
		keyboard.close();
	}

}
