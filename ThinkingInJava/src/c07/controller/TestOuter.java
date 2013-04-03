package c07.controller;

public class TestOuter {

	public static void main(String[] args) {
		//Outer.InnerOne one = new Outer.InnerOne("main");		//失败
		Outer.InnerOne one = new Outer().new InnerOne("main");	//成功
		Outer.InnerThree = new Outer.InnerThree("main");		//成功
	}

}
