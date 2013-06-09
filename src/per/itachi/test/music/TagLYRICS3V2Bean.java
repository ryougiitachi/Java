package per.itachi.test.music;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TagLYRICS3V2Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2391540913571860491L;
	private int pos;
	private List<LyricsLineBean> listLrcs;

	public TagLYRICS3V2Bean() {
		pos=0;
		listLrcs=new ArrayList<>(32);
	}
	
	public boolean addLine(String strLine) {
		LyricsLineBean bean;
		bean=new LyricsLineBean();
		bean.setContent(strLine);
		return addLine(bean);
	}
	
	public boolean addLine(LyricsLineBean bean) {
		if (bean!=null) {
			return listLrcs.add(bean);
		} else {
			return false;
		}
	}
	
	public int count() {
		return listLrcs.size();
	}
	
	public String contentAt(int index) {
		return beanAt(index).getContent();
	}
	
	public LyricsLineBean beanAt(int index) {
		pos=index;
		return listLrcs.get(index);
	}
	
	public int position() {
		return pos;
	}

	@Override
	protected void finalize() throws Throwable {
		listLrcs.clear();
		listLrcs=null;
		super.finalize();
	}
}
