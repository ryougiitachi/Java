package per.itachi.test.music;

public class TagID3V2Parser {
	
	public TagID3V2Parser() {
		
	}
	
	private int lengthByteToStr(byte[] byteData, int offset){
		int length=byteData.length;
		switch (byteData[0]) {
		case 0x01:
		case 0x02:
			for (length=0;byteData[length+offset]!=0 || byteData[length+offset+1]!=0;length+=2);
			break;
		case 0x00:
		case 0x03:
			for (length=0;byteData[length+offset]!=0;++length);
			break;
		default:
			break;
		}
		return length;
	}
}
