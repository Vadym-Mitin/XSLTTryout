package org.wte;

import javax.xml.transform.TransformerException;

import static org.wte.Transformator.doTransform;

/**
 * @author Vadym Mitin
 */
public class TransformToNames {
    public static void main(String[] args) throws TransformerException {
        String xsl = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-form-path-from-parents.xsl";
        String src = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-out.xml";
        String out = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\xslt-form-path-from-parents-out.xml";

        doTransform(xsl, src, out);
    }
}
