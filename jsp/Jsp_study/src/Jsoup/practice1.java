package Jsoup;
//The Vapoor ���������̼� 600���� �ϳ���
//get ������� �޴� ������ product_no = �� 8000��, display = 1 or 2,category_no = 0 ~ 50, page=1~ 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class practice1 {

	public static void main(String[] args) throws IOException {
		//ó�� ������ ����Ʈ
		String url1 = "http://www.thevapor.co.kr";
		Document doc1 = Jsoup.connect(url1).get();
		List<String> el1 = doc1.getElementsByClass("xans-record-").select("a").eachAttr("href");
		System.out.println(el1);
		
		//ī�װ� 5���� �ϴ� ����(�α����ؾ� ũ�Ѹ� ����)
		int categorySize = el1.size();
		for(int i = 0; i < categorySize; i++) {
			el1.remove(0);
			if(i == 4) {// ���� �Խ��� ��� �ϴ� ���� �� �� Ż��
				el1.remove(el1.size() - 1);
				break;
			}
		}
		//����� �� ������Ʈ �ּ� �ִ� for��
		String[] strAry = new String[el1.size()];
		for(int i = 0; i < el1.size(); i++) {
			strAry[i] = url1 + el1.get(i);
			System.out.println(strAry[i]);
		};
		//ī�װ����� ��ǰ ��� ũ�Ѹ�
		int n = strAry.length;
		while(n --> 0) {
			String url2 = strAry[n];
			Document doc2 = Jsoup.connect(url2).get();
			String a = "http://www.thevapor.co.kr";
			List<String> el2 = doc2.getElementsByClass("item xans-record-").select("a").eachAttr("href");
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < el2.size(); i++) {
				sb.append(a + el2.get(i));
				sb.append("\n");
			}
			
			StringTokenizer tk = new StringTokenizer(sb.toString());
			List<String> listTk = new ArrayList<String>();
			try {
				while(tk.hasMoreTokens())
					listTk.add((String) tk.nextElement());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			List<Document> docList = new ArrayList<Document>();
			for (int i = 0; i < listTk.size(); i++) { // �������� ����ϴ� �κ� List�� �ٸ� ������� �����͸� ��ƾ���
				Document doc3 = Jsoup.connect(listTk.get(i)).get();
				System.out.println(doc3);
				docList.add(doc3);
			}
		}
	}
}