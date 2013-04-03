package com.sgamerv.thinkingInJava;

public class Person {
String name="Terry";
String age="27";
String sex="male";
public Person(int i){
	Runtime rt = Runtime.getRuntime();
	System.out.println("Person"+i+"->Total Memory:"+rt.totalMemory());
	String[] pp = new String[4100000];
	for(int n=0;n<4100000;n++)
		pp[n]="pp"+n;
	System.out.println("Person"+i+"->Free Memory:"+rt.freeMemory()/1024/1024);
}
}
