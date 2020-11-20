package lifeCoding;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] classGroup = new String[10];
		String[] classGroup2 = {"최진혁", "최유빈", "한아람"};
		
		for(int i = 0; i < classGroup2.length; i++) {
			String member = classGroup2[i];
			System.out.println(member + "상담완료");
		}
	}

}
