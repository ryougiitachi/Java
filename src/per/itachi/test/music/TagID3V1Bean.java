package per.itachi.test.music;

public class TagID3V1Bean {

	private String title;
	private String performer;
	private String album;
	private String year;
	private String comment;
	private byte track;
	private byte genreNum;
	private String genre;
	
	public TagID3V1Bean() {
		track=0;
		genre="";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title.trim();
	}

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer.trim();
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album.trim();
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment.trim();
	}

	public byte getGenreNum() {
		return genreNum;
	}

	public void setGenreNum(byte genreNum) {
		this.genreNum = genreNum;
	}

	public byte getTrack() {
		return track;
	}

	public void setTrack(byte track) {
		this.track = track;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		if (genre!=null) {
			this.genre = genre;
		}
	}

	@Override
	protected void finalize() throws Throwable {
		title=null;
		performer=null;
		album=null;
		year=null;
		comment=null;
		genre=null;
		super.finalize();
	}
}
