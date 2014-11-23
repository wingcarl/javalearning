####IO流####
##1.4Zip文档##
> ZipInputStream 拥有 ZipEntry
> 通过分析ZipEntry的类型，可以执行相应的操作提取
```
ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
ZipEntry entry;
while((entry = zin.getNextEntry()) != null{
}
zip.close()
```
> ZipOutputStream创建时通过参数为FileOutputStream
并且需要指定ZipEntry
```
FileOutputStream fout = new FileOutputStream("test.zip")
ZipOutputStream zout = new ZipOutputStream(fout);
{
	ZipEntry ze = new ZipEntry(filename);
	zout.putNextEntry(ze);
	zout.close();
}
```
##1.5对象流与序列化##
>为了保存对象数据，首先需要打开一个*ObjectOutputStream/ObjectInputStream*
之后使用writeObject/readObject直接写入/读出
**希望对象使用序列化必须实现Serializable接口**
serial的大小相同，则不需要重复去创建对象。
**序列号同样用于不同机器之间的通信，用序列号代替内存地址**
如果希望某个变量不被序列化，则将其标为transient