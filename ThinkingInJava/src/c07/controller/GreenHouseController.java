package c07.controller;

public class GreenHouseController extends Controller{
	
	private boolean light = false;
	private boolean water = false;
	private String thermostat = "Day";
	
	private class LightOn extends Event{
		public LightOn(long eventTime) {
			super(eventTime);
		}
		@Override
		public void action() {
			light = true;			
		}
		@Override
		public String description() {			
			return "Light is on";
		}		
	}
	
	private class LightOff extends Event{

		public LightOff(long eventTime) {
			super(eventTime);
		}
		@Override
		public void action() {
			light = false;		
		}

		@Override
		public String description() {
			return "Light is off";
		}		
	}
	
	private class WaterOn extends Event{

		public WaterOn(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			water = true;
			
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Greenhouse water is on";
		}
		
	}
	
	private class WaterOff extends Event{

		public WaterOff(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			water = false;
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Greenhouse water is off";
		}
		
	}
	
	private class ThermostatNight extends Event{

		public ThermostatNight(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			thermostat = "Night";
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Thermostat on night setting";
		}
		
	}
	
	private class ThermostatDay extends Event{

		public ThermostatDay(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			thermostat = "Day";
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Thermostat on day setting";
		}
		
	}
	
	private int rings;
	private class Bell extends Event{

		public Bell(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			System.out.println("Bing~~");
			if(--rings>0)
				addEvent(new Bell(System.currentTimeMillis()+2000));
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Ring bell";
		}
		
	}
	
	private class Restart extends Event{

		public Restart(long eventTime) {
			super(eventTime);
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			long tm = System.currentTimeMillis();
			rings = 5;
			addEvent(new ThermostatNight(tm));
			addEvent(new LightOn(tm + 1000));
			addEvent(new LightOff(tm + 2000));
			addEvent(new WaterOn(tm + 3000));
			addEvent(new WaterOff(tm + 8000));
			addEvent(new Bell(tm + 9000));
			addEvent(new ThermostatDay(tm + 10000));
			addEvent(new Restart(tm + 20000));
		}

		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Restarting System";
		}		
	}
	Event e = new Restart(10000);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreenHouseController gc = new GreenHouseController();
		long tm = System.currentTimeMillis();	
		gc.addEvent(gc.new Restart(tm));
		gc.run();
	}

}
