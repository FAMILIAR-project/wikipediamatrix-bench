package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {
	
	@Test
	public void testUrl() throws IOException {	
		
		Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		System.out.println(doc.title());
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
			System.out.println(headline.attr("title") + " " + headline.absUrl("href"));
		}		
	}
	
	@Test 
	public void testUrlCanon() throws IOException {
		
		String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc.title());
		
		
	}

}
