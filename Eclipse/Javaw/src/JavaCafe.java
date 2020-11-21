
public class JavaCafe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printPay(10.00, 40);
		printPay(10.00, 50);
		printPay(7.50, 38);
		printPay(8.50, 66);

	}

	public static void printPay(double basePay, int hours) {
		double pay = 0.0;
		if (hours <= 40)
			pay = hours * basePay;
		if (hours > 40) {
			pay = 40 * basePay;
			pay += (hours - 40) * basePay * 1.5;
		}
		if (basePay < 8.0) {
			System.out.println("�⺻ �ñ��� �۽��ϴ�!! �����Ͻʽÿ�!!");
		}

		if (hours > 60)
			System.out.println("�ٹ��ð��� �ʹ� �����ϴ�!!!");
		System.out.printf("$ %.2f\n", pay);
	}
}
