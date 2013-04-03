package TestFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FontFrame extends JFrame{

	public static void main(String[] args)
	{
		FontFrame frame = new FontFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
		public FontFrame(){
			setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
			FontPanel panel = new FontPanel();
			add(panel);
		}
		
		private final int DEFAULT_WIDTH = 300;
		private final int DEFAULT_HEIGHT = 200;

	
	class FontPanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			String message = "您好！ Sgamerv";
			Font f = new Font("YouYuan",Font.BOLD,36);
			g2.setFont(f);
			
			//measure the size of message 
			FontRenderContext context = g2.getFontRenderContext();
			Rectangle2D bounds = f.getStringBounds(message,context);
			
			//set(x,y) = top left corner of text
			double x = (getWidth()-bounds.getWidth())/2;
			double y = (getHeight()-bounds.getHeight())/2;
			
			//add ascent to y to reach the baseline
			double ascent = -bounds.getY();
			double baseY = y + ascent;
			
			//draw the message
			g2.drawString(message, (int)x,(int)baseY);
			
			g2.setPaint(Color.GRAY);
			
			//draw the baseline
			g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
			//draw the enclosing rectangle
			Rectangle2D rect = new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
			g2.draw(rect);
		}
		
	}
}
