package Util;

public class CLog {
	long start;
	long end;
	public void StartTime() {
		this.start = System.currentTimeMillis();
	}
	public void EndTime() {
		this.end = System.currentTimeMillis();
		System.out.print("\n");
		System.out.println("���� �ð� : " + ( end - start )/1000.0);
	}
}
