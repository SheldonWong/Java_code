package sgamerv.study.finalize;

public class Cleaner extends Thread {
    static int counter = 0;
    int id = counter++;
    public Cleaner() {
        start();
    }

    public void run() {
        try {
          sleep(8000);//改变时间以查看在不同时间调用runFinalization（）和gc（）的效果
        } catch(InterruptedException e) {
        }
        System.out.println("Cleaner " + id + " run");
        //System.runFinalization();//调用已经失去引用的对象的finalize方法
        System.gc(); //告诉垃圾收集器打算进行垃圾收集，而垃圾收集器进不进行收集是不确定的
        System.runFinalization();//调用已经失去引用的对象的finalize方法
    }
}

