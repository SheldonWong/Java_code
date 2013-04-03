package TestFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiCastFrame extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiCastFrame  frame = new MultiCastFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public MultiCastFrame()
	{
		setTitle("MultiCastFrame");
		setSize(300,200);
		MultiCastPanel panel = new MultiCastPanel();
		add(panel);
	}
	
	private class MultiCastPanel extends JPanel
	{
		 MultiCastPanel()
		{
			JButton newButton = new JButton("New");
			add(newButton);
			closeAllButton = new JButton("Close All");
			add(closeAllButton);
			ActionListener newListener = new ActionListener(){
				public void actionPerformed(ActionEvent event)
				{
					BlankFrame frame = new BlankFrame(closeAllButton);
					frame.setVisible(true);
				}
			};
			newButton.addActionListener(newListener);
		}
		 
     
	}
	
	private class BlankFrame extends JFrame
	{

		public BlankFrame(final JButton closeAllButton) {
			count++;
			setTitle("Blank frame "+count);
			setSize(100,100);
			setLocation(SPACING*count,SPACING*count);
			closeListener = new ActionListener(){
				public void actionPerformed(ActionEvent event)
				{
					closeAllButton.removeActionListener(closeListener);
					dispose();
				}
			};
			closeAllButton.addActionListener(closeListener);
		}
		
	}

	JButton closeAllButton;
	private static int count = 0;
	private final int SPACING = 40;
	private ActionListener closeListener;
}
