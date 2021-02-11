package Jsoup;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) throws IOException {
		String url = "https://www.google.com/search?sxsrf=ALeKk02pRH3qcnuI5jx4Cj9OUhugNcDr6Q%3A1613023303751&ei=R8gkYNakLZaPr7wPnKiGoAE&q=%EB%B2%84%EB%B2%84%EB%A6%AC+%EC%BD%94%ED%8A%B8+%EC%98%81%EC%96%B4%EB%A1%9C&oq=%EB%B2%84%EB%B2%84%EB%A6%AC+%EC%BD%94%ED%8A%B8+%EC%98%81%EC%96%B4%EB%A1%9C&gs_lcp=CgZwc3ktYWIQAzIFCCEQoAE6BAgjECc6BQgAELEDOggIABCxAxCDAToECAAQAzoECAAQQzoHCAAQsQMQQzoHCAAQFBCHAjoCCAA6CQgAEEMQRhD_AToECAAQHjoGCAAQBRAeOgwIABAUEIcCEEYQ_wE6BwgjEOoCECc6BAgAEAo6BggAEAgQHlD0hw5Y7LgOYLO6DmgNcAB4BIABywOIAZ85kgELMS4xMC4yMi4wLjGYAQCgAQGqAQdnd3Mtd2l6sAEKwAEB&sclient=psy-ab&ved=0ahUKEwiW5KKIlOHuAhWWx4sBHRyUARQQ4dUDCA0&uact=5";
		
		Document doc = Jsoup.connect(url).get();

		Elements elements = doc.select("td");
		Elements elements2 = elements.select("a");
		Elements elements3 = elements2.select("a.fl");
		List<String> list = elements3.eachAttr("href");
		
		System.out.println(list);
	}

}
