package TestFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class DrawFrame extends JFrame{
	public static void main(String[] args){
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public DrawFrame(){
		setSize(400,400);
		DrawPanel drawPanel = new DrawPanel();
		drawPanel.setBackground(Color.gray);
		add(drawPanel);
	}
	
	public class DrawPanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			
			//draw a rectangle
			double leftX = 100;
			double topY = 100;
			double width = 200;
			double height = 150;
			
			Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
			g2.setPaint(Color.blue);
			g2.fill(rect);
			
			//draw the enclosed ellipse
			Ellipse2D ellipse = new Ellipse2D.Double();
			ellipse.setFrame(rect);
			g2.setPaint(Color.red);
			g2.fill(ellipse);
			
			//draw a diagonal line
			g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));
			
			//draw a circumcircle
			double centerX = rect.getCenterX();
			double centerY = rect.getCenterY();
			double radius = Math.sqrt(Math.pow(width,2)+Math.pow(height, 2))/2;
			Ellipse2D circle = new Ellipse2D.Double(centerX-radius,centerY-radius,2*radius,2*radius);
			g2.draw(circle);		
		}
		
	}

}
