package com.meteor.media.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.meteor.media.model.MediaFileInfoModel;

@Component
public class Mp3FileRefactor implements ImediaFileRefactor {
	public MediaFileInfoModel getMediaFileInfo(String filePath)
			throws IOException, SAXException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
		AudioFile audioFile = AudioFileIO.read(new File(filePath));
		Tag tag = audioFile.getTag();

		MediaFileInfoModel mediaFIleInfoModel = new MediaFileInfoModel(audioFile.getAudioHeader().getEncodingType(), filePath);
		String artist = tag.getFirst(FieldKey.ARTIST);
		mediaFIleInfoModel.setArtist(  artist);
		String album = tag.getFirst(FieldKey.ALBUM);
		mediaFIleInfoModel.setAlbum(album);
		//TODO 한글 깨지는 인코딩을 잡아야 한다...
		//아마 unicode를 utf-8로 변환해서 문제가 될듯
		
		if(tag instanceof AbstractID3v2Tag) {
			AbstractID3v2Tag iD3v2 = (AbstractID3v2Tag) tag;

		}
		
		
		
		/*
		mediaFIleInfoModel.setAlbum(musicTag.getAlbum());
		mediaFIleInfoModel.setArtist(musicTag.getArtist());
		if(musicTag.getArtist()!=null) {
			byte[] bytes = musicTag.getArtist().getBytes();
//			Unicode()
			System.out.println("asd : " +  new String(bytes, Charset.forName("Unicode") ) );	
		}
		*/
		

		return mediaFIleInfoModel;
	}
}
