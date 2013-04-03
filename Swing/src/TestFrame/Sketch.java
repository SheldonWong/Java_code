package TestFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sketch extends JFrame{
	
	public static void main(String[] args){
		Sketch sketch = new Sketch();
		sketch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sketch.setVisible(true);
	}
	
	public Sketch(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		SketchPanel panel = new SketchPanel();
		add(panel);
		setTitle("Sketch");
	}
	
	private final static int DEFAULT_WIDTH = 800;
	private final static int DEFAULT_HEIGHT = 200;
	
	private class SketchPanel extends JPanel{
		public SketchPanel(){
			last = new Point2D.Double(100,100);
			lines = new ArrayList<Line2D>();
			KeyHandler listener = new KeyHandler();
			addKeyListener(listener);
			setFocusable(true);
		}
		
		public void add(int x, int y){
			Point2D end = new Point2D.Double(last.getX()+x,last.getY()+y);
			Line2D line = new Line2D.Double(last,end);
			lines.add(line);
			repaint();
			last = end;
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			for(Line2D l : lines)
			{
				g2.draw(l);
			}
		}
		
		private Point2D last;
		private ArrayList<Line2D> lines;
		private static final int SMALL_INCREMENT = 1;
		private static final int LARGE_INCREMENT = 5;
		
		private class KeyHandler implements KeyListener{

			@Override
			public void keyPressed(KeyEvent event) {
				// TODO Auto-generated method stub
				int keyCode = event.getKeyCode();
				
				int d;
				if(event.isShiftDown())
					d = LARGE_INCREMENT;
				else
					d = SMALL_INCREMENT;
				
				switch(keyCode){
				case KeyEvent.VK_LEFT : add(-d,0);break;
				case KeyEvent.VK_RIGHT : add(d,0);break;
				case KeyEvent.VK_UP : add(0,-d);break;
				case KeyEvent.VK_DOWN : add(0,d);
				}
				
			}

			@Override
			public void keyReleased(KeyEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		}
	}
	
	
}
