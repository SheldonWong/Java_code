package c08.dataStructure;

import java.util.Hashtable;

public class Statistics {
	private int seed = 20;
	private int test_times =100000;
	/*Statistics(){
		//Hashtable hs = new Hashtable();
	}*/
	public void setSeed(int num){
		seed = num;
	}
	public void setTimes(int times){
		test_times = times;
	}
	public void run(){
		Hashtable hs = new Hashtable();
		for(int i=0;i<test_times;i++){
			Integer rand = new Integer((int)(Math.random()*seed));
			if(hs.containsKey(rand))
				((Counter)hs.get(rand)).add();
			else
				hs.put(rand, new Counter());
		}
		System.out.println(hs);
	}
	public static void main(String[] args) {
		Statistics st = new Statistics();
		st.run();

	}

}
