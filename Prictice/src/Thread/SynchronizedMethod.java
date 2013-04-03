package Thread;

public class SynchronizedMethod implements Runnable{
	private int tickets =100;
	private boolean hasTicket = true;
	
	public void run(){
		while(hasTicket){
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		sale();
		}
		
	}
	public synchronized void sale(){
		if(tickets>0){
			System.out.println(Thread.currentThread().getName()+"sale ticket "+ tickets--);
		}else{
			hasTicket = false;
			System.out.println("Tickets have sold out!!");
		}
		
	}
}
