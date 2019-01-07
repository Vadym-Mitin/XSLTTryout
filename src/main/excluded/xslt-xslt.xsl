<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="node()">

        <xsl:copy>
            <xsl:apply-templates select="node()"/>
            <!--<xsl:apply-templates select="node()"/>-->
        </xsl:copy>
    </xsl:template>
    <!--<xsl:template match="author">-->
    <!--<xsl:element name="{local-name(.)}">-->
    <!--<xsl:value-of select="."/>-->
    <!--</xsl:element>-->
    <!--</xsl:template>-->

</xsl:stylesheet>