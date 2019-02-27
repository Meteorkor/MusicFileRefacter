package com.meteor.media.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meteor.media.model.MediaFileInfoModel;

/**
 * @TODO 메타 변경 및 파일 저장은 병렬처리로
 * @author kimunseok
 *
 */
@Service
public class MediaFileInfoParsingService {

	@Autowired
	private ImediaFileRefactor parser;
	
	public List<MediaFileInfoModel> mediaDirParsePrint(String fileDir) throws Throwable {
		List<MediaFileInfoModel> fileInfoModel = new ArrayList<>();
		File dirFile = new File(fileDir);
		if(dirFile.isDirectory()) {
			for(File file : dirFile.listFiles()) {
				if(file.isFile()) {
					fileInfoModel.add(mediaFileParsePrint(file.getAbsolutePath()));
				}
			}
		}
		return fileInfoModel;
	}
	
	public MediaFileInfoModel mediaFileParsePrint(String filePath) throws Throwable {
		return parser.getMediaFileInfo(filePath);
	}
	
}
