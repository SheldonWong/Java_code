package com.study.jxl;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;

public class GenXml {
	public void buidXMLDoc() throws IOException, JDOMException{
		Element stuRoot;
		Document doc;
		doc = new Document();
		stuRoot = new Element("class");
		doc.setRootElement(stuRoot);
		
		stuRoot.addContent(new Element("student").setAttribute("id","001").
				addContent(new Element("name").setText("�²���")).
				addContent(new Element("sex").setText("��")).
				addContent(new Element("position").setText("������Ա")));
		
		stuRoot.addContent(new Element("student").setAttribute("id","002").
				addContent(new Element("name").setText("��ΰ")).
				addContent(new Element("sex").setText("��")).
				addContent(new Element("position").setText("������Ա")));
		
		stuRoot.addContent(new Element("student").setAttribute("id","003").
				addContent(new Element("name").setText("������")).
				addContent(new Element("sex").setText("��")).
				addContent(new Element("position").setText("������Ա")));

		

        XMLOutputter   XMLOut   =   new   XMLOutputter();
        XMLOut.output(doc,   new   FileOutputStream("test1.xml"));
	}


	public static void main(String[] args){
		try{
			GenXml t1 = new GenXml();
			System.out.println("��ʼ���XML...");
			t1.buidXMLDoc();
		}catch(Exception e){
			System.out.println(e);
		}		
}

}