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

public class CWorkspace { // 送舌 // 送舌精 畳原昔走 焼匙昔走 硝 琶推亜 蒸陥.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		progerammer employee1 = new Steve(); //覗稽益掘袴
		progerammer employee2 = new Rachel(); // 覗稽益掘袴
		
		employee1.coding();
		employee2.coding();
		
		// 什銅崎税 畳原人 傾戚耽税 畳原澗 陥牽陥.
		mother parents = new Steve();
		mother parents2 = new Rachel();
		parents.mothermakefood();
		parents2.mothermakefood();

		// 什銅崎税 焼匙人 傾戚耽税 焼匙澗 旭陥. せせせ ばばばばば
		father parents3 = new Steve();
		father parents4 = new Rachel();
		
		parents3.fathermakefood();
		parents4.fathermakefood();
	}
}
