#IO流#
##1.4 Zip文档##
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

##1.5 对象流与序列化##
>为了保存对象数据，首先需要打开一个*ObjectOutputStream/ObjectInputStream*  
之后使用writeObject/readObject直接写入/读出   
>**希望对象使用序列化必须实现Serializable接口**  
>serial的大小相同，则不需要重复去创建对象。  
>**序列号同样用于不同机器之间的通信，用序列号代替内存地址**  
>如果希望某个变量不被序列化，则将其标为transient  

##1.6 操作文件
>JAVA SE7 新添加了Path和Files这两个类来帮助操作文件  
>> Paths.get("/home","cay") --/home/cay
basePath.resolve(workRelative) 连接成路径  
p.relativize(r) 将产生路径q（以p为目标，对r进行相对化操作）  
>>Files的常用操作   
```byte[] bytes = Files.readAllBytes(path) //将文件中的所有内容都读入到byte[]数组中  
```String content = new String(bytes,charset) //将bytes数组转换为字符串  
```List<String> lines = Files.readAllLines(path,charset)//将文件当作行序列读入  
```Files.write(path,content.getBytes(charSet)) //将字符串写入文件  
```Files.write(path,content.getBytes(charset),StandardOpenOption.APPEND) //向文件追加内容  
>>若文件较大 则还是要使用输入输出流 Files.newInputStream(path)  
```Files.copy(src,det) Files.move(src,det)    
```StandardCopyOption.REPLACE_EXISTING StandardCopyOption.COPY_ATTRIBUTES  StandardCopyOption.ATOMIC_MOVE  
>>创建目录  
```Files.createDirectory(path); Files.createDirectories(path); Files.createFile(path);  
>>创建文件
```Files.createFile(path)  Files.createTempFile(dir,prefix,suffix)  
>>获取文件信息
```exists isHidden isReadable isRegularFile isDirectory...  
```Files.size(path) 返回文件的字节数
>>迭代目录中的文件
```try(DirectoryStream<Path> entries = Files.newDirectoryStream(dir,"*.java")){
	for(Path entry:entries)
		Process entries
}
```/**
 * 迭代查看某路径下的文件夹，子文件夹等
 * 需要使用Files.walkFileTree 并创建一个SimpleFileVisitor<Path>对象，重载其中的visitFile(path,文件属性） visitFile(path,IOException)
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
>>ZIP文件系统  
```FileSystem fs = FileSystems.newFileSystem(Paths.get(zipname),null)  
```Files.copy(fs.getPath(sourceName),targetPath)  
```Files.walkFileTree(fs.getPath("/",new SimpleFileVisitor<Path>(){  
	public FileVisitResult visitFile(Path file,BasicFileAttributes attrs) throws IOException
	{
		System.out.println(file);
		return FileVisitResult.CONTINUE;
	}
}

##1.8 正则表达式  
``` Pattern pattern = Pattern.cmpile(patternString);
Macher matcher = pattern.matcher(input);
if(macher.matches())
