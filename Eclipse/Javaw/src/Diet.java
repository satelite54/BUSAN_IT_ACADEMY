
public class Diet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double w = 81.6;
		double t = 1.76;
		
		double bmi = calculate(w, t);
		
		System.out.printf("BMI: %.2f(%.1fkg, %.2fm)\n", bmi, w, t);
		System.out.printf("���: %s�Դϴ�.\n", result(bmi));
	}

	public static double calculate(double weight, double tall) {
		return weight/(tall * tall);
	}
	public static String result(double bmi) {
		String result = "";

		if (bmi >= 30) {
			result = "��";
		} else if (bmi >= 25) {
			result = "��ü��";
		} else if (bmi >= 18.5) {
			result = "����";
		} else {
			result = "��ü��";
		}
		
		return result;
	}
}
