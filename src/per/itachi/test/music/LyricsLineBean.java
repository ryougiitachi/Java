package per.itachi.test.music;

public class LyricsLineBean {
	
	private int offset;
	private int length;
	private String content;

	public LyricsLineBean() {
		offset=0;
		length=0;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		content=null;
	}

}
