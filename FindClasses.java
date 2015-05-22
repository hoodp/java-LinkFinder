import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Find all elements with a given class*
 */
public class FindClasses {

  public static Document parse(String fileName) throws ParserConfigurationException, IOException, SAXException {
    // Create a DOM tree (a tree of objects) describing an xhtml document.
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
    return domBuilder.parse(fileName);
  }

  private static List<String> findClasses(Element e, String className, List<String> answer) {
    //TODO:  Complete this method
    return answer;
  }

  //
}
