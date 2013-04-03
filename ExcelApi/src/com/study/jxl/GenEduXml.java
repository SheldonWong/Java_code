package com.study.jxl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;

public class GenEduXml {
	Document myDoc;
	Element myRoot;
	Element subRoot;
	
	public void init() throws IOException, JDOMException{
		myDoc = new Document();			//创建document
		Attribute att1 = new Attribute("grade","3");		
		Attribute att2 = new Attribute("version","高级");
		ArrayList<Attribute> list = new ArrayList<Attribute>();
		list.add(att1);
		list.add(att2);
		myRoot = new Element("subChannel").setAttribute("id","英语").
				addContent(new Element("questions").setAttributes(list));	
		//此处注意用setAttribute设置属性时，属性个数大于1时参数为Collection类
		
		myDoc.setRootElement(myRoot);		//设置根节点
		subRoot = myRoot.getChild("questions");    //移动到需要插入数据的节点
	}
	
	//写一个用来插入excel中一行数据的函数，注意如何形成所需结构
	public void addOneItem(String question,String anwser,String option1,String option2,String option3){
		subRoot.addContent(new Element("questionItem").setAttribute("answerid",anwser).
				addContent(new Element("text").setText(question)).
				addContent(new Element("answer").setAttribute("id","1").setText(option1)).
				addContent(new Element("answer").setAttribute("id","2").setText(option2)).
				addContent(new Element("answer").setAttribute("id","3").setText(option3)));
	}
	//将数据导出为xml文件的函数
	public void toXml()throws IOException, JDOMException{
		XMLOutputter   XMLOut   =   new   XMLOutputter();
        XMLOut.output(myDoc,   new   FileOutputStream("test1.xml"));
	}
}