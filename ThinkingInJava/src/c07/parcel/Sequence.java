package c07.parcel;

public class Sequence {
	private Object[] obj;
	private int index=0;
	public Sequence(int i){
		obj = new Object[i];
	}
	public void add(Object o){
		obj[index] = o;
		index++;
	}
	private class SSelector implements Selector{
		int x =0,next=0;
		public Object nextObj() {
			boolean looped = false;
			int start = next;
			do {
			next = (next + 1) % obj.length;
			// See if it has looped to the beginning:
			if(start == next) looped = true;
			// If it loops past start, the list
			// is empty:
			if((next == (start + 1) % obj.length)
			&& looped)
			return null;
			} while(obj[next] == null);
			return obj[next];
		}
		
		public void removeCurrent() {
			obj[next] = null;
			}
	}
	
	public Selector getSelector(){
		return new SSelector();
	}
	
	public static void main(String[] args){
		Sequence objs = new Sequence(100);
		for(int i=0;i<100;i++){
			objs.add(Integer.toString(i));
		}
		Selector sel = objs.getSelector();
		Object o;
		while((o=sel.nextObj())!=null){
			System.out.println(o);
			sel.removeCurrent();
		}
			
	}
}

interface Selector {
	Object nextObj();
	void removeCurrent();
}