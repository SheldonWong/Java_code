package com.ruxia.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Explode {
   //坐标
	private int x;
	private int y;
	//定义爆炸显示的图片
	String img[]={"boom1.jpg","boom2.jpg","boom3.jpg","boom4.jpg","boom5.jpg","boom6.jpg","boom7.jpg","boom8.jpg","boom9.jpg"};
	//爆炸的生命
	public boolean isLive=true;
	//定义下标
	private int index=0;
	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void drawExplode(Graphics g)
	{
		//得到工具类
		Toolkit tkToolkit=Toolkit.getDefaultToolkit();
		//得到图片对象
		//得到数组中的图片
		String image=img[index];
		Image img1=tkToolkit.getImage(Explode.class.getClassLoader().getResource("image/"+image));
		g.drawImage(img1, x,y,null);
		index++;
		if(index>=img.length)
		{
			index=0;
			//生命消失
			isLive=false;
		}
	}
}
