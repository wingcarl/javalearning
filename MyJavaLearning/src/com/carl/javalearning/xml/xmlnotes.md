#XML

##����

<�ַ����� &#~ʮ������ &#x~ʮ��������  
<ʵ������ &lt; &gt; &amp; &quot; &apos;  
<![CDATA[ ]]>���п��԰���><&���ַ�

##����XML�ĵ�

<��ΪDOM����/SAX������DOM�����ʺ��ĵ���С�������ȫ�����ص��ڴ����С�SAX�ʺϴ���ܳ����ĵ�������ֻ��ĳЩԪ�ظ���Ȥ�����������ǵ������ġ�  
```DocumentBuilderFactory factory = new DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(u)

##XPath  
XPathFactory xpfactory = XPathFactory.newInstance();
path = xpfactory.newXPath();
String username = path.evaluate("/configuration/database/username",doc) //XPathConstants.NODESET