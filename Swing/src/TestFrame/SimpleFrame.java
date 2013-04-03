package TestFrame;
import javax.swing.*;

public class SimpleFrame extends JFrame{
	public static void main(String[] args){
		SimpleFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(400,400);
	}
	
	public SimpleFrame(){
		setSize(WIDTH,HEIGHT);
	}
	
	private final int WIDTH = 300;
	private final int HEIGHT = 200;
}
