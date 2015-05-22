import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Finds the links in an xhtml web page*
 */
public class FindLinks {

  public static Document parse(String fileName) throws ParserConfigurationException, IOException, SAXException {

    // Create a DOM tree (a tree of objects) describing an xhtml document.
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
    Document doc = domBuilder.parse(fileName);
    return doc;
  }

  public static List<String> findLinks(Document doc) {

    // get all anchor tags in the document
    NodeList anchors = doc.getElementsByTagName("a");

    // empty list for storing urls
    List<String> links = new ArrayList<String>();

    // start looping through each anchor node
    for (int i = 0; i < anchors.getLength(); i++) {

      // get current link node
      Node currentLink = anchors.item(i);

      // check that owner node is not a script
      if (!currentLink.getParentNode().getNodeName().equals("script")) {

        // get href attribute
        currentLink = currentLink.getAttributes().getNamedItem("href");

        // check that href attribute is not null
        if (currentLink != null) {

          // add the current link href attribute to the links array
          links.add(currentLink.getTextContent());
        }
      }
    }
    return links;
  }
}

