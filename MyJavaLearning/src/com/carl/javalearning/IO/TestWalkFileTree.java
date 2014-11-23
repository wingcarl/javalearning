package com.carl.javalearning.IO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.*;

/**
 * �����鿴ĳ·���µ��ļ��У����ļ��е�
 * ��Ҫʹ��Files.walkFileTree ������һ��SimpleFileVisitor<Path>�����������е�visitFile(path,�ļ����ԣ� visitFile(path,IOException)
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
