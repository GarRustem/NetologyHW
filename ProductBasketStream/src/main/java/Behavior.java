import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class Behavior {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse("shop.xml");

    XPath xPath = XPathFactory.newInstance().newXPath();

    boolean doLoad = Boolean.parseBoolean(xPath.compile("/config/load/enabled").evaluate(doc));
    String loadFileName = xPath.compile("/config/load/fileName").evaluate(doc);
    String loadFormat = xPath.compile("/config/load/format").evaluate(doc);

    boolean doSave = Boolean.parseBoolean(xPath.compile("/config/save/enabled").evaluate(doc));
    String saveFileName = xPath.compile("/config/save/fileName").evaluate(doc);
    String saveFormat = xPath.compile("/config/save/format").evaluate(doc);

    boolean doLog = Boolean.parseBoolean(xPath.compile("/config/log/enabled").evaluate(doc));
    String logFileName = xPath.compile("/config/log/fileName").evaluate(doc);

    public Behavior() throws XPathExpressionException, IOException, SAXException, ParserConfigurationException {
    }
}
