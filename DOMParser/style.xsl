
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
  <xsl:output method="text" omit-xml-declaration="yes" indent="no"/>

  <xsl:template match="/"> 
    <xsl:text>id, author,title,genre,price,publish_date,description&#xA;</xsl:text>
    <xsl:for-each select="//book">
       <xsl:value-of select="substring-after(@id,'bk')" >
      </xsl:value-of>
      <xsl:text>,</xsl:text>
      <xsl:apply-templates select="author" />
      <xsl:text>,</xsl:text>
	  <xsl:apply-templates select="title" />
      <xsl:text>,</xsl:text>
	  <xsl:apply-templates select="genre" />
      <xsl:text>,</xsl:text>
	  <xsl:apply-templates select="price" />
      <xsl:text>,</xsl:text>
	  <xsl:apply-templates select="publish_date" />
      <xsl:text>,</xsl:text>
      <xsl:apply-templates select="description" />
      <xsl:text>&#xA;</xsl:text> 
    </xsl:for-each>
  </xsl:template>

   <xsl:template match="*[contains(., ',')] | text()" >
    <xsl:text>"</xsl:text>
    <xsl:value-of select="." />
    <xsl:text>"</xsl:text>
  </xsl:template> 
  

</xsl:stylesheet> 