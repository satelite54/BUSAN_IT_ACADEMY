
public class CylinderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cylinder c = new Cylinder(4.5, 4.5);
		
		System.out.printf("¿ø±âµÕÀÇ ºÎÇÇ: %.2f\n", c.CalCylinderVolume());
		System.out.printf("¿ø±âµÕÀÇ °Ñ³ĞÀÌ: %.2f\n", c.CalCylinderSurfaceArea());
	}
}

class Cylinder {
	double raius = 0.0;
	double height = 0.0;
	
	Cylinder (double raius, double height) {
		this.raius = raius;
		this.height = height;
	}
	
	public double CalCylinderSurfaceArea () {
		return 2 * Math.PI * this.raius * this.raius + 2 * Math.PI * this.raius * this.height;
	}
	
	public double CalCylinderVolume() {
		return Math.PI * this.raius * this.raius * this.height;
	}
}