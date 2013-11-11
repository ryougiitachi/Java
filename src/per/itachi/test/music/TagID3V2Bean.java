package per.itachi.test.music;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TagID3V2Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6551915749754196837L;
	private int version;
	private int reversion;
	private Map<String, String> mapTextFrames;
	private Map<String, String> mapURLFrames;
	private Map<String, TagID3V2TextBean> mapUserFrames;
	private TagID3V2ImageBean imageBean;

	public TagID3V2Bean() {
		mapTextFrames=new HashMap<String, String>( );
		mapURLFrames=new HashMap<>();
		mapUserFrames=new HashMap<>();
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(byte version) {
		this.version = version & 0xffffffff;
	}

	public int getReversion() {
		return reversion;
	}

	public void setReversion(int reversion) {
		this.reversion = reversion & 0xffffffff;
	}
	
	public void addTextFrame(String id, String value) {
		String strValue;
		StringBuffer strbuf;
		strValue=mapTextFrames.get(id);
		if (strValue==null) {
			mapTextFrames.put(id, value);
		}
		else {
			strbuf=new StringBuffer(strValue);
			strbuf.append(value);
			mapTextFrames.put(id, strbuf.toString());
		}
	}
	
	public void addURLFrame(String id, String value) {
		String strValue;
		strValue=mapURLFrames.get(id);
		if (strValue==null) {
			mapURLFrames.put(id, value);
		}
		else {
			System.out.println("Duplicate URL added");
		}
	}
	
	public void addUserFrame(String id, TagID3V2TextBean bean){
		if (id==null || id.length()==0) {
			return;
		}
		mapUserFrames.put(id, bean);
	}
	
	public String getTextFrame(String id) {
		return mapTextFrames.get(id);
	}
	
	public String getURLFrame(String id) {
		return mapURLFrames.get(id);
	}
	
	public Set<String> getFrameIDs() {
		return mapTextFrames.keySet();
	}

	public TagID3V2ImageBean getImageFrame() {
		return imageBean;
	}

	public void setImageFrame(TagID3V2ImageBean imageBean) {
		this.imageBean = imageBean;
	}
}
