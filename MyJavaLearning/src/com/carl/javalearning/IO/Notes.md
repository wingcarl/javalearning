##Zip�ĵ�##
ZipInputStream ӵ�� ZipEntry
====
> ͨ������ZipEntry�����ͣ�����ִ����Ӧ�Ĳ�����ȡ
```
ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
ZipEntry entry;
while((entry = zin.getNextEntry()) != null{
}
zip.close()
```
> ZipOutputStream����ʱͨ������ΪFileOutputStream
������Ҫָ��ZipEntry
```
FileOutputStream fout = new FileOutputStream("test.zip")
ZipOutputStream zout = new ZipOutputStream(fout);
{
	ZipEntry ze = new ZipEntry(filename);
	zout.putNextEntry(ze);
	zout.close();
}
```