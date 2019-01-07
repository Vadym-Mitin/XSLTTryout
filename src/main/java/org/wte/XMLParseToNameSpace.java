package org.wte;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Vadym Mitin
 */
public class XMLParseToNameSpace {
    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-out.xml");
            Node root = document.getDocumentElement();

            StringBuilder result = new StringBuilder();
            result.append("<form>")
                    .append("<fields>");
            getPath(root, null, result);
            result.append("</fields>")
                    .append("</form>");

            File file = new File("E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-form-path-from-parents-java-out.xml");
            FileWriter fw = new FileWriter(file);
            fw.write(result.toString());
            fw.close();

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static void getPath(Node node, String path, StringBuilder sb) {
        if (node.getNodeType() != Node.TEXT_NODE) {
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                String currentPath;
                if (null != path) {
                    currentPath = path + "." + node.getNodeName();
                } else currentPath = node.getNodeName();

                getPath(childNodes.item(j), currentPath.toUpperCase(), sb);
            }
        } else {
            String nodeTextContent = node.getTextContent().replace("\n", "").replace(" ", "");
            if (!nodeTextContent.isEmpty()) {
                sb.append("<field name=")
                        .append("\"")
                        .append(path)
                        .append("\"")
                        .append(" value=")
                        .append("\"")
                        .append(node.getTextContent())
                        .append("\"")
                        .append(" />")
                        .append("\n");
            }
        }
    }
}
