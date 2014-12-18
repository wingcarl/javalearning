文件上传的前提
a.form表单的method必须是post
b.form表单的enctype必须是multipart/form-data
c.input的type是file类型

commons-fileupload组件 依赖于commons-io

DiskFileItemFactory
setSizeThreshold(设置缓冲区大小，默认为10KB)(,)两个参数分别为缓冲区大小和缓存路径
当超过缓冲区大小，将使用临时文件缓存上传文件，默认为系统默认的临时文件目录
ServletFileUpload 核心上传类
 boolean isMultipartContent(request) 
 判断enctype是否为multipart/form-data类型
 List parseRequest 解析正文内容

FileItem 代表表单的一个输入域
isFormFiled/
getFiledName()获取普通字段的字段名/
getString()获取普通字段的值
getInputStream()获取上传字段的输入流/
getName():获取上传文件名

文件上传的9大问题
1.如何保证文件的安全
把保存上传文件的目录放到WEB-INF目录中
2.中文乱码问题
	2.1普通字段的中文请求参数
		FileItem.getString("UTF-8")
	2.2上传的文件名是中文问题
		request.setCharacterEncoding("UTF-8")
3.重名文件被覆盖的问题
	System.currentMillions()+"_"+a.txt
	UUID+"_"+a.txt:保证文件名唯一
4.分目录存储上传文件
	1.利用日期建立文件夹
	2.利用哈希表的哈希码来打散
5.限制用户的文件上传类型
	通过判断其mime类型，才靠谱
	String mimeType = item.getContentType();
6.限制用户的上传文件大小
	1.单个文件大小限制 友好提示
	2.总文件大小限制 友好提示
7.临时文件的问题
	
9.上传进度检测;