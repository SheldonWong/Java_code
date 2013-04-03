package c08.dataStructure;

public class Counter {
	private int count = 0;
	public String toString(){
		return Integer.toString(count);
	}
	public void add(){
		count++;
	}
}
