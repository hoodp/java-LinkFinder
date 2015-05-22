import org.w3c.dom.*;
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

  public static List<String> findClasses(Element e, String className, List<String> answer) {

    // get elements child nodes
    NodeList nodes = e.getChildNodes();

    // start looping through each child node
    for (int i = 0; i < nodes.getLength(); i++) {

      // get current node
      Node node = nodes.item(i);

      // get node attributes
      NamedNodeMap attr = node.getAttributes();

      // check for null attributes & null class
      if (attr != null && attr.getNamedItem("class") != null) {

        // search for matching class string
        if (attr.getNamedItem("class").getTextContent().equals(className)) {

          // add matching id to answer array
          String id = attr.getNamedItem("id").getTextContent();
          answer.add(id);
        }
      }

      // check if node is an element
      if (node.getNodeType() == Node.ELEMENT_NODE) {

        // convert node to element and recursive call findClasses
        Element element = (Element) node;
        findClasses(element, className, answer);
      }
    }
    return answer;
  }
}
