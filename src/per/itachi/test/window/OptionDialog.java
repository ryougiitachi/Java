package per.itachi.test.window;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import per.itachi.test.xml.XMLParserByDom4j;

public class OptionDialog extends JDialog implements ActionListener,
		WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5632540119819047364L;
	private JTextField txtFieldInitPath;
	private JButton btnBrowse;
	private JButton btnSave, btnCancel;
	private JFileChooser fileChooser;
	private XMLParserByDom4j xmlParser;

	public OptionDialog() {
		super();
		init();
	}
	
	public OptionDialog(Frame owner, XMLParserByDom4j xml) {
		super(owner);
		xmlParser=xml;
		init();
	}

	public OptionDialog(Dialog owner) {
		super(owner);
		init();
	}

	public OptionDialog(Window owner) {
		super(owner);
		init();
	}

	public OptionDialog(Frame owner, boolean modal, XMLParserByDom4j xml) {
		super(owner, modal);
		xmlParser=xml;
		init();
	}

	public OptionDialog(Frame owner, String title) {
		super(owner, title);
		init();
	}

	public OptionDialog(Dialog owner, boolean modal) {
		super(owner, modal);
		init();
	}

	public OptionDialog(Dialog owner, String title) {
		super(owner, title);
		init();
	}

	public OptionDialog(Window owner, ModalityType modalityType) {
		super(owner, modalityType);
		init();
	}

	public OptionDialog(Window owner, String title) {
		super(owner, title);
		init();
	}

	public OptionDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		init();
	}

	public OptionDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
		init();
	}

	public OptionDialog(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
		init();
	}

	public OptionDialog(Frame owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		init();
	}

	public OptionDialog(Dialog owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		init();
	}

	public OptionDialog(Window owner, String title, ModalityType modalityType,
			GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
		init();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		Class<?> clazz=obj.getClass();
		if (clazz==JButton.class) {
			if (obj==btnBrowse) {
				if (fileChooser==null) {
					initFileChooser();
				}
				int state=fileChooser.showOpenDialog(this);
				File dir;
				switch (state) {
				case JFileChooser.APPROVE_OPTION:
					dir=fileChooser.getSelectedFile();
					txtFieldInitPath.setText(dir.getPath());
					break;
				case JFileChooser.CANCEL_OPTION:
					break;
				case JFileChooser.ERROR_OPTION:
					break;
				default:
					break;
				}
			}
			else if (obj==btnSave) {
				actionSave();
			}
			else if (obj==btnCancel) {
				
			}
			else {

			}
		}
	}
	
	private void init(){
		initLayout();
		initListener();
		initParam();
		setTitle("Option");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}
	
	private void initLayout() {
		JPanel panel;
		GroupLayout layout;
		SequentialGroup sg;
		ParallelGroup pg;
		Border border;
		JLabel labelInitPath;
		border=new TitledBorder("General");
		panel=(JPanel)getContentPane();
		panel.setBorder(border);
		labelInitPath=new JLabel();
		labelInitPath.setText("Audio Files' Initial Path");
		btnBrowse=new JButton("Browse..");
		btnSave=new JButton("Save");
		btnCancel=new JButton("Cancel");
		txtFieldInitPath=new JTextField();
		layout=new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.linkSize(SwingConstants.VERTICAL, txtFieldInitPath);
		panel.setLayout(layout);
		/**start to layout horizontal**/
		sg=layout.createSequentialGroup();
		pg=layout.createParallelGroup();
		pg.addComponent(labelInitPath);
		sg.addGroup(pg);
		pg=layout.createParallelGroup();
		pg.addComponent(txtFieldInitPath);
		pg.addComponent(btnSave);
		sg.addGroup(pg);
		pg=layout.createParallelGroup();
		pg.addComponent(btnBrowse);
		pg.addComponent(btnCancel);	//it is not an error to duplicate the same comp but just show one, and it is an error to differ
		//pg.addComponent(btnSave);
		sg.addGroup(pg);
		layout.setHorizontalGroup(sg);
		/**end to layout horizontal**/
		/**start to layout vertical**/
		sg=layout.createSequentialGroup();
		pg=layout.createParallelGroup(Alignment.LEADING);
		pg.addComponent(labelInitPath);
		pg.addComponent(txtFieldInitPath);
		pg.addComponent(btnBrowse);
		sg.addGroup(pg);
		pg=layout.createParallelGroup(Alignment.TRAILING);
		pg.addComponent(btnSave);
		pg.addComponent(btnCancel);
		sg.addGroup(pg);
		layout.setVerticalGroup(sg);
		/**end to layout vertical**/
		//it seems to be okay no matter whether linksize is located in begin or end
		//layout.linkSize(SwingConstants.VERTICAL, txtFieldInitPath);
	}
	
	private void initListener(){
		addWindowListener(this);
		btnBrowse.addActionListener(this);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	private void initParam() {
		String strValue;
		strValue=xmlParser.getElementValue("initialFileChoosePath");
		if (strValue!=null) {
			txtFieldInitPath.setText(strValue);
		}
	}
	
	private void initFileChooser() {
		String strDirCur;
		File dirCur;
		fileChooser=new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		strDirCur=xmlParser.getElementValue("initialFileChoosePath");
		if (strDirCur!=null) {
			dirCur=new File(strDirCur);
			fileChooser.setCurrentDirectory(dirCur);
		}
	}
	
	private void actionSave() {
		String strValue;
		File file;
		strValue=txtFieldInitPath.getText();
		if (strValue.length()>0) {
			file=new File(strValue);
			if (file.exists()) {
				xmlParser.modifyElementValue("initialFileChoosePath", strValue);
			}
			else {
				JOptionPane.showMessageDialog(this, "Non-Existing Path", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		xmlParser.saveXMLDom();
	}
}
