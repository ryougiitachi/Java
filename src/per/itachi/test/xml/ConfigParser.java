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

public class ConfigParser {
	
	private File filePerf;
	private Document document;

	public ConfigParser() {
		document=null;
	}
	
	public void init(){
		SAXReader saxReader;
		String strPerfFile;
		strPerfFile="perference/perference.xml";
		filePerf=new File(strPerfFile);
		try {
			if (filePerf.exists()) {
				saxReader=new SAXReader();
				document=saxReader.read(filePerf);
			}
			else {
				document=DocumentHelper.createDocument();
				document.addElement("root");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modify(String strElement, String strValue) {
		Writer fw,bw;
		XMLWriter xmlw;
		Element rootElement, element;
		rootElement=document.getRootElement();
		element=rootElement.element(strElement);//"initialFileChoosePath"
		if (element==null) {
			element=rootElement.addElement(strElement);
		}
		element.setText(strValue);
		try {
			fw=new FileWriter(filePerf);
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

	@Override
	protected void finalize() throws Throwable {
		if (document!=null) {
			document=null;
		}
		super.finalize();
	}
}
