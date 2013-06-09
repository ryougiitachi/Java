package per.itachi.test.music;

import java.awt.Image;

public class TagID3V2ImageBean {

	private String mimeType;
	private String picType;
	private String description;
	private Image image;
		
	public TagID3V2ImageBean() {
		
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getPicType() {
		return picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description.trim();
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
