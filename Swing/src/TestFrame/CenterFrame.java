package TestFrame;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

public class CenterFrame extends JFrame{

	public static void main(String[] args){
		CenterFrame frame = new CenterFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public CenterFrame(){
		//get screen dimension
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		//center frame in screen
		setSize(screenWidth/2,screenHeight/2);
		setLocation(screenWidth/4,screenHeight/4);
		
		//set frame icon and title
		Image img = kit.getImage("F:/terry/java_code/Swing/src/TestFrame/test.png");
		setIconImage(img);
		setTitle("CenterFrame");
		
		NotHelloWorld panel = new NotHelloWorld();
		add(panel);
		
	}
	
	class NotHelloWorld extends JPanel{
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawString("Not a Hello, World program!", MESSAGE_X, MESSAGE_y);
		}
		
		private final int MESSAGE_X = 150;
		private final int MESSAGE_y = 100;
		
	}
	
}
