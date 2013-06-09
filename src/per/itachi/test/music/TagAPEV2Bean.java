package per.itachi.test.music;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
/**
 * A bit troubling, but not better yet.
 * 
 * */
public class TagAPEV2Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2648866093056693656L;
	private int count;
	private List<TagAPEV2FrameBean> list;
	private Iterator<TagAPEV2FrameBean> iterator;

	public TagAPEV2Bean() {
		count=0;
		list=new Vector<>(8);
		iterator=list.iterator();
	}
	
	public int count() {
		return count;
	}
	
	public void addFrame(String id, String content) {
		TagAPEV2FrameBean bean=new TagAPEV2FrameBean();
		bean.setFrameID(id);
		bean.setContent(content);
		list.add(bean);
		++count;
	}
	
	public void addFrame(TagAPEV2FrameBean bean)  {
		list.add(bean);
		++count;
	}
	/** not good solution */
	public TagAPEV2FrameBean getFrame(int index) {
/*		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}*/
		return list.get(index);
	}

	@Override
	protected void finalize() throws Throwable {
		list.clear();
		list=null;
		super.finalize();
	}

}
