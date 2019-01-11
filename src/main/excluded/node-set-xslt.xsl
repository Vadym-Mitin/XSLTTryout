<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:exsl="http://exslt.org/common"
                extension-element-prefixes="exsl"
                version="1.0">

    <xsl:variable name="variable_author">
        <firstname>Jirka</firstname>
        <surname>Kosek</surname>
        <email>jirka@kosek.cz</email>
    </xsl:variable>

    <xsl:variable name="xml">
        <xsl:apply-templates mode="copy-no-ns" select="/"/>
    </xsl:variable>

    <xsl:template match="/">
        <xsl:element name="element">
            <xsl:element name="author">
                <xsl:apply-templates select="exsl:node-set($variable_author)" mode="copy-no-ns"/>
            </xsl:element>
            <xsl:element name="from_src">
                <xsl:apply-templates select="exsl:node-set($xml)/author/email"/>
            </xsl:element>
        </xsl:element>
    </xsl:template>

    <xsl:template mode="copy-no-ns" match="*">
        <xsl:element name="{name()}">
            <xsl:copy-of select="@*"/>
            <xsl:apply-templates mode="copy-no-ns"/>
        </xsl:element>
    </xsl:template>

    <xsl:template match="email">
        <xsl:element name="email">
            <xsl:apply-templates/>
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>