import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClassesTest {

  @Test
  public void findSpecial() throws IOException, SAXException,
          ParserConfigurationException {
    String[] expected = {"id2", "id3", "id9", "id15", "id15b", "id16", "id13", "id26"};
    List<String> observed = FindClasses.findClasses(
            FindClasses.parse("data/classes.html").getDocumentElement(),
            "special", new ArrayList<String>());
    Assert.assertEquals(Arrays.asList(expected), observed);
  }

  @Test
  public void findOrdinary() throws IOException, SAXException,
          ParserConfigurationException {
    String[] expected = {"id1", "id4", "id10", "id23", "id37", "id28"};
    List<String> observed = FindClasses.findClasses(
            FindClasses.parse("data/classes.html").getDocumentElement(),
            "ordinary", new ArrayList<String>());
    Assert.assertEquals(Arrays.asList(expected), observed);
  }
}