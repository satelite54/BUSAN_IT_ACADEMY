package java_temp;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class IOclass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));
				) { // try °ýÈ£ ¾È¿¡
			out.writeInt(100);
			out.writeBoolean(true);
			out.writeDouble(50.5);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
