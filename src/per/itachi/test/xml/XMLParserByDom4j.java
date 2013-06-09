package per.itachi.test.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLParserByDom4j {
	
	private File fileDoc;
	private Document document;
	private Element rootElement;
	
	public XMLParserByDom4j() {
	}
	
	public boolean loadXMLDom(String path) {
		if (path==null || path.length()==0) {
			return false;
		}
		File file=new File(path);
		return loadXMLDom(file);
	}
	
	public boolean loadXMLDom(File file) {
		if (file==null) {
			return false;
		}
//		InputStream fis, bis;
		SAXReader saxReader;
		try {
			if (file.exists()) {
				saxReader=new SAXReader();
				document=saxReader.read(file);
			}
			else {
				Writer fw,bw;
				XMLWriter xmlw;
				document=DocumentHelper.createDocument();
				document.addElement("root");
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				xmlw=new XMLWriter(bw);
				xmlw.write(document);
				xmlw.close();
				bw.close();
				fw.close();
			}
			fileDoc=file;
			rootElement=document.getRootElement();
			System.out.println(rootElement.getName());
			System.out.println(rootElement.getNamespace().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public String getElementValue(String strElement) {
		if (strElement==null || strElement.length()==0) {
			return null;
		}
		if (rootElement==null) {
			return null;
		}
		Element element;
		element=rootElement.element(strElement);
		if (element==null) {
			return null;
		}
		System.out.println(element.getStringValue());
		return element.getText();
	}
	
	public void modifyElementValue(String strElement, String strValue) {
		if (rootElement==null) {
			return;
		}
		if (strElement==null || strElement.length()==0 ||
				strValue==null || strValue.length()==0
				) {
			return;
		}
		Element element;
		element=rootElement.element(strElement);
		if (element==null) {
//			rootElement.addEntity(strElement, strValue);
			element=rootElement.addElement(strElement);
			element.setText(strValue);
		}
		else {
			element.setText(strValue);
		}
	}
	
	public void saveXMLDom() {
			Writer fw,bw;
			XMLWriter xmlw;
			try {
				fw=new FileWriter(fileDoc);
				bw=new BufferedWriter(fw);
				xmlw=new XMLWriter(bw);
				xmlw.write(document);
				xmlw.close();
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
