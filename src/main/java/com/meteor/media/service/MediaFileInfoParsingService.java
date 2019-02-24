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
	private ImediaFileRefactor parser;
	
	public void mediaDirParsePrint(String fileDir) throws Throwable {
		File dirFile = new File(fileDir);
		if(dirFile.isDirectory()) {
			for(File file : dirFile.listFiles()) {
				if(file.isFile()) {
					mediaFileParsePrint(file.getAbsolutePath());							
				}
			}
		}
	}
	
	public void mediaFileParsePrint(String filePath) throws Throwable {
		parser.printFileInfo(filePath);
	}
	
}
