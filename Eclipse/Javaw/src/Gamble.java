
public class Gamble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dollar = dice() + dice() + dice();
		double exchange = 1082.25108;
		double won = exchange(dollar, exchange);
		System.out.printf("È¹µæ ±Ý¾×: $%.2f(%.0f¿ø)", dollar, won);
	}

	public static int dice() {
		return (int)(Math.random() * 6 + 1);
	}
	
	public static double exchange(double dollar, double exchange) {
		return exchange * dollar;
	}
}
