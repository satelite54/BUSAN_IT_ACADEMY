package lifeCoding;

public class foreach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] classGroup2 = {"������", "������", "�Ѿƶ�"};
		
		for(int i = 0; i < classGroup2.length; i++) {
			String member = classGroup2[i];
			System.out.println(member + "���Ϸ�");
		}
		
		for(String e : classGroup2) { // for each ����Ʈ �ݺ���
			String member = e;
			System.out.println(member + "���Ϸ�");
		}
	}

}
