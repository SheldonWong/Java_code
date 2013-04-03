package com.ruxia.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Bullet {
    //坐标
	public int x,y;
	//子弹大小
	public int width,height;
	//子弹杀伤力
	public int kill;
	//速度
	public int speed;
	//子弹图片
	public String img;
	//是否存活
	public boolean isLive=true;
	//子弹类型(好坏)
	public boolean isGood;
	
	public void drawBullet(Graphics g)
	{
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img1=tk.getImage(Bullet.class.getClassLoader().getResource("image/"+img));
		//画图
		g.drawImage(img1, x,y,width,height,null);
	}
}
