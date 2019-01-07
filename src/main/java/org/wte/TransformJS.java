package org.wte;

import javax.xml.transform.TransformerException;

import static org.wte.Transformator.doTransform;

/**
 * @author Vadym Mitin
 */
public class TransformJS {
    public static void main(String[] args) throws TransformerException {
        String xsl = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\local.xsl";
        String src = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\local.xml";
        String out = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\local-xslt-entyties-1-out.xml";

        doTransform(xsl, src, out);
    }
}
