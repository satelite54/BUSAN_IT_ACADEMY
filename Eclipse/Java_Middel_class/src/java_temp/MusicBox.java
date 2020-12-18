package java_temp;

public class MusicBox {
	public synchronized void playMusicA() { // �������� ��ü���� ������ü�� ���� ����� ���
		// ���� ���� �Ǹ� �ش� ��ü�� ������ ��� �ȴ�.
		// synchronized Ű���尡 �̷� ������ �Ѵ�.
		// ������ �Ǹ� ����͸� ���� ��� �ȴ�.
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
	public synchronized void playMusicB() {
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
	public void playMusicC() {// �ٸ� ��������� ����͸� ���� ȹ���ص� ����� synchronized Ű���尡 ���� �����Ӱ� ����ȴ�.
		for(int i = 0; i < 10; i++) {
			synchronized (this) { //���� ��ü�� ����͸� ���� ���� �� ���� �� ����͸��� ������ �ؼ� ����ȭ �ϰڴٶ�� ��.
				System.out.println("ī�� ����!!!");
			}			
//			System.out.println("ī�� ����!!!");
			try {
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// �κкκи� synchronized�� �����ϴ�.
}
