package java_temp;

public class Box_Generic<E> { //가상 클래스 E를 사용하겠다.
	private E obj;
	
	public void setOdj(E obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return obj;
	}
}
