package com.ruxia.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.tools.Tool;

public class Person {
    //敌机坐标
	private int x,y;
	private int width,height;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getKill() {
		return kill;
	}
	public void setKill(int kill) {
		this.kill = kill;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//血量
	private int hp;
	public Person(int x, int y, int width, int height, int hp, int kill,
			String imgurl, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hp = hp;
		this.kill = kill;
		this.imgurl = imgurl;
		this.speed = speed;
	}
	//杀伤力
	private int kill;
	//定义图片路径
	private String imgurl;
	//是否存活
	public  boolean isLive=true;
	//速度
	private int speed;
	public void drawPerson(Graphics g)
	{
		//定义系统工具类
		Toolkit tk=Toolkit.getDefaultToolkit();
		//创建图片对象
		Image img=tk.getImage(Person.class.getClassLoader().getResource("image/"+imgurl));
		g.drawImage(img,x,y,width,height,null);
		move();
		
	}
	public void move()
	{
		y+=speed;
		if(y>=MyFrame.HEIGHT)
		{
			isLive=false;
		}
		//捡查子弹是否出屏幕
		for (int i = 0; i < MyFrame.bulletAll.size(); i++) {
			if(MyFrame.bulletAll.get(i).y<0)
			{
				MyFrame.bulletAll.get(i).isLive=false;
			}
		}
		this.hitPerson();
		this.hitBullet();
	}
	//反回当前敌机的矩形
	public Rectangle getPersonRectangle()
	{
		return new Rectangle(x,y,width,height);
	}
	//判断相撞
	public void hitPerson()
	{
		//得到敌机矩形
		Rectangle personRec=this.getPersonRectangle();
		//得到主机矩形
		Rectangle myRec=new Rectangle(MyFrame.my_x,MyFrame.my_y,55,60);
		if(myRec.intersects(personRec)==true)
		{
			this.isLive=false;
			//产生爆炸效果
			Explode e=new Explode(x,y);
			//将e放入爆炸效果集合
			MyFrame.explodeAll.add(e);
		}
	}
	//判断和玩家子弹的相撞
	public void hitBullet()
	{
		//得到敌机矩形
		Rectangle personRec=this.getPersonRectangle();
		//得到子弹的矩形
		for (int i = 0; i < MyFrame.bulletAll.size(); i++) {
			Rectangle bulletRec=new Rectangle(MyFrame.bulletAll.get(i).x,MyFrame.bulletAll.get(i).y,20,20);
			if(personRec.intersects(bulletRec)==true)
			{
				MyFrame.score+=10;
				this.isLive=false;
				//产生爆炸效果
				Explode e=new Explode(x,y);
				//将e放入爆炸效果集合
				MyFrame.explodeAll.add(e);
			}
		}
		
	}
}
