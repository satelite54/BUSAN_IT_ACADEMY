package AccessModifier;

public class A {

	public String y() {
		return "public void y()";
	}
	public String z() {
		return "public void z()";
	}
	public String x() {
		return z();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		System.out.println(a.y());
		System.out.println(a.x());
		//System.out.println(a.z()); // private String
	}
}
