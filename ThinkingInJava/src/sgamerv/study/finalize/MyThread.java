package sgamerv.study.finalize;

public class MyThread extends Thread {
    static int counter = 0;
    int id = counter++;
    public MyThread() {
        System.out.println("Constructing thread "+id);
        start();
    }

    public void run() {
        for(int i = 0; i < 3; i++) {
          System.out.println("Basic Thread " + id
            + " Loop " + i);
          try {
            sleep(2000);
          } catch(InterruptedException e) {
          }
        }
    }

    protected void finalize() {
        System.out.println("Basic myThread " + id + " Finalize");
    }    

    public static void main(String args[]) throws InterruptedException {
            for(int i = 0; i < 5; i++) {
              new MyThread();
              new Cleaner();
              sleep(1000);
            }          
        }
}
