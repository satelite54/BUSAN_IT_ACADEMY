package lifeCoding;

public class ClassBaseMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CCalculator c1 = new CCalculator(10, 20); // �����ڿ� ���� �־��ش�. // �ν��Ͻ��� �����ϴ���.
		CCalculator c1 = new CCalculator();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		
//		CCalculator c2 = new CCalculator(10, 20);
		CCalculator c2 = new CCalculator();
		c1.setOprands(30, 40);
		c1.sum();
		c1.avg();
		
		double PIc1 = c1.PI; //static Ű���带 ���� �ɹ������� �����ϴ� ���
		double PIc2 = c2.PI; //�� ���� ���� �����Ѵ�.
		double PIclass = CCalculator.PI;// �ν��Ͻ��� �������� �ʰ� ���� ������
		System.out.println(PIc1+ ":" + PIc2 + ":" + PIclass);
		
		CCalculator.sticavg(40, 70); // �� Ŭ������ static�� ����ϳ�???
		// �����ϰ� Ŭ�������� �޼ҵ常 �̿��ϰ� ���� ���
		// �ν��Ͻ�ȭ�� ���� ������ ��ü�� �ٸ� ���¸� ������ ������ ���� �Է��ص� �ٸ��� ����ؾ߸��� �� �ؾ���
		// new�ؼ� Ŭ������ �ν��Ͻ�ȭ�ϴ� �ͺ���. ���ɵ� �� ����. �޸� IO�� �پ��ϱ�
		
		C1 c = new C1();
		c.static_static();
//		c.static_instance(); �ȉ� �ֳ� instance�� �� �޸𸮿� ���־��ϴϱ�.
		C1.static_static();
		c.instance_static(); // �̰� �ȴ� ��? �ν��ϰ� �����Ǽ� �� �޸𸮿� �ö󰡴ϱ�.
		c.instance_instance();
		
		// �ν��Ͻ� ����-> Non-Static Field
		// Ŭ���� ����-> Static Field
		
		CSubstractionableCalculator cs1 = new CSubstractionableCalculator();
		cs1.setOprands(10, 20);
		cs1.sum();
		cs1.avg();
		
		MultiplicationableCalsulator cs2 = new MultiplicationableCalsulator();
		cs2.setOprands(30, 40);
		cs2.sum();
		cs2.avg();
		cs2.multiplication();
		
		CDivisionableCalculator cs3 = new CDivisionableCalculator();
		cs3.setOprands(80, 80);
		cs3.sum();
		cs3.avg();
		cs3.multiplication();
		cs3.division();
		
		// ���࿡ �θ� Ŭ������ ������ �Ű������� ������ �ִ� ���� ������ �մ´�.
		// ����Ŭ�������� �θ� Ŭ������ �����ڸ� ������ְ� ������ �ڽ�Ŭ���� ������ �ʿ���
		// super(�Ű�����1, �Ű�����2.. �̷������� ����ȴ�.)
		
	}
}
