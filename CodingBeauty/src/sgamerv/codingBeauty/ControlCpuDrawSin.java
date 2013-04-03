package sgamerv.codingBeauty;

public class ControlCpuDrawSin {
	public static void main(String[] args) throws InterruptedException{
		final double SPLIT=0.01;
		final int COUNT =(int)(2/SPLIT);
		final int INTERVAL=200;
		final double PI=Math.PI;
		long[] busyspan = new long[COUNT];
		long[] idlespan = new long[COUNT];
		int half = INTERVAL/2;
		double radian =0.0;
		for(int i=0;i<COUNT;i++){
			busyspan[i] = (long)(half - Math.sin(radian)*half);
			idlespan[i] = INTERVAL -busyspan[i];
			radian += PI*SPLIT;
		}
		long startTime = 0;
		int j =0;
		while(true){
			j=j%COUNT;
			startTime = System.currentTimeMillis();
			while(System.currentTimeMillis()-startTime<busyspan[j]);
			Thread.sleep(idlespan[j]);
			j++;
		}
		
	}
}
