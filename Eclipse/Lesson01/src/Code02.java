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
		
		
		// ������Ƽ�� Ÿ�� �� == �����ڷ� ���ϼ� �Ǵܰ���
		// String�� primitive type �� �ƴϱ� ������ equals()�� ��
		if(input.equals(str)) {
			System.out.println("Numbers match! :-");
		} else {
			System.out.print("Numbers do not match! :-(");
		}
		
		
		keyboard.close();
	}

}
