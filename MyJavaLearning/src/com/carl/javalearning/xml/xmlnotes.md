#XML

##概述

<字符引用 &#~十进制数 &#x~十六进制数  
<实体引用 &lt; &gt; &amp; &quot; &apos;  
<![CDATA[ ]]>其中可以包含><&等字符

##解析XML文档

<分为DOM解析/SAX解析（DOM解析适合文档较小的情况，全部加载到内存树中。SAX适合处理很长的文档，或者只对某些元素感兴趣而不关心它们的上下文。  
```DocumentBuilderFactory factory = new DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(u)

##XPath  
XPathFactory xpfactory = XPathFactory.newInstance();
path = xpfactory.newXPath();
String username = path.evaluate("/configuration/database/username",doc) //XPathConstants.NODESET