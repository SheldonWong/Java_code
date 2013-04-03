package study.Gson.test;

import java.io.*;
import java.util.Scanner;

/**
 * java使用字节流复制图像
 * @author Administrator
 *@time 2011年6月9日 19:55:10
 */
public class TestPNG {
       private String filename;  //文件名
       private  double  filesize;       //文件大小
    public static void main(String agrs[]){
    	TestPNG tt2=new TestPNG();
        String frompath="D:\\qq.JPG";
        String topath="F:\\qq.JPG";
        if(tt2.CheckFile(frompath, topath)){
        tt2.CopyFile(frompath, topath);
        System.out.println("hello");
        }
    }
    //复制文件
    public void  CopyFile(String frompath,String topath){
        File file1=new File(frompath);//源文件路径
        File file2=new File(topath);//目标文件路径
        filename=file1.getName();
        filesize=(file1.length())/1024/1024;
        System.out.println("********************文件属性********************");
        System.out.println("源文件路径："+frompath);
        System.out.println("目标文件路径："+topath);
        System.out.println("文件名称："+filename);
        System.out.println("文件大小："+filesize+" MB");
        int ch=0;
        try{
            FileInputStream fin=new FileInputStream(file1);
            FileOutputStream fout=new FileOutputStream(file2);
            ch=fin.read();
            System.out.println("开始复制！");
          long startTime=System.currentTimeMillis();   //获取开始时间
            while(ch!=-1){
                fout.write(ch);
                ch=fin.read();
            }
            long endTime=System.currentTimeMillis(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
            System.out.println("复制完毕！");
            //关闭流
            fin.close();  
            fout.close();
        }catch(Exception e){
            System.err.println("Error:  "+e);
        }   
    }
   //验证文件是否存在
    public boolean CheckFile(String frompath,String topath){
        File file1=new File(frompath);//源文件路径
        File file2=new File(topath);//目标文件路径
        if(!file1.exists()){                    //文件不存在
               System.out.println("源文件不存在，请检查路径是否正确！");
            return false;
        }else{
            if(file2.exists()){
                System.out.println("目标文件已经存在，请选择  覆盖/取消  ？");
                System.out.println("1： 覆盖    2：取消");
                try{
                    Scanner sc=new Scanner(System.in);
                    int a=sc.nextInt();
                    if(a==1){
                        System.out.println("你输入的是1,操作将继续,目标文件将被覆盖。");
                        return true;
                    }else if(a==2){
                        System.out.println("您输入了2，操作将取消。");
                        return false;
                    }else{
                    System.out.println("输入无效。。;");
                    CheckFile(frompath, topath);
                    return false;
              	}
                }catch(Exception ee){
                    System.out.println("输入无效。。;");
                    CheckFile(frompath, topath);
                    return false;
                }
            }
        }
        return true;
    }
}
