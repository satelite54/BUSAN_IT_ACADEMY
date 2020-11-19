
public class Pork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weight = 180;
		float calory = 5.179f;
		int person = 3;
		
		float result = calcalory(weight, calory, person);
		System.out.printf("%.2f", result);
	}
	
	public static float calcalory(int weight, float calory, int person) {
		float totalcalory = person * weight * calory;
		return totalcalory;
	}
}