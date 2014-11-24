#IO��#
##1.4 Zip�ĵ�##
> ZipInputStream ӵ�� ZipEntry
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

##1.5 �����������л�##
>Ϊ�˱���������ݣ�������Ҫ��һ��*ObjectOutputStream/ObjectInputStream*  
֮��ʹ��writeObject/readObjectֱ��д��/����   
>**ϣ������ʹ�����л�����ʵ��Serializable�ӿ�**  
>serial�Ĵ�С��ͬ������Ҫ�ظ�ȥ��������  
>**���к�ͬ�����ڲ�ͬ����֮���ͨ�ţ������кŴ����ڴ��ַ**  
>���ϣ��ĳ�������������л��������Ϊtransient  

##1.6 �����ļ�
>JAVA SE7 �������Path��Files�������������������ļ�  
>> Paths.get("/home","cay") --/home/cay
basePath.resolve(workRelative) ���ӳ�·��  
p.relativize(r) ������·��q����pΪĿ�꣬��r������Ի�������  
>>Files�ĳ��ò���   
```byte[] bytes = Files.readAllBytes(path) //���ļ��е��������ݶ����뵽byte[]������  
```String content = new String(bytes,charset) //��bytes����ת��Ϊ�ַ���  
```List<String> lines = Files.readAllLines(path,charset)//���ļ����������ж���  
```Files.write(path,content.getBytes(charSet)) //���ַ���д���ļ�  
```Files.write(path,content.getBytes(charset),StandardOpenOption.APPEND) //���ļ�׷������  
>>���ļ��ϴ� ����Ҫʹ����������� Files.newInputStream(path)  
```Files.copy(src,det) Files.move(src,det)    
```StandardCopyOption.REPLACE_EXISTING StandardCopyOption.COPY_ATTRIBUTES  StandardCopyOption.ATOMIC_MOVE  
>>����Ŀ¼  
```Files.createDirectory(path); Files.createDirectories(path); Files.createFile(path);  
>>�����ļ�
```Files.createFile(path)  Files.createTempFile(dir,prefix,suffix)  
>>��ȡ�ļ���Ϣ
```exists isHidden isReadable isRegularFile isDirectory...  
```Files.size(path) �����ļ����ֽ���
>>����Ŀ¼�е��ļ�
```try(DirectoryStream<Path> entries = Files.newDirectoryStream(dir,"*.java")){
	for(Path entry:entries)
		Process entries
}
```/**
 * �����鿴ĳ·���µ��ļ��У����ļ��е�
 * ��Ҫʹ��Files.walkFileTree ������һ��SimpleFileVisitor<Path>�����������е�visitFile(path,�ļ����ԣ� visitFile(path,IOException)
 * @author dell-pc
 *
 */
```public class TestWalkFileTree {
	public static void main(String[] args) throws IOException{
		Path dir = Paths.get("E:\\","vm","05");
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>(){
			public FileVisitResult visitFile(Path path,BasicFileAttributes attrs){
				System.out.println(path);
				return FileVisitResult.CONTINUE;
			}
			public FileVisitResult vistFileFailed(Path path,IOException exc) throws IOException{
				return FileVisitResult.CONTINUE;
			}
		});
	}
}  
>>ZIP�ļ�ϵͳ  
```FileSystem fs = FileSystems.newFileSystem(Paths.get(zipname),null)  
```Files.copy(fs.getPath(sourceName),targetPath)  
```Files.walkFileTree(fs.getPath("/",new SimpleFileVisitor<Path>(){  
	public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) throws IOException
	{
		System.out.println(file);
		return FileVisitResult.CONTINUE;
	}
}

##1.8 ������ʽ  
``` Pattern pattern = Pattern.cmpile(patternString);
Macher matcher = pattern.matcher(input);
if(macher.matches())
