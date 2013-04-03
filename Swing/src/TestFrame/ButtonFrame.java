package TestFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame{
	
	public ButtonFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenX = (int)screenSize.getWidth();
		int screenY = (int)screenSize.getHeight();
		setLocation((screenX -DEFAULT_WIDTH)/2,(screenY - DEFAULT_HEIGHT)/2);
		ButtonPanel panel = new ButtonPanel();
		add(panel);
	}
	
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 300;
	
	class ButtonPanel extends JPanel
	{
		public ButtonPanel(){
			makeButton("Green",Color.green);
			makeButton("Blue",Color.blue);
			makeButton("Red",Color.red);
		}
		void makeButton(String name, final Color backgroundcolor)
		{
			JButton button = new JButton(name);
			add(button);
			button.addActionListener(new
					ActionListener()
					{
						public void actionPerformed(ActionEvent event) 
						{
							setBackground(backgroundcolor);
						}
						
					}
					);
		}
	}
	public static void main(String[] args)
	{
		ButtonFrame frame = new ButtonFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
