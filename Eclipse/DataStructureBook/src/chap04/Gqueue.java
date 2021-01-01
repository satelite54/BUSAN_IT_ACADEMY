package chap04;

public class Gqueue <E>{
	int maxSize;
	int DataNum;
	int DataFront;
	int Datarear;
	E[] que;
	
	public Gqueue(int capaity) {
		this.que = (E[]) new Object[capaity]; // 제너릭은 new 연산자로 생성이 불가능하다. 왜냐하면 new 연산자는 컴파일 타임에서 정확한 타입을 알고싶어 하기 때문에
		// 오브젝트형 배열을 생성해서 형변환 하는 방식으로 하면된당!
		// 오브젝트 클래스는 부모고 제네릭 E는 자식이기 때문에 명시적으로 형을 적어줘야함.
		this.maxSize = capaity;
		this.DataFront = this.DataNum = this.Datarear = this.DataFront = 0;
	}
	
	public boolean enqueue(E x) {
		if(DataNum == maxSize) // 큐에 데이터가 꽉 찼을 때의 예외처리
			return false;
		que[Datarear++] = x;// 데이터를 넣어주면서 rear 증가..
		DataNum++;// 데이터 갯수 증가
		if(Datarear == maxSize) {// 리어가 데이터 최대 갯수랑 같으면 0으로 초기화
			Datarear = 0;
		}
		return true;
	}
	
	public E dequeue() { // 제네릭 클래스는 RuntimeException 클래스를 상속 받아 예외를 발생 못시킨다고 한다 ㅠㅠ. 어떻게 해야하지?
		if(DataNum == 0) {
			try {
				throw new Exception(); // 이렇게 발생시키면 될려나
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
