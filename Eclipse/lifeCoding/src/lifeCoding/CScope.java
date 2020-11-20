package lifeCoding;

public class CScope { // 유효 범위

	public static void a() {
		int i = 0; // i는 메소드 안에서만 사용가능한 범위
		// 지역 변수(local variables)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			a();
			System.out.println(i);
		}
	}
}
