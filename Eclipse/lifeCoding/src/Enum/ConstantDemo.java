package Enum;

//class Fruit{
////	int APPLE = 1, PEACH = 2, BANANA = 3;
//	public static final Fruit APPLE = new Fruit();// �ڱ��ڽ��� �ν��Ͻ�ȭ ��Ų ���� ���ÿ� ���� ����
//	public static final Fruit PEACH = new Fruit();
//	public static final Fruit BANANA = new Fruit();
// ������ �ɹ��� �迭ó�� ������ �� ����.
//}
// enum�� ����.
enum Fruit {// �ϳ��� Ŭ������ ������ ���
	APPLE("red"), PEACH("pink"), BANANA("yellow");//APPLE�� red ���� ������ �Ű������� �־��� // enum�� �̷��� �����ڿ� �谳���� ���ް���
//	public static final Fruit APPLE = new Fruit();// �ڱ��ڽ��� �ν��Ͻ�ȭ ��Ų ���� ���ÿ� ���� ����
//	public static final Fruit PEACH = new Fruit();
//	public static final Fruit BANANA = new Fruit();
	// �� ����. ������� ���� �� �� ���� �ν��Ͻ�ȭ ��
	// �ν��Ͻ��� �����ϱ����� �����ڸ� 3�� ȣ����
	Fruit(String color) {
		System.out.println("Call Constructor " + this); //���⼭ this�� �ν��Ͻ��� ����Ŵ
		this.color = color;
	}	
	private String color;
	public String getColor() {
		return this.color;
	}
	// enum�� �ʵ�� �żҵ尡 �� �� �� �ִ� ������ Ŭ������.
}
enum Company {// �ϳ��� Ŭ������ ������ ���
	GOOGLE, APPLE, ORECALE
}


//class Company {
//	public static final Company GOOGLE = new Company();// �ڱ��ڽ��� �ν��Ͻ�ȭ ��Ų ���� ���ÿ� ���� ����
//	public static final Company APPLE = new Company();
//	public static final Company ORACLE = new Company();
//}

public class ConstantDemo {
	
//	private final static int FRUIT_APPLE = 1;
//	private final static int FRUIT_PEACH = 2;
//	private final static int FRUIT_BANANA = 3;

//	private final static int COMPANY_GOOGLE = 1;
//	private final static int COMPANY_APPLE = 2;
//	private final static int COMPANY_ORECALE = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		for(Fruit f : Fruit.values()) { // enum���� values �żҵ带 ����ϸ� enum���� �����͸� �̾��ش�.
			// �������� �̷������� �׼��� for���� ����� �� �ִ�.
			System.out.println(f);
		}
		
// �ּ��� �ʿ���� ��� �������� ����.
//		Fruit type = Fruit.APPLE;
//		switch(type) { //
//		case APPLE: 
//			System.out.println(57 + "kcal, color : " + Fruit.APPLE.getColor());
//			break;
//		case PEACH:
//			System.out.println(34+ "kcal, color : " + Fruit.PEACH.getColor());
//			break;
//		case BANANA:
//			System.out.println(93 + "kcal, color : " + Fruit.BANANA.getColor());
//			break;
//		default: System.out.println("no input");
//		}
	}
	
	//enum�� ����ϸ� �ڵ尡 ����������.
}
