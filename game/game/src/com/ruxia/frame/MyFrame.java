package com.ruxia.frame;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class MyFrame extends Frame {
	public static final  int WIDTH=900;
	public static final  int HEIGHT=700;
	public static int my_x=450;
	public static int my_y=600;
	//分数
	public static int score=0;
	
	//定义变量,专门表示键盘按下的键
	public static boolean a=false;public static boolean s=false;public static boolean d=false;public static boolean w=false;public static boolean j=false;
	//敌机的集合
	public ArrayList<Person> personAll=new ArrayList<Person>();
	//存放爆炸效果的集合
	public static ArrayList<Explode> explodeAll=new ArrayList<Explode>();
	//存放子弹的集合
	public static ArrayList<Bullet> bulletAll=new ArrayList<Bullet>();
    public MyFrame()
    {
    	this.setTitle("雷电"+score);
    	this.setSize(WIDTH,HEIGHT);
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
    	this.addWindowListener(new MyWindowClose());
    	//添加键盘监听器
    	this.addKeyListener(new MyKeyDown());
    	this.setVisible(true);
    	MyThread t=new MyThread();
    	t.start();
    	
    }
    //定义背景Y座标
    int bg_y=0;
    @Override
    public void paint(Graphics g) {
    	Toolkit tk=Toolkit.getDefaultToolkit();
    	Image bg_img=tk.getImage(MyFrame.class.getClassLoader().getResource("image/bg2.jpg"));
    	g.drawImage(bg_img, 0, bg_y, WIDTH, HEIGHT, null);
    	bg_y+=10;
    	g.drawImage(bg_img, 0, -HEIGHT+bg_y, WIDTH, HEIGHT, null);
    	//判断bg_y的值是否超过窗体的高度
    	if(bg_y>HEIGHT)
    	{
    		bg_y=0;
    	}
    	Image my_img=tk.getImage(MyFrame.class.getClassLoader().getResource("image/my_img.jpg"));
    	g.drawImage(my_img, my_x, my_y, 55, 60, null);
    	//创建随机对象
    	Random rd=new Random();
    	if(rd.nextInt(10)==5)
    	{
    		//创建敌机
        	Person person=new Person(rd.nextInt(850), 45, 32, 58, 100, 100, "enemy1.jpg", 15);
        	personAll.add(person);
        	
    	}
    	for (int i = 0; i < personAll.size(); i++) {
			Person person=personAll.get(i);
			if(person.isLive)
			{
				person.drawPerson(g);
			}
			else
				personAll.remove(person);
		}
    	//绘画爆炸
    	for (int i = 0; i < explodeAll.size(); i++) {
			Explode e=explodeAll.get(i);
			//判断是否是活字弹
			if(e.isLive)
			{
				e.drawExplode(g);
			}
			else {
				explodeAll.remove(e);
			}
		}
    	//绘画子弹
    	for (int i = 0; i < bulletAll.size(); i++) {
			Bullet bullet=bulletAll.get(i);
			//判断是否是活子弹
			if(bullet.isLive)
			{
				bullet.drawBullet(g);
			}
			else {
				bulletAll.remove(bullet);
			}
		}
    	this.setTitle("雷电                            分数:"+score);
    }
    public void move()
    {
    	if(a)
    		MyFrame.my_x-=20;
    	if(d)
    		MyFrame.my_x+=20;
    	if(s)
    		MyFrame.my_y+=20;
    	if(w)
    		MyFrame.my_y-=20;
    	if(j)
    	{
    		Fire();
    	}
    }
    //开火方法
    public void Fire()
    {
    	Bullet bullet=new Bullet();
    	bullet.x=my_x+22;
    	bullet.y=my_y+30;
    	bullet.img="bullet.jpg";
    	bullet.speed=40;
    	bullet.width=20;
    	bullet.height=20;
    	bulletAll.add(bullet);
    }
    Image img=null;
    @Override
    public void update(Graphics g) {
    	if(img==null)
    	{
    		img=this.createImage(WIDTH, HEIGHT);
    	} 	
    	//利用img创建虚拟画笔
    	Graphics gb=img.getGraphics();
    	//调用paint方法
    	paint(gb);
    	//利用真实的画笔g来画图片
    	g.drawImage(img, 0,0,WIDTH,HEIGHT,null);
    }
	public static void main(String[] args) {
		new MyFrame();
	}
	//内部类,线程类,用来刷新当前窗体S
    class MyThread extends Thread
    {
    	@Override
    	public void run() {
    		while(true)
    		{
    			repaint();
    			//每时每刻都判断是否要移动飞机 
    			move();
    			try {
    				//让子弹前进,速度要比玩家速度快很多
    				for (int i = 0; i < bulletAll.size(); i++) {
						Bullet bullet=bulletAll.get(i);
						bullet.y-=bullet.speed;
					}
					Thread.sleep(65);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    		}   		
    	}
    }
}
//这个类的作用是关闭窗体
class MyWindowClose extends WindowAdapter
{
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
class MyKeyDown extends KeyAdapter
{
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			MyFrame.a=true;			
			break;
		case KeyEvent.VK_S:
			MyFrame.s=true;
			break;
		case KeyEvent.VK_D:
			MyFrame.d=true;
			break;
		case KeyEvent.VK_W:
			MyFrame.w=true;
			break;
		case KeyEvent.VK_J:
			MyFrame.j=true;
			break;
		default:
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			MyFrame.a=false;			
			break;
		case KeyEvent.VK_S:
			MyFrame.s=false;
			break;
		case KeyEvent.VK_D:
			MyFrame.d=false;
			break;
		case KeyEvent.VK_W:
			MyFrame.w=false;
			break;
		case KeyEvent.VK_J:
			MyFrame.j=false;
			break;
		default:
			break;
		}
	}
}