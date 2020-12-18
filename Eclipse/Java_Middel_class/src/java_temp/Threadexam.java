package java_temp;

public class Threadexam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		theard_th Thread = new theard_th("*");
		theard_th Thread2 = new theard_th("-");
		
		// 쓰레드 시작 준비 메소드 start
		Thread.start(); //
		Thread2.start();
		
		System.out.println("main end !!!");
	}

}
