
public class ProgrammingGrades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score1 = 96;
		int score2 = 85;
		int score3 = 76;
		
		System.out.printf("%dÁ¡ -> %s\n", score1, grade(score1));
		System.out.printf("%dÁ¡ -> %s\n", score2, grade(score2));
		System.out.printf("%dÁ¡ -> %s\n", score3, grade(score3));
	}
	
	public static String grade(int score) {
		if(score >= 95)
			return "A+";
		else if (score >= 85) {
			return "B+";
		}
		else if (score >= 75) {
			return "B0";
		}
		return "null";
	}
}
