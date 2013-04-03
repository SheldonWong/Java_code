package TestFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafFrame extends JFrame{

	private final static int DEFAULT_WIDTH = 800;
	private final static int DEFAULT_HEIGHT = 200;
	public PlafFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		PlafPanel panel = new PlafPanel();
		add(panel);
	}
	
	class PlafPanel extends JPanel
	{
		public PlafPanel()
		{
			UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
			for(UIManager.LookAndFeelInfo info : infos)
			{
				makeButton(info.getName(),info.getClassName());
			}
		}
		
		public void makeButton(String name , final String plafName)
		{
			JButton button = new JButton(name);
			add(button);
			button.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					try{
						UIManager.setLookAndFeel(plafName);
						SwingUtilities.updateComponentTreeUI(PlafPanel.this);
					}catch(Exception e){
						
					}
				}
				
			});
		}
	}
	public static void main(String[] args)
	{
		PlafFrame frame = new PlafFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
