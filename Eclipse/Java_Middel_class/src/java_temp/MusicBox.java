package java_temp;

public class MusicBox {
	public void playMusicA() {
		for(int i = 0; i < 10; i++) {
			System.out.println("�ų��� ����!!!");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void playMusicB() {
		for(int i = 0; i < 10; i++) {
			System.out.println("���� ���� !!!");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void playMusicC() {
		for(int i = 0; i < 10; i++) {
			System.out.println("ī�� ����!!!");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
