package arithmetic;

public class ControlCPU {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final double SPLIT = 0.01;
		final int COUNT = (int)(2/SPLIT);
		final double PI = Math.PI;
		final int INTERVAL = 100;
		final int half = INTERVAL/2;
		long[] busySpan = new long[COUNT];
		long[] idleSpan = new long[COUNT];
		double radium =0.0;
		for(int i=0;i<COUNT;i++){
			busySpan[i]=(long) (half+Math.sin(PI*radium)*half);
			idleSpan[i] = INTERVAL - busySpan[i];		
			radium+=SPLIT;
		}
		
		int index = 0;
		while(true){
			index = index % COUNT;
			long start = System.currentTimeMillis();
			while((System.currentTimeMillis()-start) < 15);
			try{
				Thread.sleep(15);
			}catch(Exception e){
				e.printStackTrace();
			}
			index++;
		}
	}

}
