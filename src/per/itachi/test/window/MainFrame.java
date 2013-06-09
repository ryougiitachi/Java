package per.itachi.test.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import per.itachi.test.music.TagAPEV2FrameBean;
import per.itachi.test.music.MP3AudioTagParser;
import per.itachi.test.music.TagAPEV2Bean;
import per.itachi.test.music.TagID3V1Bean;
import per.itachi.test.music.TagID3V2Bean;
import per.itachi.test.music.TagID3V2ImageBean;
import per.itachi.test.music.TagLYRICS3V2Bean;
import per.itachi.test.xml.XMLParserByDom4j;

public class MainFrame extends JFrame implements ActionListener, WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1173776386525878365L;
	private MP3AudioTagParser tagParser;
	private TagID3V1Bean tagID3V1;
	private TagID3V2Bean tagID3V2;
	private TagAPEV2Bean tagAPEV2;
	private TagLYRICS3V2Bean tagLYRICS3V2;
	private Toolkit defaulToolkit;
	private JFileChooser fileChooser;
	private JDialog dialogOpt;
	private JToolBar toolBar;
	private JTabbedPane tabbedPane;
	private Map<String, JPanel> mapTabPane;
	private Map<String, JTextField[]> mapManagerTxt;
	private Map<String, JTextArea> mapManagerTxtArea;
	private Map<String, JButton> mapManagerPic;
	
	private JButton btnOpen, btnOption;
	private XMLParserByDom4j xmlParser;

	public MainFrame(XMLParserByDom4j xml) throws HeadlessException {
		super();
		xmlParser=xml;
		init();
		
	}

	public MainFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}

	public MainFrame(String title) throws HeadlessException {
		super(title);
		init();
	}

	public MainFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		Class<?> clazz=obj.getClass();
		if (clazz==JButton.class) {
			if (fileChooser==null) {
				initFileChooser();
			}
			
			if (obj==btnOpen) {
				int state=fileChooser.showOpenDialog(this);
				switch (state) {
				case JFileChooser.APPROVE_OPTION:
					Thread thread=new LoadTagsThread();
					EventQueue.invokeLater(thread);
					thread=null;
					break;
				case JFileChooser.CANCEL_OPTION:
					break;
				case JFileChooser.ERROR_OPTION:
					break;

				default:
					break;
				}
			}
			else if (obj==btnOption) {
				if (dialogOpt==null) {
					dialogOpt=new OptionDialog(this, true, xmlParser);
				}
				dialogOpt.setVisible(true);
			}
			else {
			}
		} else {

		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Window win=e.getWindow();
		if (win==this) {
			
		} else {

		}
		switch (e.getNewState()) {
		case WindowEvent.WINDOW_OPENED:
			System.out.println("WindowEvent.WINDOW_OPENED");
			break;
		case WindowEvent.WINDOW_CLOSING:
			System.out.println("WindowEvent.WINDOW_CLOSING");
			break;
		case WindowEvent.WINDOW_CLOSED:
			System.out.println("WindowEvent.WINDOW_CLOSED");
			break;
		case WindowEvent.WINDOW_ICONIFIED:
			System.out.println("WindowEvent.WINDOW_ICONIFIED");
			break;
		case WindowEvent.WINDOW_ACTIVATED:
			System.out.println("WindowEvent.WINDOW_ACTIVATED");
			break;
		case WindowEvent.WINDOW_DEACTIVATED:
			System.out.println("WindowEvent.WINDOW_DEACTIVATED");
			break;
		case WindowEvent.WINDOW_GAINED_FOCUS:
			System.out.println("WindowEvent.WINDOW_GAINED_FOCUS");
			break;
		case WindowEvent.WINDOW_LOST_FOCUS:
			System.out.println("WindowEvent.WINDOW_LOST_FOCUS");
			break;
		case WindowEvent.WINDOW_STATE_CHANGED:
			System.out.println("WindowEvent.WINDOW_STATE_CHANGED");
			break;

		default:
			System.out.println("New state is "+e.getNewState());
			break;
		}
		System.out.println("Old state is "+e.getOldState());
//		System.exit(0);
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
	
	public XMLParserByDom4j getXMLParser() {
		return xmlParser;
	}

	private void init() {
		initTest();
		mapTabPane=new HashMap<String, JPanel>();
		mapManagerTxt=new HashMap<>();
		mapManagerTxtArea=new HashMap<>();
		mapManagerPic=new HashMap<>();
		initLayout();
		initToolBar();
		initTabPane();
//		initFileChooser();
		initListener();
		tagParser=new MP3AudioTagParser();
		setTitle("MP3 Tag Parser");
//		setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initTest() {
		System.out.println("writer suffer:");
		String[] writerSuff = ImageIO.getWriterFileSuffixes();
		for (int i = 0; i < writerSuff.length; i++)
			System.out.print(writerSuff[i] + "  ");
		System.out.println("\nreader suffer:");
		String[] readerSuff = ImageIO.getReaderFormatNames();
		for (int i = 0; i < readerSuff.length; i++)
			System.out.print(readerSuff[i] + "  ");
		System.out.println();
	}
	
	private void initLayout() {
		Dimension dimWin, dimMini, dimScreen;
		int screenWidth, screenHeight;
		File fileIcon;
		Image image;
		InputStream fis, bis;
		ImageInputStream iis;
		defaulToolkit=Toolkit.getDefaultToolkit();
		dimScreen=defaulToolkit.getScreenSize();
		screenWidth=dimScreen.width;
		screenHeight=dimScreen.height;
		dimMini=new Dimension(320, 200);
		dimWin=new Dimension(screenWidth >>1, screenHeight >>1);
		setSize(dimWin);
		setMinimumSize(dimMini);
		
		fileIcon=new File("icon/APB-Reloaded-game-256.png");
		try {
			fis=new FileInputStream(fileIcon);
			bis=new BufferedInputStream(fis);
			iis=new MemoryCacheImageInputStream(bis);
			image=ImageIO.read(iis);
			setIconImage(image);
//			iis.close();
//			bis.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void initToolBar() {
		File fileIcon;
		Icon icon;
		Image image;
		ImageInputStream iis;
		toolBar=new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBorderPainted(true);
		add(toolBar, BorderLayout.NORTH);
		btnOpen=new JButton();
		btnOpen.setText("Open");
		btnOpen.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOpen.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOption=new JButton();
		btnOption.setText("Option");
		btnOption.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOption.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnOpen.setContentAreaFilled(false);
//		btnOpen.setSize(150, 150);
//		btnOpen.setPreferredSize(new Dimension(150, 150));
		try {
			fileIcon=new File("icon/Assassins-Creed-Revelations-256.png");
			if (fileIcon.exists()) {
				iis=new FileImageInputStream(fileIcon);
				image=ImageIO.read(iis);
//				image=image.getScaledInstance(128, 128, Image.SCALE_AREA_AVERAGING);
				icon=new ImageIcon(image.getScaledInstance(64, 64, Image.SCALE_AREA_AVERAGING));
//				iis.close();
				btnOpen.setIcon(icon);
			}
			fileIcon=new File("icon/Hunted-The-Demon-Forge-256.png");
			if (fileIcon.exists()) {
				iis=new FileImageInputStream(fileIcon);
				image=ImageIO.read(iis);
//				image=image.getScaledInstance(128, 128, Image.SCALE_AREA_AVERAGING);
				icon=new ImageIcon(image.getScaledInstance(64, 64, Image.SCALE_AREA_AVERAGING));
//				iis.close();
				btnOption.setIcon(icon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			toolBar.add(btnOpen);
			toolBar.add(btnOption);
		}
		//toolBar.add(btnOpen);
	}
	
	private void initTabPane() {
		JPanel panelInTab;
		JLabel[] arrLabels;
		JTextField[] arrTxtFields;
/*		Dimension dimLabel, dimTxt;*/
		GroupLayout layout;
		SequentialGroup group;
		ParallelGroup parallel;
/*		int i, length;*/
		int i;
		tabbedPane=new JTabbedPane();
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(tabbedPane, BorderLayout.CENTER);

		panelInTab=new JPanel(true);
		layout=new GroupLayout(panelInTab);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panelInTab.setLayout(layout);
/*		dimLabel=new Dimension(80, 20);
		dimTxt=new Dimension(200, 20);*/		
		arrLabels=new JLabel[7];
		arrLabels[0]=new JLabel("Title");
		arrLabels[1]=new JLabel("Performer");
		arrLabels[2]=new JLabel("Album");
		arrLabels[3]=new JLabel("Year");
		arrLabels[4]=new JLabel("Comment");
		arrLabels[5]=new JLabel("Track");
		arrLabels[6]=new JLabel("Genre");
		for(i=0; i<7; ++i){
//			arrLabels[0].setSize(dimLabel);
		}
		arrTxtFields=new JTextField[7];
		for(i=0; i<7; ++i){
			arrTxtFields[i]=new JTextField();
//			arrTxtFields[i].setSize(dimTxt);
			arrTxtFields[i].setEditable(false);
		}
		group=layout.createSequentialGroup();
		parallel=layout.createParallelGroup(Alignment.LEADING);
		for(i=0; i<7; ++i){
//			parallel.addComponent(arrLabels[i], GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE);
			parallel.addComponent(arrLabels[i]);
		}
//		group.addGap(5);
		group.addGroup(parallel);
		parallel=layout.createParallelGroup(Alignment.LEADING);
		for(i=0; i<7; ++i){
//			parallel.addComponent(arrTxtFields[i], GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE);
			parallel.addComponent(arrTxtFields[i]);
		}
//		group.addGap(5);
		group.addGroup(parallel);
//		group.addContainerGap();
//		group.addGap(5);
		layout.linkSize(SwingConstants.VERTICAL, arrLabels);
		layout.linkSize(SwingConstants.VERTICAL, arrTxtFields);
		layout.setHorizontalGroup(group);
		group=layout.createSequentialGroup();
		for(i=0; i<7; ++i){
			parallel=layout.createParallelGroup(Alignment.LEADING);
//			parallel.addComponent(arrLabels[i], GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE);
//			parallel.addComponent(arrTxtFields[i], GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE);
			parallel.addComponent(arrLabels[i]);
			parallel.addComponent(arrTxtFields[i]);
//			group.addGap(10);
			group.addGroup(parallel);
		}
//		group.addContainerGap();
//		group.addGap(10);
		layout.setVerticalGroup(group);
		mapManagerTxt.put("ID3V1INFO", arrTxtFields);
		mapTabPane.put("ID3V1", panelInTab);
		tabbedPane.addTab("ID3V1", panelInTab);
		
		initTabID3V1Pane();
		initTabID3V2Pane();
		initTabAPEV2Pane();
		initTabLYRICS3V2Pane();
	}
	
	private void initTabID3V1Pane() {
		
	}
	
	private void initTabID3V2Pane(){
		int i;
		JPanel panel;
		JLabel[] arrLabels;
		JTextField[] arrTxtFields;
		JButton btnPic;
		TitledBorder border;
		Dimension dimPic;
		GroupLayout layout;
		SequentialGroup sg;
		ParallelGroup pg;
		panel=new JPanel();
		layout=new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panel.setLayout(layout);
		
		arrLabels=new JLabel[5];
		arrLabels[0]=new JLabel("Version");
		arrLabels[1]=new JLabel("Title");
		arrLabels[2]=new JLabel("Performer");
		arrLabels[3]=new JLabel("Ablum");
		arrLabels[4]=new JLabel("Picture");
		arrTxtFields=new JTextField[4];
		for(i=0; i<4; ++i){
			arrTxtFields[i]=new JTextField();
			arrTxtFields[i].setEditable(false);
		}
		/** Temporary solution, so far it has not been explicit how to separate text  ***/
		dimPic=new Dimension(220, 220);
		border=new TitledBorder("Attached Picture");
//		border.setTitleJustification(10);
		btnPic=new JButton();
//		btnPic.setRequestFocusEnabled(false);
//		btnPic.setPreferredSize(dimPic);
//		btnPic.setSize(dimPic);
		btnPic.setBorder(border);
		btnPic.setMinimumSize(dimPic);
		btnPic.setMaximumSize(dimPic);
		btnPic.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPic.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnPic.setHorizontalAlignment(SwingConstants.CENTER);
//		btnPic.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPic.setContentAreaFilled(false);
		/*
		layout.linkSize(SwingConstants.VERTICAL, arrLabels);
		layout.linkSize(SwingConstants.VERTICAL, arrTxtFields);*/
		/**start to layout horizontal**/
		sg=layout.createSequentialGroup();
		pg=layout.createParallelGroup(Alignment.LEADING);
		for (i=0; i<5; ++i) {
			pg.addComponent(arrLabels[i]);
		}
		sg.addGroup(pg);
		pg=layout.createParallelGroup(Alignment.LEADING);
		for (i=0; i<4; ++i) {
			pg.addComponent(arrTxtFields[i]);
		}
		pg.addComponent(btnPic);
		sg.addGroup(pg);
		layout.setHorizontalGroup(sg);
		/**end to layout horizontal**/
		/**start to layout vertical**/
		sg=layout.createSequentialGroup();
		for(i=0; i<4; ++i){
			pg=layout.createParallelGroup(Alignment.BASELINE);
			pg.addComponent(arrLabels[i]);
			pg.addComponent(arrTxtFields[i]);
//			layout.linkSize(SwingConstants.VERTICAL, arrLabels[i]);
			layout.linkSize(SwingConstants.VERTICAL, arrTxtFields[i]);
			sg.addGroup(pg);
		}
		pg=layout.createParallelGroup(Alignment.LEADING);
		pg.addComponent(arrLabels[4]);
		pg.addComponent(btnPic);
		sg.addGroup(pg);
		layout.setVerticalGroup(sg);
		/**end to layout vertical**/
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setViewportView(panel);
		
		mapManagerTxt.put("ID3V2INFO", arrTxtFields);
		mapManagerPic.put("ID3V2", btnPic);
		mapTabPane.put("ID3V2", panel);
		tabbedPane.addTab("ID3V2", scrollPane);
	}
	
	private void initTabAPEV2Pane() {
		JPanel panel;
		GroupLayout layout;
		
		panel=new JPanel(true);
		layout=new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panel.setLayout(layout);
		mapTabPane.put("APEV2", panel);
		tabbedPane.addTab("APEV2", panel);
	}
	
	private void initTabLYRICS3V2Pane() {
		GroupLayout layout;
		JScrollPane scrollPane;
		JPanel panel;
		JTextArea txtArea;
		SequentialGroup sg;
		ParallelGroup pg;
		
		panel=new JPanel();
		txtArea=new JTextArea();
		txtArea.setEditable(false);
		txtArea.setLineWrap(true);
		scrollPane=new JScrollPane(txtArea);
		panel.add(scrollPane);
		layout=new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panel.setLayout(layout);
		
		sg=layout.createSequentialGroup();
		pg=layout.createParallelGroup();
		pg.addComponent(scrollPane);
		sg.addGroup(pg);
		layout.setHorizontalGroup(sg);
		sg=layout.createSequentialGroup();
		pg=layout.createParallelGroup();
		pg.addComponent(scrollPane);
		sg.addGroup(pg);
		layout.setVerticalGroup(sg);
		
		tabbedPane.add("LYRICS3V2", panel);
		mapManagerTxtArea.put("LYRICS3V2", txtArea);
	}
	
	private void initListener() {
		addWindowListener(this);
		btnOpen.addActionListener(this);
		btnOption.addActionListener(this);
	}
	
	private void initFileChooser() {
		String strDirCur;
		File dirCur;
		FileFilter filter;
		filter=new FileNameExtensionFilter("MP3 Audio File(*.mp3)", new String[]{"mp3"});
		fileChooser=new JFileChooser();
//		fileChooser.changeToParentDirectory();
		fileChooser.setFileFilter(filter);
//		fileChooser.setApproveButtonText("Please select a mp3 audio file");
		strDirCur=xmlParser.getElementValue("initialFileChoosePath");
		if (strDirCur!=null) {
			dirCur=new File(strDirCur);
			fileChooser.setCurrentDirectory(dirCur);
		}
	}
	
	private void loadID3V1() {
		JTextField[]arrTxtFields;
		tagID3V1=tagParser.getID3V1Info();
		if (tagID3V1==null) {
			return;
		}
		arrTxtFields=mapManagerTxt.get("ID3V1INFO");
		arrTxtFields[0].setText(tagID3V1.getTitle());
		arrTxtFields[1].setText(tagID3V1.getPerformer());
		arrTxtFields[2].setText(tagID3V1.getAlbum());
		arrTxtFields[3].setText(tagID3V1.getYear());
		arrTxtFields[4].setText(tagID3V1.getComment());
		arrTxtFields[5].setText(String.valueOf(tagID3V1.getTrack() & 0xffffffff));
		arrTxtFields[6].setText(tagID3V1.getGenre());
	}
	
	private void loadID3V2() {
		String strValue;
		JTextField[]arrTxtFields;
		JButton btnPic;
		TitledBorder border;
		TagID3V2ImageBean imageBean;
		Image image, imageShow;
		Icon icon;
		int width, height, widthShow, heightShow;
		tagID3V2=tagParser.getID3V2Info();
		if (tagID3V2==null) {
			return;
		}
		arrTxtFields=mapManagerTxt.get("ID3V2INFO");
		arrTxtFields[0].setText(String.valueOf(tagID3V2.getVersion()));
		if ((strValue=tagID3V2.getTextFrame("TIT2"))!=null) {
			arrTxtFields[1].setText(strValue);
		}
		if ((strValue=tagID3V2.getTextFrame("TPE1"))!=null) {
			arrTxtFields[2].setText(strValue);
		}
		if ((strValue=tagID3V2.getTextFrame("TALB"))!=null) {
			arrTxtFields[3].setText(strValue);
		}
		imageBean=tagID3V2.getImageFrame();
		if (imageBean!=null) {
			btnPic=mapManagerPic.get("ID3V2");
			border=(TitledBorder)btnPic.getBorder();
			border.setTitle(imageBean.getPicType());
//			icon=new ImageIcon(getIconImage());
			image=imageBean.getImage();
			width=image.getWidth(null);
			height=image.getHeight(null);
			if (width <=200 && height <=200) {
				widthShow=width;
				heightShow=height;
				imageShow=image;
			}
			else {
				if (width==height) {
					widthShow=200;
					heightShow=200;
				} else if (width>height) {
					widthShow=200;
					heightShow=widthShow * height / width;
				} else {
					heightShow=200;
					widthShow=heightShow * width / height;
				}
				imageShow=image.getScaledInstance(widthShow, heightShow, Image.SCALE_AREA_AVERAGING);
			}
			icon=new ImageIcon(imageShow);
			btnPic.setIcon(icon);
		}
	}
	
	private void loadAPEV2() {
		JLabel label;
		JTextField txtField;
		TagAPEV2FrameBean bean;
		JPanel panel;
		GroupLayout layout;
		SequentialGroup sgh, sgv;
		ParallelGroup pgv, pghl, pght;
		int i, count;
		tagAPEV2=tagParser.getAPEV2Info();
		if (tagAPEV2==null) {
			return;
		}
		count=tagAPEV2.count();
/*		arrLabels=new JLabel[count];
		arrTxtFields=new JTextField[count];*/
		panel=mapTabPane.get("APEV2");
		layout=(GroupLayout)panel.getLayout();
		sgh=layout.createSequentialGroup();
		sgv=layout.createSequentialGroup();
		pghl=layout.createParallelGroup();
		pght=layout.createParallelGroup();
		for(i=0; i<count; ++i){
			bean=tagAPEV2.getFrame(i);
			label=new JLabel(bean.getFrameID());
			txtField=new JTextField(bean.getContent());
			txtField.setEditable(false);
			pgv=layout.createParallelGroup(Alignment.LEADING);
			pgv.addComponent(label);
			pgv.addComponent(txtField);
			sgv.addGroup(pgv);
			pghl.addComponent(label);
			pght.addComponent(txtField);
/*			arrLabels[i]=label;
			arrTxtFields[i]=txtField;*/
			layout.linkSize(label);
			layout.linkSize(SwingConstants.VERTICAL, txtField);
		}
/*		layout.linkSize(arrLabels);
		layout.linkSize(SwingConstants.VERTICAL, arrTxtFields);*/
		sgh.addGroup(pghl);
		sgh.addGroup(pght);
		layout.setHorizontalGroup(sgh);
		layout.setVerticalGroup(sgv);
	}
	
	private void loadLYRICS3V2() {
		JTextArea txtArea;
		int i, length;
		tagLYRICS3V2=tagParser.getLYRICS3V2Info();
		if (tagLYRICS3V2==null) {
			return;
		}
		txtArea=mapManagerTxtArea.get("LYRICS3V2");
		length=tagLYRICS3V2.count();
		txtArea.setRows(length);
		for (i=0; i<length; ++i) {
			//txtArea.insert(tagLYRICS3V2.contentAt(i), i);
			txtArea.append(tagLYRICS3V2.contentAt(i));
			txtArea.append("\r\n");	//it seems that all of \r\n \n\r \n have the same effect, but \r doesn't
		}
	}
	
	private class LoadTagsThread extends Thread{
		LoadTagsThread(){
			super();
		}

		@Override
		public void run() {
			super.run();
			MainFrame.this.tagParser.readTags(fileChooser.getSelectedFile());
			MainFrame.this.loadID3V1();
			MainFrame.this.loadID3V2();
			MainFrame.this.loadAPEV2();
			MainFrame.this.loadLYRICS3V2();
		}	
	}
}
