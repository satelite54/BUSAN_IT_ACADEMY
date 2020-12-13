
public class WrapperExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		Integer i2 = new Integer(5);
		
		Integer i3 = 5;// 숫자 5는 자동으로 인티져로 변환됨 (오토 박싱) 됨
		// 자바 5버전 이후부터 이렇게 할 수 있다고 한다.
		
		int i4 = i3.intValue();
		// 
		int i5 = i3;// (오토 언박싱);
	}

}
