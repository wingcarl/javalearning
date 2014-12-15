package base;

public class AnotherThread extends Thread {

	private ThreadLocal tlocal ;
	public AnotherThread(ThreadLocal tlocal){
		this.tlocal = tlocal;
	}
	public void run(){
		System.out.println("another thread"+tlocal.get());
	}
}
