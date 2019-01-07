package org.wte;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author Vadym Mitin
 */
public class Transformator {

    public static void main(String[] args) throws TransformerException {
        String xsl = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-xslt.xsl";
        String src = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-src.xml";
        String out = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-out.xml";
        doTransform(xsl, src, out);
    }

    public static void doTransform(String xsl, String src, String out) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xsl));
        Transformer transformer = factory.newTransformer(xslt);
        Source text = new StreamSource(new File(src));
        transformer.transform(text, new StreamResult(new File(out)));
    }
}
