package Collections;

import java.util.Enumeration;

public class testSort {

	private static class StringCompare implements Compare{

		@Override
		public boolean lessThan(Object l, Object r) {
			return ((String)l).toLowerCase().compareTo(((String)r).toLowerCase()) < 0;
		}

		@Override
		public boolean lessOrEqual(Object l, Object r) {
			return ((String)l).toLowerCase().compareTo(((String)r).toLowerCase()) <= 0;
		}
		
	}
	public static void main(String[] args) {
		StringSortVector v = new StringSortVector(new StringCompare());
		v.add("E");
		v.add("C");
		v.add("N");
		v.add("P");
		v.add("a");
		v.add("i");
		v.add("h");
		v.sort();
		Enumeration eV = v.elements();
		while(eV.hasMoreElements())
			System.out.println(eV.nextElement());
	}

}
