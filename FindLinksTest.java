import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLinksTest {

  @Test
  public void findLotsOfLinks() throws IOException, SAXException, ParserConfigurationException {
    System.out.println("Start findLotsOfLinks");
    Document doc = FindLinks.parse("data/lotsOfLinks.html");
    List<String> observed = FindLinks.findLinks(doc);
    String[] expected = {"#bottom", "http://www.google.com", "http://www.microsoft.com", "http://jasmine.github.io", "http://www.gatech.edu", "http://www.gvsu.edu", "http://stackoverflow.com", "http://bubbletimer.com", "https://piazza.com"};
    Assert.assertEquals(Arrays.asList(expected), observed);
  }

  @Test
  public void findLotsOfLinksWithScript() throws IOException, SAXException, ParserConfigurationException {
    System.out.println("Start findLotsOfLinksWithScript");
    Document doc = FindLinks.parse("data/lotsOfLinksWithScript.html");
    List<String> observed = FindLinks.findLinks(doc);
    String[] expected = {"#bottom", "http://www.google.com", "http://www.microsoft.com", "http://jasmine.github.io", "http://www.gatech.edu", "http://www.gvsu.edu", "http://stackoverflow.com", "http://bubbletimer.com", "https://piazza.com"};
    System.out.printf("Observed: %d\nExpected: %d\n", observed.size(), expected.length);
    Assert.assertEquals(Arrays.asList(expected), observed);
  }

  @Test
  public void noLinks() throws IOException, SAXException, ParserConfigurationException {
    System.out.println("Start noLinks");
    Document doc = FindLinks.parse("data/noLinks.html");
    List<String> observed = FindLinks.findLinks(doc);
    Assert.assertEquals(new ArrayList<String>(), observed);
  }

}