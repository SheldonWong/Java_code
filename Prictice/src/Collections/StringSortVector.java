package Collections;

import java.util.Vector;

public class StringSortVector extends Vector{
	private Compare compare;
	
	public StringSortVector(Compare comp){
		compare = comp;
	}
	
	public void sort(){
		quickSort(0,size()-1);
	}
	
	private void quickSort(int left,int right){
		if(left < right){
			int i = left-1;
			int j = right;
			Object rOb = elementAt(right);
			while(true){
				while(compare.lessThan(elementAt(++i), rOb));
				while(j>0)
					if(compare.lessOrEqual(elementAt(--j), rOb))
						break;
					if(i>=j)
						break;
					swap(i,j);				
			}
			swap(i,right);
			quickSort(left,i-1);
			quickSort(i+1,right);
		}
	}
	
	private void swap(int loc1, int loc2){
		Object tmp = elementAt(loc1);
		set(loc1,elementAt(loc2));
		set(loc2, tmp);
	}
}
