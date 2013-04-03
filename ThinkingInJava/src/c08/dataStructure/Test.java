package c08.dataStructure;

import java.util.Vector;

public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntegerCompare intCompare =new IntegerCompare(); 
		SortVector sv = new SortVector(intCompare);
		for(int i=0;i<100000;i++)
			sv.addElement((Integer)((int)(Math.random()*100000)));
		System.out.println(sv.elementAt(99999));
		sv.sort();
		System.out.println(sv.elementAt(99999));
	}
}
