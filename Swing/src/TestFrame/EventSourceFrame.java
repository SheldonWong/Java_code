package TestFrame;

import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventSourceFrame extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public EventSourceFrame()
	{
		setTitle("EventSourceTest");
		setSize(300,200);
		PaintCountPanel panel = new PaintCountPanel();
		add(panel);
		panel.addPropertyChangeListener(new
				PropertyChangeListener()
				{
					public void propertyChange(PropertyChangeEvent event)
					{
						setTitle("EventSourceTest - "+ event.getNewValue());
					}
				}
				);
	}
	
	private class PaintCountPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			
		}
		
		public void addPropertyChangeListener(PropertyChangeListener listener)
		{
			listenerList.add(PropertyChangeListener.class, listener);
		}
		
		public void removePropertyChangeListener(PropertyChangeListener listener)
		{
			listenerList.remove(PropertyChangeListener.class, listener);
		}
		
		public void firePropertyChangeEvent(PropertyChangeEvent event)
		{
			EventListener[] listeners = listenerList.getListeners(PropertyChangeListener.class);
			
		}
	}
	
	

}
