package c07.controller;

public class EventSet {
	private Event[] events = new Event[100];
	private int index = 0;
	private int next = 0;
	public void add(Event e){
		if(index >= events.length)
			return;
		events[index++] = e;
	}
	public Event genNext(){
		boolean looped = false;
		int start = next;
		do{
			next = (next+1) % events.length;
			if(next == start)
				looped = true;
			if((next == (start+1)%events.length) && looped)
				return null;
		}while(events[next] == null);
			return events[next];
	}
	
	public void removeCurrent(){
		System.out.println("Event.No:"+next);
		events[next] = null;
	}
}

