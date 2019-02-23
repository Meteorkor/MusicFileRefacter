package com.meteor.media.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

/**
 * @TODO 메타 변경 및 파일 저장은 병렬처리로
 * @author kimunseok
 *
 */
@Service
public class MediaFileInfoParsingService {

	@Autowired
	private MediaFileInfoParser parser;
	
	public void mediaDirParse(String fileDir) throws IOException, SAXException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		File dirFile = new File(fileDir);
		if(dirFile.isDirectory()) {
			for(File file : dirFile.listFiles()) {
				if(file.isFile()) {
					mediaFileParse(file.getAbsolutePath());							
				}
			}
		}
	}
	
	public void mediaFileParse(String filePath) throws IOException, SAXException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		parser.printFileInfo(filePath);
	}
	
}
