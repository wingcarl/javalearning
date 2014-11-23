package com.carl.javalearning.IO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.*;

/**
 * 迭代查看某路径下的文件夹，子文件夹等
 * 需要使用Files.walkFileTree 并创建一个SimpleFileVisitor<Path>对象，重载其中的visitFile(path,文件属性） visitFile(path,IOException)
 * @author dell-pc
 *
 */
public class TestWalkFileTree {
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
