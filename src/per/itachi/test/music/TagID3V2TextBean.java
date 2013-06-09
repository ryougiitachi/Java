package per.itachi.test.music;

import java.io.Serializable;

public class TagID3V2TextBean implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -579394715725813671L;
	private String description;
	private String value;

	public TagID3V2TextBean() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.trim();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value.trim();
	}

}
