�ļ��ϴ���ǰ��
a.form����method������post
b.form����enctype������multipart/form-data
c.input��type��file����

commons-fileupload��� ������commons-io

DiskFileItemFactory
setSizeThreshold(���û�������С��Ĭ��Ϊ10KB)(,)���������ֱ�Ϊ��������С�ͻ���·��
��������������С����ʹ����ʱ�ļ������ϴ��ļ���Ĭ��ΪϵͳĬ�ϵ���ʱ�ļ�Ŀ¼
ServletFileUpload �����ϴ���
 boolean isMultipartContent(request) 
 �ж�enctype�Ƿ�Ϊmultipart/form-data����
 List parseRequest ������������

FileItem �������һ��������
isFormFiled/
getFiledName()��ȡ��ͨ�ֶε��ֶ���/
getString()��ȡ��ͨ�ֶε�ֵ
getInputStream()��ȡ�ϴ��ֶε�������/
getName():��ȡ�ϴ��ļ���

�ļ��ϴ���9������
1.��α�֤�ļ��İ�ȫ
�ѱ����ϴ��ļ���Ŀ¼�ŵ�WEB-INFĿ¼��
2.������������
	2.1��ͨ�ֶε������������
		FileItem.getString("UTF-8")
	2.2�ϴ����ļ�������������
		request.setCharacterEncoding("UTF-8")
3.�����ļ������ǵ�����
	System.currentMillions()+"_"+a.txt
	UUID+"_"+a.txt:��֤�ļ���Ψһ
4.��Ŀ¼�洢�ϴ��ļ�
	1.�������ڽ����ļ���
	2.���ù�ϣ��Ĺ�ϣ������ɢ
5.�����û����ļ��ϴ�����
	ͨ���ж���mime���ͣ��ſ���
	String mimeType = item.getContentType();
6.�����û����ϴ��ļ���С
	1.�����ļ���С���� �Ѻ���ʾ
	2.���ļ���С���� �Ѻ���ʾ
7.��ʱ�ļ�������
	
9.�ϴ����ȼ��;