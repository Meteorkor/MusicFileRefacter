package com.meteor.media.service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v23Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

@Component
public class MediaFileInfoParser {
	public void printFileInfo(String filePath) throws IOException, SAXException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		Mp3File mp3file = new Mp3File(filePath);
		ID3v2 id3v2Tag = null;
		if(mp3file.hasId3v2Tag() ) {
			id3v2Tag = mp3file.getId3v2Tag();
		}else {
		  // mp3 does not have an ID3v1 tag, let's create one..
		  id3v2Tag = new ID3v23Tag();
		  mp3file.setId3v2Tag(id3v2Tag);
		}
		
		System.out.println(String.format("p : %s, art : %s, album : %s",filePath, id3v2Tag.getArtist(), id3v2Tag.getAlbum()));
		mp3file.save(filePath+".mp3");
		
		
	}

}
