package TestFrame;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseTest extends JFrame{
	
	public static void main(String[] args)
	{
		MouseTest frame = new MouseTest();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public MouseTest(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		MousePanel panel = new MousePanel();
		add(panel);
	}
	
	private final static int DEFAULT_WIDTH = 400;
	private final static int DEFAULT_HEIGHT = 300;
	
	private class MousePanel extends JPanel
	{		 
		public MousePanel()
		{
			RecList = new ArrayList<Rectangle2D>();
			setFocusable(true);
			addMouseListener(new MouseHandler());
			addMouseMotionListener(new MouseMotionHandler());
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			for(Rectangle2D r : RecList)
			{
				g2.draw(r);
			}
		}
		
		public void add(Point2D p)
		{
			double x = p.getX();
			double y = p.getY();
			Rectangle2D r = new Rectangle2D.Double(x-SIDELENTH/2,y-SIDELENTH/2,SIDELENTH,SIDELENTH);
			RecList.add(r);
			repaint();
		}
		
		public void remove(Rectangle2D r)
		{
			if(r == null) return;
			if(r == current) current = null;
			RecList.remove(r);
			repaint();
		}
		
		public Rectangle2D find(Point2D p){
			for(Rectangle2D r : RecList)
			{
				if(r.contains(p))
					return r;
			}
			
			return null;
		}
		
		private class MouseHandler extends MouseAdapter
		{

			@Override
			public void mouseClicked(MouseEvent event) {
				// TODO Auto-generated method stub
				current = find(event.getPoint());
				if((current != null) && event.getClickCount()>=2)
					remove(current);
			}

			@Override
			public void mousePressed(MouseEvent event) {
				// TODO Auto-generated method stub
				current = find(event.getPoint());
				if(current == null)
					add(event.getPoint());
			}
			
		}
		
		private class MouseMotionHandler implements MouseMotionListener
		{

			@Override
			public void mouseDragged(MouseEvent event) {
				// TODO Auto-generated method stub
				if(current != null){
					int x = event.getX();
					int y = event.getY();
					current.setFrame(x-SIDELENTH/2,y-SIDELENTH/2,SIDELENTH,SIDELENTH);
					repaint();
				}
					
			}

			@Override
			public void mouseMoved(MouseEvent event) {
				// TODO Auto-generated method stub
				if(find(event.getPoint()) == null)
					setCursor(Cursor.getDefaultCursor());
				else
					setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
			
		}
		private static final int SIDELENTH = 10;
		private ArrayList<Rectangle2D> RecList;
		private Rectangle2D current;
	}
}
