package Jsoup;
//The Vapoor ���������̼� 600���� �ϳ���
//get ������� �޴� ������ product_no = �� 8000��, display = 1 or 2,category_no = 0 ~ 50, page=1~ 

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class practice1 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		crawling theVapor = new crawling();
		List<String[]> products = theVapor.theVaporProducts();
		for(int i = 0; i < products.size(); i++) {
			String[] strArr = products.get(i);
			for(int j = 0; j < strArr.length; j++) {
				bw.write(strArr[i]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}