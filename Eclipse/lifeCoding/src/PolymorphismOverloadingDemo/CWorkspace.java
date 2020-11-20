package PolymorphismOverloadingDemo;

interface father{
	public void fathermakefood();
}
interface mother{
	public void mothermakefood();
}
interface progerammer{
	public void coding();
}
interface believer{
	
}

class Steve implements father, progerammer, believer, mother{
	public void coding() {
		System.out.println("fast");
	}
	public void mothermakefood() {
		System.out.println("Mom's cooking for Steve");
	}
	
	public void fathermakefood() {
		System.out.println("Father's cooking SandWich");
	}
}
class Rachel implements mother, progerammer, father {
	public void coding() {
		System.out.println("elegance");
	}
	public void mothermakefood() {
		System.out.println("Mom's cooking for Rachel");
	}
	public void fathermakefood() {
		System.out.println("Father's cooking SandWich");
	}
}

public class CWorkspace { // ���� // ������ �������� �ƺ����� �� �ʿ䰡 ����.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		progerammer employee1 = new Steve(); //���α׷���
		progerammer employee2 = new Rachel(); // ���α׷���
		
		employee1.coding();
		employee2.coding();
		
		// ��Ƽ���� ������ ����ÿ�� ������ �ٸ���.
		mother parents = new Steve();
		mother parents2 = new Rachel();
		parents.mothermakefood();
		parents2.mothermakefood();

		// ��Ƽ���� �ƺ��� ����ÿ�� �ƺ��� ����. ������ �ФФФФ�
		father parents3 = new Steve();
		father parents4 = new Rachel();
		
		parents3.fathermakefood();
		parents4.fathermakefood();
	}
}
