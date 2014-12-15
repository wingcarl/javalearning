package base;

/**
 * 线程局部变量类 内部是一个Map key：对应的线程 value:对应的值
 * @author dell-pc
 *
 */
public class ThreadLocalDemo {

	public static void main(String[] args){
		ThreadLocal tlocal = new ThreadLocal();
		tlocal.set("pp");
		
		new AnotherThread(tlocal).start();  //传入另外一个线程时内容为空
		Object obj = tlocal.get();
		System.out.println(obj);
	}
}
