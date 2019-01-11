package org.wte;

import javax.xml.transform.TransformerException;

import static org.wte.Transformator.doTransform;

/**
 * @author Vadym Mitin
 */
public class TransformNodeSet {

    public static void main(String[] args) throws TransformerException {
        String surcePath = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\";
        String xsl = surcePath + "node-set-xslt.xsl";
        String src = surcePath + "node-set-xslt-in.xml";
        String out = surcePath + "node-set-xslt-out.xml";

        doTransform(xsl, src, out);
    }
}
