package c07.controller;

import c07.controller.Outer.InnerThree;

public class Outer {
	//公有非静态内部类
	public class InnerOne{
		InnerOne(String creater){
			System.out.println("I'm public inner created by "+creater);
		}
		void sayHi(){
			System.out.println("InnerOne:Hello!");
		}
		/* 非静态内部类不能拥有静态方法
		 * static void staticSayHi(){
		 *	System.out.println("InnerThree:Hello!");
		}*/
		
	}
	//私有非静态内部类
	private class InnerTwo{
		InnerTwo(String creater){
			System.out.println("I'm private inner create by "+ creater);
		}
		void sayHi(){
			System.out.println("InnerTwo:Hello!");
		}
	}
	
	static class InnerThree{
		InnerThree(String creater){
			System.out.println("I'm static inner create by "+ creater);
		}		
		void sayHi(){
			System.out.println("InnerThree:Hello!");
		}
		static void staticSayHi(){
			System.out.println("InnerThree:Static method Hello!");
		}
	}

	public static InnerThree InnerThree;
	//在非静态方法中将内部类实例化
	void createInner(){
		InnerOne one = new InnerOne("non-static method");
		InnerTwo two = new InnerTwo("non-static method");
		InnerThree three = new InnerThree("non-static method");
		one.sayHi();
	}
	//在静态方法中将内部类实例化
	static void staticCreateInner(){
		/*按照在非静态方法中将内部类实例化*/
		//InnerOne one = new InnerOne("non-static method");  //失败，提示需要实例化外部类对象来创建内部类
		InnerOne one = new Outer().new InnerOne("static method");	//成功
		//InnerTwo two = new InnerTwo("non-static method");
		InnerTwo two = new Outer().new InnerTwo("static method");
		//InnerThree threee = new Outer().new InnerThree("non-static method");	//失败，提示不需要实例化外部类对象来创建内部类
		InnerThree three = new InnerThree("static method");		//成功
		three.sayHi();
		three.staticSayHi();
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.createInner();
		//one.sayHi(); 		//在createInner方法调用结束后，在方法中创建的对象就都被销毁了
		Outer.staticCreateInner();
		//one.sayHi();		//同上
	}

}
