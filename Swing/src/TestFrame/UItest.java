package TestFrame;

import javax.swing.UIManager;

public class UItest {

	public static void main(String[] args)
	{
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		
		for(UIManager.LookAndFeelInfo info : infos)
		{
			System.out.println(info.getName()+" -> "+info.getClassName());
		}
	}
}
