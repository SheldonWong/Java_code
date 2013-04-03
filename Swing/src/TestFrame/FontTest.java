package TestFrame;

import java.awt.GraphicsEnvironment;

public class FontTest {

	public static void main(String[] args){
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(String fontName : fontNames)
		{
			System.out.println(fontName);
		}
	}
}
