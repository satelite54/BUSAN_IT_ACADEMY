package chap04;

public class Gqueue <E>{
	int maxSize;
	int DataNum;
	int DataFront;
	int Datarear;
	E[] que;
	
	public Gqueue(int capaity) {
		this.que = (E[]) new Object[capaity]; // ���ʸ��� new �����ڷ� ������ �Ұ����ϴ�. �ֳ��ϸ� new �����ڴ� ������ Ÿ�ӿ��� ��Ȯ�� Ÿ���� �˰�;� �ϱ� ������
		// ������Ʈ�� �迭�� �����ؼ� ����ȯ �ϴ� ������� �ϸ�ȴ�!
		// ������Ʈ Ŭ������ �θ�� ���׸� E�� �ڽ��̱� ������ ��������� ���� ���������.
		this.maxSize = capaity;
		this.DataFront = this.DataNum = this.Datarear = this.DataFront = 0;
	}
	
	public boolean enqueue(E x) {
		if(DataNum == maxSize) // ť�� �����Ͱ� �� á�� ���� ����ó��
			return false;
		que[Datarear++] = x;// �����͸� �־��ָ鼭 rear ����..
		DataNum++;// ������ ���� ����
		if(Datarear == maxSize) {// ��� ������ �ִ� ������ ������ 0���� �ʱ�ȭ
			Datarear = 0;
		}
		return true;
	}
	
	public E dequeue() { // ���׸� Ŭ������ RuntimeException Ŭ������ ��� �޾� ���ܸ� �߻� ����Ų�ٰ� �Ѵ� �Ф�. ��� �ؾ�����?
		if(DataNum == 0) {
			try {
				throw new Exception(); // �̷��� �߻���Ű�� �ɷ���
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		E returnValue = que[DataFront++];
		if(DataFront == maxSize)
			DataFront = 0;
		
		return returnValue;
	}
}
