package c07.controller;

public class Controller {
	private EventSet eSet= new EventSet();
	public void addEvent(Event c){
		eSet.add(c);
	}
	public void run(){
		Event e;
		while((e=eSet.genNext()) != null){
			if(e.ready()){
				e.action();
				System.out.println(e.description());
				eSet.removeCurrent();
			}			
		}			
	}
}
