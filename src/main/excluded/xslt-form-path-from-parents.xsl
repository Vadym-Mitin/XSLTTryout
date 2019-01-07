<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output omit-xml-declaration="yes"/>
    <xsl:output indent="yes"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="/">
        <xsl:element name="form">
            <xsl:element name="fields">
                <!--Select all the elements contains text-->
                <xsl:for-each select=".//*[string-length(normalize-space(text())) > 0]">
                    <xsl:call-template name="printElement"/>
                </xsl:for-each>
            </xsl:element>
        </xsl:element>
    </xsl:template>

    <xsl:template name="printElement">
        <xsl:variable name="getCurrentValue">
            <xsl:value-of select="normalize-space(.)"/>
        </xsl:variable>
        <xsl:variable name="formParentsPath">
            <!--Select parents list of current element-->
            <xsl:for-each select="ancestor-or-self::*">
                <!--Concatenate the name of the current element with delimiter with condition-->
                <xsl:choose>
                    <xsl:when test="position() = last()">
                        <xsl:value-of select="name(.)"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="concat(name(.),'.')"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </xsl:variable>
        <!--wrapping received values with necessary tags-->
        <xsl:element name="field">
            <xsl:attribute name="name">
                <xsl:value-of select="$formParentsPath"/>
            </xsl:attribute>
            <xsl:attribute name="value">
                <xsl:value-of select="$getCurrentValue"/>
            </xsl:attribute>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>