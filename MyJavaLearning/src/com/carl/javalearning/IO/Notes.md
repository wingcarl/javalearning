##Zip文档##
ZipInputStream 拥有 ZipEntry
====
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