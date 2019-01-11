<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:a="http://www.a.com"
                xmlns:b="http://www.b.com">
    <xsl:output indent="yes"/>

    <xsl:template match="*">
        <element name="{name()}" namespace-uri="{namespace-uri()}" local-name="{local-name()}">
            <xsl:apply-templates/>
        </element>
    </xsl:template>

    <!--<xsl:template match="*">-->
    <!--<xsl:element name="{name()}" >-->
    <!--<xsl:attribute name="namespace-uri">-->
    <!--<xsl:value-of select="namespace-uri()"/>-->
    <!--</xsl:attribute>-->
    <!--<xsl:attribute name="local-name">-->
    <!--<xsl:value-of select="local-name()"/>-->
    <!--</xsl:attribute>-->
    <!--<xsl:apply-templates/>-->
    <!--</xsl:element>-->
    <!--</xsl:template>-->

</xsl:stylesheet>