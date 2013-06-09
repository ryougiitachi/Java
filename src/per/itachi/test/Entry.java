package per.itachi.test;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import per.itachi.test.window.MainFrame;
import per.itachi.test.xml.XMLParserByDom4j;

public class Entry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i, length;
		String strLookAndFeel;
		LookAndFeelInfo[] arrStyles=UIManager.getInstalledLookAndFeels();
		length=arrStyles.length;
		for (i=0; i<length; ++i) {
			System.out.println(arrStyles[i].getName()+"	:"+arrStyles[i].getClassName());
		}
		strLookAndFeel=UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(strLookAndFeel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		XMLParserByDom4j xmlParser=new XMLParserByDom4j();
		xmlParser.loadXMLDom("perference/perference.xml");
		JFrame mainFrame=new MainFrame(xmlParser);
		mainFrame.setVisible(true);
	}

}
