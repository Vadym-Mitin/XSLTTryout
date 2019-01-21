package org.wte;

import javax.xml.transform.TransformerException;

import static org.wte.Transformator.doTransform;

/**
 * @author Vadym Mitin
 */
public class TransformJS {
    public static void main(String[] args) throws TransformerException {
        String surcePath = "E:\\javaProjects\\XSLTTryout\\src\\main\\excluded\\";
        String src = surcePath + "ALLSFunctTest_in.xml";
        String xsl = surcePath + "ALLSFunctTest.xsl";
        String out = surcePath + "ALLSFunctTest_out.xml";

        doTransform(xsl, src, out);
    }
}
