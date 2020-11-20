package lifeCoding;

public class CScope2 {

	int age = this.age;
	
	static int i; // 전역 변수(global variables)
	static void a() {
		i = 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (i = 0; i < 5; i++) {
			a();
			System.out.println(i);
		}
	}
	// 프로젝트에서 자바 파일 선택 후 오른쪽 클릭 -> Compare With -> Each other
	// 두개 파일이 동일한지?? 비교해준다.
}
