package per.itachi.test.music;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

public class MP3AudioTagParser {

	private String strHeaderID3v1;
	private byte[] byteHeaderID3v1;
	private Map<Integer, String> mapGenre;
	private Map<byte[], String> mapID3V2Lang;
	
	private String strFrameAENC;
	private String strFrameAPIC;
	private String strFrameCOMM;
	private String strFrameCOMR;
	private String strFrameENCR;
	private String strFrameEQUA;
	private String strFrameETCO;
	private String strFrameGEOB;
	private String strFrameGRID;
	private String strFrameIPLS;
	private String strFrameLINK;
	private String strFrameMCDI;
	private String strFrameMLLT;
	private String strFrameOWNE;
	private String strFramePRIV;
	private String strFramePCNT;
	private String strFramePOPM;
	private String strFramePOSS;
	private String strFrameRBUF;
	private String strFrameRVAD;
	private String strFrameRVRB;
	private String strFrameSYLT;
	private String strFrameSYTC;
	private String strFrameTALB;
	private String strFrameTBPM;
	private String strFrameTCOM;
	private String strFrameTCON;
	private String strFrameTCOP;
	private String strFrameTDAT;
	private String strFrameTDLY;
	private String strFrameTENC;
	private String strFrameTEXT;
	private String strFrameTFLT;
	private String strFrameTIME;
	private String strFrameTIT1;
	private String strFrameTIT2;
	private String strFrameTIT3;
	private String strFrameTKEY;
	private String strFrameTLAN;
	private String strFrameTLEN;
	private String strFrameTMED;
	private String strFrameTOAL;
	private String strFrameTOFN;
	private String strFrameTOLY;
	private String strFrameTOPE;
	private String strFrameTORY;
	private String strFrameTOWN;
	private String strFrameTPE1;
	private String strFrameTPE2;
	private String strFrameTPE3;
	private String strFrameTPE4;
	private String strFrameTPOS;
	private String strFrameTPUB;
	private String strFrameTRCK;
	private String strFrameTRDA;
	private String strFrameTRSN;
	private String strFrameTRSO;
	private String strFrameTSIZ;
	private String strFrameTSRC;
	private String strFrameTSSE;
	private String strFrameTYER;
	private String strFrameTXXX;
	private String strFrameUFID;
	private String strFrameUSER;
	private String strFrameUSLT;
	private String strFrameWCOM;
	private String strFrameWCOP;
	private String strFrameWOAF;
	private String strFrameWOAR;
	private String strFrameWOAS;
	private String strFrameWORS;
	private String strFrameWPAY;
	private String strFrameWPUB;
	private String strFrameWXXX;
	
	private byte[] byteFrameAENC;
	private byte[] byteFrameAPIC;
	private byte[] byteFrameCOMM;
	private byte[] byteFrameCOMR;
	private byte[] byteFrameENCR;
	private byte[] byteFrameEQUA;
	private byte[] byteFrameETCO;
	private byte[] byteFrameGEOB;
	private byte[] byteFrameGRID;
	private byte[] byteFrameIPLS;
	private byte[] byteFrameLINK;
	private byte[] byteFrameMCDI;
	private byte[] byteFrameMLLT;
	private byte[] byteFrameOWNE;
	private byte[] byteFramePRIV;
	private byte[] byteFramePCNT;
	private byte[] byteFramePOPM;
	private byte[] byteFramePOSS;
	private byte[] byteFrameRBUF;
	private byte[] byteFrameRVAD;
	private byte[] byteFrameRVRB;
	private byte[] byteFrameSYLT;
	private byte[] byteFrameSYTC;
	private byte[] byteFrameTALB;
	private byte[] byteFrameTBPM;
	private byte[] byteFrameTCOM;
	private byte[] byteFrameTCON;
	private byte[] byteFrameTCOP;
	private byte[] byteFrameTDAT;
	private byte[] byteFrameTDLY;
	private byte[] byteFrameTENC;
	private byte[] byteFrameTEXT;
	private byte[] byteFrameTFLT;
	private byte[] byteFrameTIME;
	private byte[] byteFrameTIT1;
	private byte[] byteFrameTIT2;
	private byte[] byteFrameTIT3;
	private byte[] byteFrameTKEY;
	private byte[] byteFrameTLAN;
	private byte[] byteFrameTLEN;
	private byte[] byteFrameTMED;
	private byte[] byteFrameTOAL;
	private byte[] byteFrameTOFN;
	private byte[] byteFrameTOLY;
	private byte[] byteFrameTOPE;
	private byte[] byteFrameTORY;
	private byte[] byteFrameTOWN;
	private byte[] byteFrameTPE1;
	private byte[] byteFrameTPE2;
	private byte[] byteFrameTPE3;
	private byte[] byteFrameTPE4;
	private byte[] byteFrameTPOS;
	private byte[] byteFrameTPUB;
	private byte[] byteFrameTRCK;
	private byte[] byteFrameTRDA;
	private byte[] byteFrameTRSN;
	private byte[] byteFrameTRSO;
	private byte[] byteFrameTSIZ;
	private byte[] byteFrameTSRC;
	private byte[] byteFrameTSSE;
	private byte[] byteFrameTYER;
	private byte[] byteFrameTXXX;
	private byte[] byteFrameUFID;
	private byte[] byteFrameUSER;
	private byte[] byteFrameUSLT;
	private byte[] byteFrameWCOM;
	private byte[] byteFrameWCOP;
	private byte[] byteFrameWOAF;
	private byte[] byteFrameWOAR;
	private byte[] byteFrameWOAS;
	private byte[] byteFrameWORS;
	private byte[] byteFrameWPAY;
	private byte[] byteFrameWPUB;
	private byte[] byteFrameWXXX;

	private String strLyrics3Header;
	private String strLyrics3Footer;
	
	private byte[] byteLyrics3Header;
	private byte[] byteLyrics3Footer;
	
	private String strHeaderAPEv2;
	
	private byte[] byteHeaderAPEv2;
	
	private String strHeaderID3v2;
	private String strTagTitle;
	private String strTagArtist;
	private String strTagAlbum;
	private String strTagTrack;
	private String strTagYear;
	private String strTagCon;
	private String strTagComment;

	private byte[] byteHeaderID3v2;
	private byte[] byteTagTitle;
	private byte[] byteTagArtist;
	private byte[] byteTagAlbum;
	private byte[] byteTagTrack;
	private byte[] byteTagYear;
	private byte[] byteTagCon;
	private byte[] byteTagComment;
	
