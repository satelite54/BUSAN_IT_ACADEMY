package java_temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ioclass6 {
	
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader("src/java_temp/cStudent.java"));
			pw = new PrintWriter(new FileWriter("test.txt"));
			
			String line = null;
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.close();
		}
		
	}
}