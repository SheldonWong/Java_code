package TestFrame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CaculatorFrame extends JFrame{
	
	public static void main(String[] args)
	{
		CaculatorFrame frame = new CaculatorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public CaculatorFrame(){
		setTitle("Caculator");
		CaculatorPanel panel = new CaculatorPanel();
		add(panel);
		pack();
	}	
	
	private class CaculatorPanel extends JPanel
	{
		public CaculatorPanel()
		{
			setLayout(new BorderLayout());
			start = true;
			double result = 0;
			lastCommand = "=";			
			
			display = new JButton("0");
			display.setEnabled(false);
			add(display,BorderLayout.NORTH);
			
			insert = new InsertAction();
			command = new CommandAction();
			
			panel = new JPanel();
			panel.setLayout(new GridLayout(4,4));
			addButton("7",insert);
			addButton("8",insert);
			addButton("9",insert);
			addButton("/",command);
			addButton("4",insert);
			addButton("5",insert);
			addButton("6",insert);
			addButton("*",command);
			addButton("1",insert);
			addButton("2",insert);
			addButton("3",insert);
			addButton("-",command);
			addButton("0",insert);
			addButton(".",insert);
			addButton("=",command);
			addButton("+",command);
			
			add(panel,BorderLayout.CENTER);
			
		}
		
		private void addButton(String label,ActionListener listener){
			JButton button = new JButton(label);
			button.addActionListener(listener);
			panel.add(button);
		}
		
			private class InsertAction implements ActionListener
			{

			@Override
				public void actionPerformed(ActionEvent event) 
				{
				// TODO Auto-generated method stub
					String input = event.getActionCommand();
					if(start)
					{
						display.setText("");
						start = false;
					}
					display.setText(display.getText()+input);
			
				}			
			}
			
			private class CommandAction implements ActionListener
			{

				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					String command = event.getActionCommand();
					if(start)
					{
						if(command.equals("-") && !lastCommand.equals("="))
						{
							display.setText(command);
							start = false;
						}
						else
							lastCommand = command;
					}else
					{
						caculate(Double.parseDouble(display.getText()));
						lastCommand = command;
						start = true;						
					}
					
				}
				
			}
			
			public void caculate(double x)
			{
				if(lastCommand.equals("+")) result += x;
				else if(lastCommand.equals("-")) result -= x;
				else if(lastCommand.equals("*")) result *= x;
				else if(lastCommand.equals("/")) result /= x;
				else if(lastCommand.equals("=")) result = x;
				display.setText(""+result);
			}
			
			private JPanel panel;
			private boolean start;
			private JButton display;
			private String lastCommand;
			private double result;
			private ActionListener insert;
			private ActionListener command;
		}
}