	private TagID3V1Bean tagID3V1;
	private TagID3V2Bean tagID3V2;
	private TagAPEV2Bean tagAPEV2;
	private TagLYRICS3V2Bean tagLYRICS3V2;
	
	public MP3AudioTagParser(){
		initDeprecated();
		initID3v1Header();
		initGenreMap();
		initID3v2FrameID();
		initID3v2Lang();
		initLyrics3Header();
		initAPEHeader();
	}
	/** Temporary solution until a better one appears ****/
	public void readTags(String path) {
		if (path==null || path.length()==0) {
			return;
		}
		File file=new File(path);
		readTags(file);
	}
	
	public void readTags(File file) {
		RandomAccessFile raf;
		int offset;
		long fileLength;
		if (!file.exists() || !file.isFile()) {		//!(file.exists() && file.isFile())
			return;
		}
		try {
			raf=new RandomAccessFile(file, "r");
			fileLength=raf.length();
			readTagID3v2(raf);
			if (readTagID3v1(raf)) {
				System.out.println("startv1 "+raf.getFilePointer());
				raf.seek(fileLength-128l);
				System.out.println("endv1 "+raf.getFilePointer());
			}
			if ((offset=readTagLyrics3v2(raf))!=0) {
				raf.seek(raf.getFilePointer()-offset);
			}
			readTagAPEv2(raf);
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean readTagID3v1(RandomAccessFile raf) throws Exception{
		byte[] byteHeaderTmp;
		byte[] byteData;
		TagID3V1Bean bean;
		byteHeaderTmp=new byte[3];
		raf.seek(raf.length()-128l);
		raf.read(byteHeaderTmp);
		if (!Arrays.equals(byteHeaderTmp, byteHeaderID3v1)) {
			bean=null;
			return false;
		}
		byteData=new byte[125];
		bean=new TagID3V1Bean();
		raf.read(byteData);
		bean.setTitle(new String(byteData, 0, 30, "gbk"));
		bean.setPerformer(new String(byteData, 30, 30, "gbk"));
		bean.setAlbum(new String(byteData, 60, 30, "gbk"));
		bean.setYear(new String(byteData, 90, 4, "gbk"));
		if (byteData[122]==1) {
			bean.setComment(new String(byteData, 94, 28, "gbk"));
			bean.setTrack(byteData[123]);
		}
		else {
			bean.setComment(new String(byteData, 94, 30, "gbk"));
		}
		bean.setGenreNum(byteData[124]);
		bean.setGenre(mapGenre.get(byteData[124] & 0xffffffff));
//		System.out.println("Reserve	:"+byteData[122]);
//		System.out.println("Track		:"+byteData[123]);
		System.out.println("Title		:"+bean.getTitle());
		System.out.println("Performer	:"+bean.getPerformer());
		System.out.println("Album		:"+bean.getAlbum());
		System.out.println("Year		:"+bean.getYear());
		System.out.println("Comment		:"+bean.getComment());
		System.out.println("Track		:"+bean.getTrack());
		System.out.println("Genre		:"+bean.getGenre());
		tagID3V1=bean;
		return true;
	}
	
	public void readTagID3v2(RandomAccessFile raf) throws Exception {
		byte[] byteHeaderTmp;
		byte[] byteSize;
		int i, iHeaderSize=0, iHeaderLeft;
		byteHeaderTmp=new byte[3];
		raf.read(byteHeaderTmp);
		if (!Arrays.equals(byteHeaderTmp, byteHeaderID3v2)) {
			return;
		}
		System.out.println("There is a ID3v2 found");
		byteSize=new byte[4];
		raf.read(byteHeaderTmp);
		raf.read(byteSize);
		for(i=0; i<4; ++i){
			iHeaderSize<<=7;
			iHeaderSize|=byteSize[i];
		}
		System.out.println("The size of id3v2 header is "+ iHeaderSize);
		tagID3V2=new TagID3V2Bean();
		tagID3V2.setVersion(byteHeaderTmp[0]);
		tagID3V2.setReversion(byteHeaderTmp[1]);
		System.out.println("The version of id3v2 is "+ tagID3V2.getVersion());
		iHeaderLeft=iHeaderSize-10;
		switch (byteHeaderTmp[0]) {
		case 0x01:
			break;
		case 0x02:
			readTagID3v22(raf, iHeaderLeft);
			break;
		case 0x03:
			readTagID3v23(raf, iHeaderLeft);
			break;
		case 0x04:
			readTagID3v24(raf, iHeaderLeft);
			break;
		default:
			break;
		}
	}
	
	private void readTagID3v22(RandomAccessFile raf, int iHeaderLeft) throws Exception {
		byte[] byteHeaderTmp;
		byte[] byteFrameSize;
		byte[] byteData;
		byte[] byteLang;
		String strCharset;
		String strValue, strDesc;
		int iFrameSize, iDataSize=1024;
		int iLenInfo;
		byteHeaderTmp=new byte[3];
		byteFrameSize=new byte[3];
		byteData=new byte[iDataSize];
		byteLang=new byte[3];
		while (iHeaderLeft!=0) {
			raf.read(byteHeaderTmp);
			raf.read(byteFrameSize);
			iFrameSize=(byteFrameSize[0] & 0xff)<<16 |
					(byteFrameSize[1] & 0xff)<<8 |
					byteFrameSize[2] & 0xff;
			iHeaderLeft-=6+iFrameSize;
			iHeaderLeft-=iFrameSize;
			if (iFrameSize==0) {
				System.out.println("There is no more id3v22 tag frame.");
				iHeaderLeft=0;
			}
			else if (byteHeaderTmp[0]==('T' & 0xff)) {
				raf.read(byteData, 0, iFrameSize);
				strCharset=checkID3v2FrameEncode(byteData[0]);
				if (Arrays.equals(byteHeaderTmp, TagID3V22Constants.BYTES_FRAME_ID_TXX)) {
					for (iLenInfo=0; byteData[iLenInfo+1]!=0; ++iLenInfo) ;
					strDesc=new String(byteData, 1, iLenInfo, strCharset);
					strValue=new String(byteData, iLenInfo+2, iFrameSize-iLenInfo-2, strCharset);
				} else {
					strValue=new String(byteData, 1, iFrameSize-1, strCharset);
					tagID3V2.addTextFrame(strFrameTXXX, strValue);
				}
				System.out.println(new String(byteHeaderTmp, "utf-8")+" "+new String(byteData, 1, iFrameSize-1, strCharset));
			}
			else if (byteHeaderTmp[0]==('W' & 0xff)) {
				raf.read(byteData, 0, iFrameSize);
				System.out.println(new String(byteHeaderTmp, "utf-8")+" "+new String(byteData, 0, iFrameSize, "iso-8859-1"));
			}
			else if (byteHeaderTmp[0]==('M' & 0xff)) {
				raf.read(byteData, 0, iFrameSize);
				System.out.println(new String(byteHeaderTmp, "utf-8"));
			}
			else if (Arrays.equals(byteHeaderTmp, TagID3V22Constants.BYTES_FRAME_ID_PIC)) {
				raf.read(byteData, 0, iFrameSize);
				System.out.println("PIC");
			}
			else if (Arrays.equals(byteHeaderTmp, TagID3V22Constants.BYTES_FRAME_ID_COM)) {
				byte byteSingle;
				String strCom;
				byteSingle=raf.readByte();
				raf.read(byteLang);
/*				raf.read(byteData, 0, iFrameSize);
				byteLang=Arrays.copyOf(byteData, 3);*/
				iFrameSize-=4;
				strCharset=mapID3V2Lang.get(byteLang);
				if(strCharset==null){
					strCharset=checkID3v2FrameEncode(byteSingle);
				}
				for (iLenInfo=0; (byteSingle=raf.readByte())!=0; ++iLenInfo) {
					byteData[iLenInfo]=byteSingle;
				}
				iFrameSize-=iLenInfo+1;
				strDesc=new String(byteData, 0, iLenInfo, strCharset);
				raf.read(byteData, 0, iFrameSize);
				strCom=new String(byteData, 0, iFrameSize, strCharset);
				System.out.println(TagID3V22Constants.STR_FRAME_ID_COM);
				System.out.println(strDesc);
				System.out.println(strCom);
			}
			else {
				raf.read(byteData, 0, iFrameSize);
				System.out.println(new String(byteHeaderTmp,"utf-8"));
			}
		}
	}
	
	private void readTagID3v23(RandomAccessFile raf, int iHeaderLeft) throws Exception {
		byte[] byteFrameID;
		byte[] byteData;
		int iFrameSize, iDataSize=1024;
		byteFrameID=new byte[4];
		byteData=new byte[iDataSize];
		while (iHeaderLeft!=0) {
			raf.read(byteFrameID);
			iFrameSize=raf.readInt();
			raf.skipBytes(2);
			iHeaderLeft-=10;
			iHeaderLeft-=iFrameSize;
			if (iFrameSize!=0) {
				if (iFrameSize>iDataSize) {
					iDataSize=iFrameSize;
					byteData=new byte[iDataSize];
				}
				raf.read(byteData, 0, iFrameSize);
				readTagID3v23Frame(byteFrameID, byteData, iFrameSize);
			}
			else {
				System.out.println("There is no more id3v2 tag frame.");
				iHeaderLeft=0;
			}
			/*
			else if (byteFrameID[0]==('T' & 0xff)) {
				raf.read(byteData, 0, iFrameSize);
				iTerminal=checkTerminal(byteData[0]);
				strCharset=checkID3v2FrameEncode(byteData[0]);
				if (Arrays.equals(byteFrameID, TagID3V23Constants.BYTES_FRAME_ID_TXXX)) {
					iLenInfo=checkBytesLength(byteData, byteData[0], 1);
					strDesc=new String(byteData, 1, iLenInfo, strCharset);
					strValue=new String(byteData, iLenInfo+iTerminal+1, iFrameSize-iLenInfo-iTerminal-1, strCharset);
					bean=new TagID3V2TextBean();
					bean.setDescription(strDesc);
					bean.setValue(strValue);
					tagID3V2.addUserFrame(strFrameTXXX, bean);
					System.out.println("TXXX");
					System.out.println(strDesc);
					System.out.println(strValue);
				} else {
					strFrameID=new String(byteFrameID, "ascii");
					strValue=new String(byteData, 1, iFrameSize-1, strCharset);
					tagID3V2.addTextFrame(strFrameID, strValue);
					System.out.println(strFrameID+" "+ strValue);
				}
			}
			else if (byteFrameID[0]==('W' & 0xff)) {
				raf.read(byteData, 0, iFrameSize);
				iTerminal=checkTerminal(byteData[0]);
				strCharset=checkID3v2FrameEncode(byteData[0]);
				if (Arrays.equals(byteFrameID, TagID3V23Constants.BYTES_FRAME_ID_WXXX)) {
					iLenInfo=checkBytesLength(byteData, byteData[0], 1);
					strDesc=new String(byteData, 1, iLenInfo, strCharset);
					strValue=new String(byteData, iLenInfo+iTerminal+1, iFrameSize-iLenInfo-iTerminal-1, strCharset);
					bean=new TagID3V2TextBean();
					bean.setDescription(strDesc);
					bean.setValue(strValue);
					tagID3V2.addUserFrame(TagID3V23Constants.STR_FRAME_ID_WXXX, bean);
					System.out.println(TagID3V23Constants.STR_FRAME_ID_WXXX);
					System.out.println(strDesc);
					System.out.println(strValue);
				} else {
					strFrameID=new String(byteFrameID, "ascii");
					strValue=new String(byteData, 1, iFrameSize-1, strCharset);
					tagID3V2.addURLFrame(strCharset, strValue);
					System.out.println(strFrameID+" "+ strValue);
				}
			}
			else if (Arrays.equals(byteFrameID, byteFrameAPIC)) {
				//Temporary solution, which maybe is not very good.
				int cursor=0;
				TagID3V2ImageBean imageBean;
				Image image;
				InputStream bais;
				String strMIME, strPicType;
				if (iFrameSize>iDataSize) {
					iDataSize=iFrameSize;
					byteData=new byte[iDataSize];
				}
				imageBean=new TagID3V2ImageBean();
				raf.read(byteData, 0, iFrameSize);
				System.out.println(TagID3V23Constants.STR_FRAME_ID_APIC+" length is "+iFrameSize);
				iTerminal=checkTerminal(byteData[0]);
				
				strCharset=checkID3v2FrameEncode(byteData[0]);
				++cursor;*/
				/*Unexpectedly, 0x00 does not work for byte!*/
/*				iLenInfo=checkBytesLength(byteData, (byte)3, cursor);				
				strMIME=new String(byteData, cursor, iLenInfo, "ascii");
				cursor+=iLenInfo+1;
				strPicType=checkID3v2PicType(byteData[cursor]);
				++cursor;
				iLenInfo=checkBytesLength(byteData, byteData[0], cursor);
				cursor+=iLenInfo+iTerminal;
				strDesc=new String(byteData, cursor, iLenInfo, strCharset);
				bais=new ByteArrayInputStream(byteData, cursor, iFrameSize-cursor);
				image=ImageIO.read(bais);
				
				imageBean.setMimeType(strMIME);
				imageBean.setPicType(strPicType);
				imageBean.setDescription(strDesc);
				imageBean.setImage(image);
				
				tagID3V2.setImageFrame(imageBean);
				System.out.println("MIME TYPE IS "+strMIME);
				System.out.println("PICTURE TYPE IS "+strPicType);
				System.out.println("DESCRIPTION IS "+strDesc);
			}
			else {
				raf.read(byteData, 0, iFrameSize);
				strCharset=checkID3v2FrameEncode(byteData[0]);
				System.out.println(new String(byteFrameID,"utf-8")+" "+new String(byteData, 1, iFrameSize-1, strCharset));
			}*/
		}
	}
	
	private void readTagID3v24(RandomAccessFile raf, int iHeaderLeft) throws Exception {
		byte[] byteFrameID;
		byte[] byteSize;
		byte[] byteZero;
		byte[] byteData;
		int iFrameSize=0, iDataSize=1024, i;
		byteFrameID=new byte[4];
		byteSize=new byte[4];
		byteZero=new byte[4];
		byteData=new byte[iDataSize];
		while (iHeaderLeft!=0) {
			raf.read(byteFrameID);
			raf.read(byteSize);
			raf.skipBytes(2);
			iHeaderLeft-=10;
			for(i=0; i<4; ++i){
				iFrameSize<<=7;
				iFrameSize|=byteSize[i];
			}
//			raf.read(byteData, 0, iFrameSize);
			iHeaderLeft-=iFrameSize;
			if (!Arrays.equals(byteFrameID, byteZero)) {
				if (iFrameSize>iDataSize) {
					iDataSize=iFrameSize;
					byteData=new byte[iDataSize];
				}
				raf.read(byteData, 0, iFrameSize);
				readTagID3v23Frame(byteFrameID, byteData, iFrameSize);
			}
			else {
				System.out.println("There is no more id3v2 tag frame.");
				iHeaderLeft=0;
			}
			iFrameSize=0;
		}
	}
	
	private void readTagID3v23Frame(byte[] byteFrameID, byte[] byteData, int iFrameSize) throws Exception{
		String strFrameID, strCharset, strDesc, strValue;
		int iLenInfo, iTerminal;
		TagID3V2TextBean bean;
		if (byteFrameID[0]==('T' & 0xff)) {
			iTerminal=checkTerminal(byteData[0]);
			strCharset=checkID3v2FrameEncode(byteData[0]);
			if (Arrays.equals(byteFrameID, TagID3V23Constants.BYTES_FRAME_ID_TXXX)) {
				iLenInfo=checkBytesLength(byteData, byteData[0], 1);
				strDesc=new String(byteData, 1, iLenInfo, strCharset);
				strValue=new String(byteData, iLenInfo+iTerminal+1, iFrameSize-iLenInfo-iTerminal-1, strCharset);
				bean=new TagID3V2TextBean();
				bean.setDescription(strDesc);
				bean.setValue(strValue);
				tagID3V2.addUserFrame(strFrameTXXX, bean);
				System.out.println("TXXX");
				System.out.println(strDesc);
				System.out.println(strValue);
			} else {
				strFrameID=new String(byteFrameID, "ascii");
				strValue=new String(byteData, 1, iFrameSize-1, strCharset);
				tagID3V2.addTextFrame(strFrameID, strValue);
				System.out.println(strFrameID+" "+ strValue);
			}
		}
		else if (byteFrameID[0]==('W' & 0xff)) {
			iTerminal=checkTerminal(byteData[0]);
			strCharset=checkID3v2FrameEncode(byteData[0]);
			if (Arrays.equals(byteFrameID, TagID3V23Constants.BYTES_FRAME_ID_WXXX)) {
				iLenInfo=checkBytesLength(byteData, byteData[0], 1);
				strDesc=new String(byteData, 1, iLenInfo, strCharset);
				strValue=new String(byteData, iLenInfo+iTerminal+1, iFrameSize-iLenInfo-iTerminal-1, strCharset);
				bean=new TagID3V2TextBean();
				bean.setDescription(strDesc);
				bean.setValue(strValue);
				tagID3V2.addUserFrame(TagID3V23Constants.STR_FRAME_ID_WXXX, bean);
				System.out.println(TagID3V23Constants.STR_FRAME_ID_WXXX);
				System.out.println(strDesc);
				System.out.println(strValue);
			} else {
				strFrameID=new String(byteFrameID, "ascii");
				strValue=new String(byteData, 1, iFrameSize-1, strCharset);
				tagID3V2.addURLFrame(strCharset, strValue);
				System.out.println(strFrameID+" "+ strValue);
			}
		}
		else if (Arrays.equals(byteFrameID, TagID3V23Constants.BYTES_FRAME_ID_COMM)) {
			iTerminal=checkTerminal(byteData[0]);
			strCharset=checkID3v2FrameEncode(byteData[0]);
			iLenInfo=checkBytesLength(byteData, byteData[0], 4);
			strDesc=new String(byteData, 4, iLenInfo, strCharset);
			strValue=new String(byteData, iLenInfo+iTerminal+4, iFrameSize-iLenInfo-iTerminal-4, strCharset);
			bean=new TagID3V2TextBean();
			bean.setDescription(strDesc);
			bean.setValue(strValue);
			tagID3V2.addUserFrame(TagID3V23Constants.STR_FRAME_ID_COMM, bean);
			System.out.println(TagID3V23Constants.STR_FRAME_ID_COMM+":");
			System.out.println(strDesc);
			System.out.println(strValue);
		}
		else if (Arrays.equals(byteFrameID, byteFrameAPIC)) {
			//Temporary solution, which maybe is not very good.
			int cursor=0;
			TagID3V2ImageBean imageBean;
			Image image;
			InputStream bais;
			String strMIME, strPicType;/*
			if (iFrameSize>iDataSize) {
				iDataSize=iFrameSize;
				byteData=new byte[iDataSize];
			}*/
			imageBean=new TagID3V2ImageBean();
			System.out.println(TagID3V23Constants.STR_FRAME_ID_APIC+" length is "+iFrameSize);
			iTerminal=checkTerminal(byteData[0]);
			
			strCharset=checkID3v2FrameEncode(byteData[0]);
			++cursor;
			/*Unexpectedly, 0x00 does not work for byte!*/
			iLenInfo=checkBytesLength(byteData, (byte)3, cursor);				
			strMIME=new String(byteData, cursor, iLenInfo, "ascii");
			cursor+=iLenInfo+1;
			strPicType=checkID3v2PicType(byteData[cursor]);
			++cursor;
			iLenInfo=checkBytesLength(byteData, byteData[0], cursor);
			cursor+=iLenInfo+iTerminal;
			strDesc=new String(byteData, cursor, iLenInfo, strCharset);
			bais=new ByteArrayInputStream(byteData, cursor, iFrameSize-cursor);
			image=ImageIO.read(bais);
			
			imageBean.setMimeType(strMIME);
			imageBean.setPicType(strPicType);
			imageBean.setDescription(strDesc);
			imageBean.setImage(image);
			
			tagID3V2.setImageFrame(imageBean);
			System.out.println("MIME TYPE IS "+strMIME);
			System.out.println("PICTURE TYPE IS "+strPicType);
			System.out.println("DESCRIPTION IS "+strDesc);
		}
		else {
			strCharset=checkID3v2FrameEncode(byteData[0]);
			System.out.println(new String(byteFrameID,"utf-8")+" "+new String(byteData, 1, iFrameSize-1, strCharset));
		}
	}
	
	public int readTagLyrics3v2(RandomAccessFile raf) throws Exception {
		byte[] byteFooterTmp;
		byte[] byteTagSize;
		byte[] byteData;
		int iTagSize, iLrcSize;
		String strLine;
		InputStream bais;
		Reader reader;
		BufferedReader br;
		raf.seek(raf.getFilePointer()-15l);
		System.out.println("start lrc "+raf.getFilePointer());
		byteTagSize=new byte[6];
		byteFooterTmp=new byte[9];
		raf.read(byteTagSize, 0, byteTagSize.length);
		raf.read(byteFooterTmp, 0, byteFooterTmp.length);
		if (!Arrays.equals(byteFooterTmp, byteLyrics3Footer)) {
			tagLYRICS3V2=null;
			return 0;
		}
		/** The size excludes the footer ***/
		tagLYRICS3V2=new TagLYRICS3V2Bean();
		iTagSize=byteStrToInt(byteTagSize, 0, byteTagSize.length);
		byteData=new byte[iTagSize];
		raf.seek(raf.getFilePointer()-iTagSize-15l);
		raf.read(byteData);
		iLrcSize=iTagSize-30;
		bais=new ByteArrayInputStream(byteData, 30, iLrcSize);
		reader=new InputStreamReader(bais, "gbk");
		br=new BufferedReader(reader);
		while ((strLine=br.readLine())!=null) {
			tagLYRICS3V2.addLine(strLine);
			System.out.println(strLine);
		}
		br.close();
		reader.close();
		br=null;
		reader=null;
		bais=null;
		byteData=null;
		byteTagSize=null;
		byteFooterTmp=null;
		return iTagSize;
	}
	
	public int readTagAPEv2(RandomAccessFile raf) throws Exception {
		byte[] byteHeaderTmp;
		byte[] byteID;
		byte[] byteData;
		byte[] byteFrameSize;
		TagAPEV2FrameBean bean;
		int iTagSize, iTagCount, i, iLenID, iLenData;
		byteHeaderTmp=new byte[8];
		raf.seek(raf.getFilePointer()-32l);
		raf.read(byteHeaderTmp);
		if (!Arrays.equals(byteHeaderTmp, byteHeaderAPEv2)) {
			return 0;
		}
		tagAPEV2=new TagAPEV2Bean();
		raf.read(byteHeaderTmp);
		/** including either header or footer ***/
		iTagSize=byteHeaderTmp[7] <<24 |
				(byteHeaderTmp[6] & 0xff) <<16 |
				(byteHeaderTmp[5] & 0xff) <<8 |
				(byteHeaderTmp[4] & 0xff);
		raf.read(byteHeaderTmp);
		iTagCount=byteHeaderTmp[3] <<24 |
				(byteHeaderTmp[2] & 0xff) <<16 |
				(byteHeaderTmp[1] & 0xff) <<8 |
				(byteHeaderTmp[0] & 0xff);
		raf.seek(raf.getFilePointer()+8l-iTagSize);
		byteID=new byte[32];
		byteData=new byte[512];
		byteFrameSize=new byte[8];
		for (i=0; i<iTagCount; ++i) {
			raf.read(byteFrameSize);
			iLenData=byteFrameSize[3] <<24 |
					(byteFrameSize[2] & 0xff) <<16 |
					(byteFrameSize[1] & 0xff) <<8 |
					(byteFrameSize[0] & 0xff);
			for (iLenID=0; (byteID[iLenID]=raf.readByte())!=0; ++iLenID) {
			}
			raf.read(byteData, 0, iLenData);
			bean=new TagAPEV2FrameBean();
			bean.setFrameID(new String(byteID, 0, iLenID, "utf-8"));
			bean.setContent(new String(byteData, 0, iLenData, "utf-8"));
			tagAPEV2.addFrame(bean);
			System.out.print(bean.getFrameID());
			System.out.println("		:"+bean.getContent());
		}
		return iTagSize;
	}
	
	public void readTagID3v2(String path) {
		File file=new File(path);
		InputStream fis, bis;
		byte[]byteHeader;
		byte[]byteTagSize;
		int iTagSize=0, i;
		if (file.exists() && file.isFile()) {
			try {
				fis=new FileInputStream(file);
				bis=new BufferedInputStream(fis);
				byteHeader=new byte[3];
				bis.read(byteHeader, 0, 3);
				if (Arrays.equals(byteHeader, byteHeaderID3v2)) {
					System.out.println("youtag");
					bis.skip(3l);
					byteTagSize=new byte[4];
					bis.read(byteTagSize, 0, 4);
					for (i=0; i<4; ++i) {
						iTagSize<<=7;
						iTagSize |=byteTagSize[i];
					}
					System.out.println(iTagSize);
				}
				bis.close();
				fis.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String checkID3v2FrameEncode(byte byteEncode) {
		switch (byteEncode) {
		case 0x00:
			return "iso-8859-1";
		case 0x01:
			return "utf-16le";
		case 0x02:
			return "utf-16be";
		case 0x03:
			return "utf-8";

		default:
			return "gbk";
		}
	}
	
	private String checkID3v2PicType(byte bytePicType) {
		switch (bytePicType) {
		case 0X00:
			return "Other";
		case 0X01:
			return "32x32 pixels 'file icon' (PNG only)";
		case 0X02:
			return "Other file icon";
		case 0X03:
			return "Cover (front)";
		case 0X04:
			return "Cover (back)";
		case 0X05:
			return "Leaflet page";
		case 0X06:
			return "Media (e.g. lable side of CD)";
		case 0X07:
			return "Lead artist/lead performer/soloist";
		case 0X08:
			return "Artist/performer";
		case 0X09:
			return "Conductor";
		case 0X0A:
			return "Band/Orchestra";
		case 0X0B:
			return "Composer";
		case 0X0C:
			return "Lyricist/text writer";
		case 0X0D:
			return "Recording Location";
		case 0X0E:
			return "During recording";
		case 0X0F:
			return "During performance";
		case 0X10:
			return "Movie/video screen capture";
		case 0X11:
			return "A bright coloured fish";
		case 0X12:
			return "Illustration";
		case 0X13:
			return "Band/artist logotype";
		case 0X14:
			return "Publisher/Studio logotype";

		default:
			return "Unknown";
		}
	}
	
	/**
	 * @param byteData
	 * @param byteCharset
	 * 				with which charset to recognise
	 * @param offset
	 * 				from which position to start
	 * @return
	 */
	private int checkBytesLength(byte[] byteData, byte byteCharset,int offset){
		int length=byteData.length;
		switch (byteCharset) {
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

	private int byteStrToInt(byte[] b, int offset, int len) {
		int result=0, i;
		for(i=offset; i<offset+len; ++i){
			result *=10;
			result +=(b[i]& 0xffffffff)-0x30;
		}
		return result;
	}
	
	private int checkTerminal(byte byteCharset){
		int length=0;
		switch (byteCharset) {
		case 0x01:
		case 0x02:
			length=2;
			break;
		case 0x00:
		case 0x03:
			length=1;
			break;
		default:
			break;
		}
		return length;
	}
	
	private void initID3v1Header() {
		strHeaderID3v1="TAG";
		try {
			byteHeaderID3v1=strHeaderID3v1.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initGenreMap() {
		mapGenre=new TreeMap<>();
		mapGenre.put(0,"Blues");
		mapGenre.put(1,"ClassicRock");
		mapGenre.put(2,"Country");
		mapGenre.put(3,"Dance");
		mapGenre.put(4,"Disco");
		mapGenre.put(5,"Funk");
		mapGenre.put(6,"Grunge");
		mapGenre.put(7,"Hip-Hop");
		mapGenre.put(8,"Jazz");
		mapGenre.put(9,"Metal");
		mapGenre.put(10,"NewAge");
		mapGenre.put(11,"Oldies");
		mapGenre.put(12,"Other");
		mapGenre.put(13,"Pop");
		mapGenre.put(14,"R&B");
		mapGenre.put(15,"Rap");
		mapGenre.put(16,"Reggae");
		mapGenre.put(17,"Rock");
		mapGenre.put(18,"Techno");
		mapGenre.put(19,"Industrial");
		mapGenre.put(20,"Alternative");
		mapGenre.put(21,"Ska");
		mapGenre.put(22,"DeathMetal");
		mapGenre.put(23,"Pranks");
		mapGenre.put(24,"Soundtrack");
		mapGenre.put(25,"Euro-Techno");
		mapGenre.put(26,"Ambient");
		mapGenre.put(27,"Trip-Hop");
		mapGenre.put(28,"Vocal");
		mapGenre.put(29,"Jazz+Funk");
		mapGenre.put(30,"Fusion");
		mapGenre.put(31,"Trance");
		mapGenre.put(32,"Classical");
		mapGenre.put(33,"Instrumental");
		mapGenre.put(34,"Acid");
		mapGenre.put(35,"House");
		mapGenre.put(36,"Game");
		mapGenre.put(37,"SoundClip");
		mapGenre.put(38,"Gospel");
		mapGenre.put(39,"Noise");
		mapGenre.put(40,"AlternRock");
		mapGenre.put(41,"Bass");
		mapGenre.put(42,"Soul");
		mapGenre.put(43,"Punk");
		mapGenre.put(44,"Space");
		mapGenre.put(45,"Meditative");
		mapGenre.put(46,"InstrumentalPop");
		mapGenre.put(47,"InstrumentalRock");
		mapGenre.put(48,"Ethnic");
		mapGenre.put(49,"Gothic");
		mapGenre.put(50,"Darkwave");
		mapGenre.put(51,"Techno-Industrial");
		mapGenre.put(52,"Electronic");
		mapGenre.put(53,"Pop-Folk");
		mapGenre.put(54,"Eurodance");
		mapGenre.put(55,"Dream");
		mapGenre.put(56,"SouthernRock");
		mapGenre.put(57,"Comedy");
		mapGenre.put(58,"Cult");
		mapGenre.put(59,"Gangsta");
		mapGenre.put(60,"Top40");
		mapGenre.put(61,"ChristianRap");
		mapGenre.put(62,"Pop/Funk");
		mapGenre.put(63,"Jungle");
		mapGenre.put(64,"NativeAmerican");
		mapGenre.put(65,"Cabaret");
		mapGenre.put(66,"NewWave");
		mapGenre.put(67,"Psychadelic");
		mapGenre.put(68,"Rave");
		mapGenre.put(69,"Showtunes");
		mapGenre.put(70,"Trailer");
		mapGenre.put(71,"Lo-Fi");
		mapGenre.put(72,"Tribal");
		mapGenre.put(73,"AcidPunk");
		mapGenre.put(74,"AcidJazz");
		mapGenre.put(75,"Polka");
		mapGenre.put(76,"Retro");
		mapGenre.put(77,"Musical");
		mapGenre.put(78,"Rock&Roll");
		mapGenre.put(79,"HardRock");
		/* Extended genres */
		mapGenre.put(80,"Folk");
		mapGenre.put(81,"Folk-Rock");
		mapGenre.put(82,"NationalFolk");
		mapGenre.put(83,"Swing");
		mapGenre.put(84,"FastFusion");
		mapGenre.put(85,"Bebob");
		mapGenre.put(86,"Latin");
		mapGenre.put(87,"Revival");
		mapGenre.put(88,"Celtic");
		mapGenre.put(89,"Bluegrass");
		mapGenre.put(90,"Avantgarde");
		mapGenre.put(91,"GothicRock");
		mapGenre.put(92,"ProgessiveRock");
		mapGenre.put(93,"PsychedelicRock");
		mapGenre.put(94,"SymphonicRock");
		mapGenre.put(95,"SlowRock");
		mapGenre.put(96,"BigBand");
		mapGenre.put(97,"Chorus");
		mapGenre.put(98,"EasyListening");
		mapGenre.put(99,"Acoustic");
		mapGenre.put(100,"Humour");
		mapGenre.put(101,"Speech");
		mapGenre.put(102,"Chanson");
		mapGenre.put(103,"Opera");
		mapGenre.put(104,"ChamberMusic");
		mapGenre.put(105,"Sonata");
		mapGenre.put(106,"Symphony");
		mapGenre.put(107,"BootyBass");
		mapGenre.put(108,"Primus");
		mapGenre.put(109,"PornGroove");
		mapGenre.put(110,"Satire");
		mapGenre.put(111,"SlowJam");
		mapGenre.put(112,"Club");
		mapGenre.put(113,"Tango");
		mapGenre.put(114,"Samba");
		mapGenre.put(115,"Folklore");
		mapGenre.put(116,"Ballad");
		mapGenre.put(117,"PowerBallad");
		mapGenre.put(118,"RhythmicSoul");
		mapGenre.put(119,"Freestyle");
		mapGenre.put(120,"Duet");
		mapGenre.put(121,"PunkRock");
		mapGenre.put(122,"DrumSolo");
		mapGenre.put(123,"Acapella");
		mapGenre.put(124,"Euro-House");
		mapGenre.put(125,"DanceHall");
		mapGenre.put(126,"Goa");
		mapGenre.put(127,"Drum&Bass");
		mapGenre.put(128,"Club-House");
		mapGenre.put(129,"Hardcore");
		mapGenre.put(130,"Terror");
		mapGenre.put(131,"Indie");
		mapGenre.put(132,"BritPop");
		mapGenre.put(133,"Negerpunk");
		mapGenre.put(134,"PolskPunk");
		mapGenre.put(135,"Beat");
		mapGenre.put(136,"ChristianGangstaRap");
		mapGenre.put(137,"HeavyMetal");
		mapGenre.put(138,"BlackMetal");
		mapGenre.put(139,"Crossover");
		mapGenre.put(140,"ContemporaryChristian");
		mapGenre.put(141,"ChristianRock");
		mapGenre.put(142,"Merengue");
		mapGenre.put(143,"Salsa");
		mapGenre.put(144,"TrashMetal");
		mapGenre.put(145,"Anime");
		mapGenre.put(146,"JPop");
		mapGenre.put(147,"Synthpop");

	}
	
	private void initID3v2FrameID() {
		strFrameAENC="AENC";
		strFrameAPIC="APIC";
		strFrameCOMM="COMM";
		strFrameCOMR="COMR";
		strFrameENCR="ENCR";
		strFrameEQUA="EQUA";
		strFrameETCO="ETCO";
		strFrameGEOB="GEOB";
		strFrameGRID="GRID";
		strFrameIPLS="IPLS";
		strFrameLINK="LINK";
		strFrameMCDI="MCDI";
		strFrameMLLT="MLLT";
		strFrameOWNE="OWNE";
		strFramePRIV="PRIV";
		strFramePCNT="PCNT";
		strFramePOPM="POPM";
		strFramePOSS="POSS";
		strFrameRBUF="RBUF";
		strFrameRVAD="RVAD";
		strFrameRVRB="RVRB";
		strFrameSYLT="SYLT";
		strFrameSYTC="SYTC";
		strFrameTALB="TALB";
		strFrameTBPM="TBPM";
		strFrameTCOM="TCOM";
		strFrameTCON="TCON";
		strFrameTCOP="TCOP";
		strFrameTDAT="TDAT";
		strFrameTDLY="TDLY";
		strFrameTENC="TENC";
		strFrameTEXT="TEXT";
		strFrameTFLT="TFLT";
		strFrameTIME="TIME";
		strFrameTIT1="TIT1";
		strFrameTIT2="TIT2";
		strFrameTIT3="TIT3";
		strFrameTKEY="TKEY";
		strFrameTLAN="TLAN";
		strFrameTLEN="TLEN";
		strFrameTMED="TMED";
		strFrameTOAL="TOAL";
		strFrameTOFN="TOFN";
		strFrameTOLY="TOLY";
		strFrameTOPE="TOPE";
		strFrameTORY="TORY";
		strFrameTOWN="TOWN";
		strFrameTPE1="TPE1";
		strFrameTPE2="TPE2";
		strFrameTPE3="TPE3";
		strFrameTPE4="TPE4";
		strFrameTPOS="TPOS";
		strFrameTPUB="TPUB";
		strFrameTRCK="TRCK";
		strFrameTRDA="TRDA";
		strFrameTRSN="TRSN";
		strFrameTRSO="TRSO";
		strFrameTSIZ="TSIZ";
		strFrameTSRC="TSRC";
		strFrameTSSE="TSSE";
		strFrameTYER="TYER";
		strFrameTXXX="TXXX";
		strFrameUFID="UFID";
		strFrameUSER="USER";
		strFrameUSLT="USLT";
		strFrameWCOM="WCOM";
		strFrameWCOP="WCOP";
		strFrameWOAF="WOAF";
		strFrameWOAR="WOAR";
		strFrameWOAS="WOAS";
		strFrameWORS="WORS";
		strFrameWPAY="WPAY";
		strFrameWPUB="WPUB";
		strFrameWXXX="WXXX";
		
		try {
			byteFrameAENC=strFrameAENC.getBytes("utf-8");
			byteFrameAPIC=strFrameAPIC.getBytes("utf-8");
			byteFrameCOMM=strFrameCOMM.getBytes("utf-8");
			byteFrameCOMR=strFrameCOMR.getBytes("utf-8");
			byteFrameENCR=strFrameENCR.getBytes("utf-8");
			byteFrameEQUA=strFrameEQUA.getBytes("utf-8");
			byteFrameETCO=strFrameETCO.getBytes("utf-8");
			byteFrameGEOB=strFrameGEOB.getBytes("utf-8");
			byteFrameGRID=strFrameGRID.getBytes("utf-8");
			byteFrameIPLS=strFrameIPLS.getBytes("utf-8");
			byteFrameLINK=strFrameLINK.getBytes("utf-8");
			byteFrameMCDI=strFrameMCDI.getBytes("utf-8");
			byteFrameMLLT=strFrameMLLT.getBytes("utf-8");
			byteFrameOWNE=strFrameOWNE.getBytes("utf-8");
			byteFramePRIV=strFramePRIV.getBytes("utf-8");
			byteFramePCNT=strFramePCNT.getBytes("utf-8");
			byteFramePOPM=strFramePOPM.getBytes("utf-8");
			byteFramePOSS=strFramePOSS.getBytes("utf-8");
			byteFrameRBUF=strFrameRBUF.getBytes("utf-8");
			byteFrameRVAD=strFrameRVAD.getBytes("utf-8");
			byteFrameRVRB=strFrameRVRB.getBytes("utf-8");
			byteFrameSYLT=strFrameSYLT.getBytes("utf-8");
			byteFrameSYTC=strFrameSYTC.getBytes("utf-8");
			byteFrameTALB=strFrameTALB.getBytes("utf-8");
			byteFrameTBPM=strFrameTBPM.getBytes("utf-8");
			byteFrameTCOM=strFrameTCOM.getBytes("utf-8");
			byteFrameTCON=strFrameTCON.getBytes("utf-8");
			byteFrameTCOP=strFrameTCOP.getBytes("utf-8");
			byteFrameTDAT=strFrameTDAT.getBytes("utf-8");
			byteFrameTDLY=strFrameTDLY.getBytes("utf-8");
			byteFrameTENC=strFrameTENC.getBytes("utf-8");
			byteFrameTEXT=strFrameTEXT.getBytes("utf-8");
			byteFrameTFLT=strFrameTFLT.getBytes("utf-8");
			byteFrameTIME=strFrameTIME.getBytes("utf-8");
			byteFrameTIT1=strFrameTIT1.getBytes("utf-8");
			byteFrameTIT2=strFrameTIT2.getBytes("utf-8");
			byteFrameTIT3=strFrameTIT3.getBytes("utf-8");
			byteFrameTKEY=strFrameTKEY.getBytes("utf-8");
			byteFrameTLAN=strFrameTLAN.getBytes("utf-8");
			byteFrameTLEN=strFrameTLEN.getBytes("utf-8");
			byteFrameTMED=strFrameTMED.getBytes("utf-8");
			byteFrameTOAL=strFrameTOAL.getBytes("utf-8");
			byteFrameTOFN=strFrameTOFN.getBytes("utf-8");
			byteFrameTOLY=strFrameTOLY.getBytes("utf-8");
			byteFrameTOPE=strFrameTOPE.getBytes("utf-8");
			byteFrameTORY=strFrameTORY.getBytes("utf-8");
			byteFrameTOWN=strFrameTOWN.getBytes("utf-8");
			byteFrameTPE1=strFrameTPE1.getBytes("utf-8");
			byteFrameTPE2=strFrameTPE2.getBytes("utf-8");
			byteFrameTPE3=strFrameTPE3.getBytes("utf-8");
			byteFrameTPE4=strFrameTPE4.getBytes("utf-8");
			byteFrameTPOS=strFrameTPOS.getBytes("utf-8");
			byteFrameTPUB=strFrameTPUB.getBytes("utf-8");
			byteFrameTRCK=strFrameTRCK.getBytes("utf-8");
			byteFrameTRDA=strFrameTRDA.getBytes("utf-8");
			byteFrameTRSN=strFrameTRSN.getBytes("utf-8");
			byteFrameTRSO=strFrameTRSO.getBytes("utf-8");
			byteFrameTSIZ=strFrameTSIZ.getBytes("utf-8");
			byteFrameTSRC=strFrameTSRC.getBytes("utf-8");
			byteFrameTSSE=strFrameTSSE.getBytes("utf-8");
			byteFrameTYER=strFrameTYER.getBytes("utf-8");
			byteFrameTXXX=strFrameTXXX.getBytes("utf-8");
			byteFrameUFID=strFrameUFID.getBytes("utf-8");
			byteFrameUSER=strFrameUSER.getBytes("utf-8");
			byteFrameUSLT=strFrameUSLT.getBytes("utf-8");
			byteFrameWCOM=strFrameWCOM.getBytes("utf-8");
			byteFrameWCOP=strFrameWCOP.getBytes("utf-8");
			byteFrameWOAF=strFrameWOAF.getBytes("utf-8");
			byteFrameWOAR=strFrameWOAR.getBytes("utf-8");
			byteFrameWOAS=strFrameWOAS.getBytes("utf-8");
			byteFrameWORS=strFrameWORS.getBytes("utf-8");
			byteFrameWPAY=strFrameWPAY.getBytes("utf-8");
			byteFrameWPUB=strFrameWPUB.getBytes("utf-8");
			byteFrameWXXX=strFrameWXXX.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initID3v2Lang() {
		mapID3V2Lang=new HashMap<byte[], String>();
		try {
			mapID3V2Lang.put("eng".getBytes("utf-8"), "iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initLyrics3Header() {
		strLyrics3Header="LYRICSBEGININD00003110LYR";
		strLyrics3Footer="LYRICS200";
		try {
			byteLyrics3Header=strLyrics3Header.getBytes("utf-8");
			byteLyrics3Footer=strLyrics3Footer.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initAPEHeader() {
		strHeaderAPEv2="APETAGEX";
		try {
			byteHeaderAPEv2=strHeaderAPEv2.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initDeprecated() {
		strHeaderID3v2="ID3";
		strTagTitle="TIT2";
		strTagArtist="TPE1";
		strTagAlbum="TALB";
		strTagTrack="TRCK";
		strTagYear="TYER";
		strTagCon="TCON";
		strTagComment="COMM";
		try {
			byteHeaderID3v2=strHeaderID3v2.getBytes("utf-8");
			byteTagTitle=strTagTitle.getBytes("utf-8");
			byteTagArtist=strTagArtist.getBytes("utf-8");
			byteTagAlbum=strTagAlbum.getBytes("utf-8");
			byteTagTrack=strTagTrack.getBytes("utf-8");
			byteTagYear=strTagYear.getBytes("utf-8");
			byteTagCon=strTagCon.getBytes("utf-8");
			byteTagComment=strTagComment.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TagID3V1Bean getID3V1Info() {
		return tagID3V1;
	}
	
	public TagID3V2Bean getID3V2Info() {
		return tagID3V2;
	}
	
	public TagAPEV2Bean getAPEV2Info() {
		return tagAPEV2;
	}
	
	public TagLYRICS3V2Bean getLYRICS3V2Info() {
		return tagLYRICS3V2;
	}
}
