package java_temp;

public class Threadexam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		theard_th Thread = new theard_th("*");
		theard_th Thread2 = new theard_th("-");
		
		// ������ ���� �غ� �޼ҵ� start
		Thread.start(); //
		Thread2.start();
		
		System.out.println("main end !!!");
	}

}
