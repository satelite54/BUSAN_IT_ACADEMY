
public class Elevator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 13;
		int b = 7;
		int c = 10;
		
		System.out.printf("%d�� -> %s ����������\n" + " %d ", a, guide(a), a);
		System.out.printf("%d�� -> %s ����������\n", b, guide(b));
		System.out.printf("%d�� -> %s ����������\n", c, guide(c));
	}
	public static String guide(int a) {
		return (a >= 11) ? "����" : "����";
	}
}
