package com.sgamerv.thinkingInJava;

public class StaticTest {
public static Person p1 = new Person(1);
Person p3 = new Person(3);
	public StaticTest() {
		Runtime rt = Runtime.getRuntime();
		System.out.println("Static->Total Memory:"+rt.totalMemory());
		String[] pp = new String[4100000];
		for(int i=0;i<4100000;i++)
			pp[i]="pp"+i;
		System.out.println("Static->Free Memory:"+rt.freeMemory());
	}
	public static Person p2 = new Person(2);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticTest s = new StaticTest();

	}

}
