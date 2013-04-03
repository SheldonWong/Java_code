package Thread;

public class Threadtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedMethod runMethod1 = new SynchronizedMethod();
		SynchronizedMethod runMethod2 = new SynchronizedMethod();
		(new Thread(runMethod1)).start();
		(new Thread(runMethod2)).start();
		(new Thread(runMethod2)).start();
	}

}
