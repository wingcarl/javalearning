package base;

/**
 * �ֲ߳̾������� �ڲ���һ��Map key����Ӧ���߳� value:��Ӧ��ֵ
 * @author dell-pc
 *
 */
public class ThreadLocalDemo {

	public static void main(String[] args){
		ThreadLocal tlocal = new ThreadLocal();
		tlocal.set("pp");
		
		new AnotherThread(tlocal).start();  //��������һ���߳�ʱ����Ϊ��
		Object obj = tlocal.get();
		System.out.println(obj);
	}
}
