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

public class CWorkspace { // 직장 // 직장은 엄마인지 아빠인지 알 필요가 없다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		progerammer employee1 = new Steve(); //프로그래머
		progerammer employee2 = new Rachel(); // 프로그래머
		
		employee1.coding();
		employee2.coding();
		
		// 스티브의 엄마와 레이첼의 엄마는 다르다.
		mother parents = new Steve();
		mother parents2 = new Rachel();
		parents.mothermakefood();
		parents2.mothermakefood();

		// 스티브의 아빠와 레이첼의 아빠는 같다. ㅋㅋㅋ ㅠㅠㅠㅠㅠ
		father parents3 = new Steve();
		father parents4 = new Rachel();
		
		parents3.fathermakefood();
		parents4.fathermakefood();
	}
}
