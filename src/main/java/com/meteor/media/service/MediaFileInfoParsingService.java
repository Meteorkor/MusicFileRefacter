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

	private final String[] musicExtension = {"mp3", "flac"};
	@Autowired
	private ImediaFileRefactor parser;
	
	/**
	 * 해당 디렉토리 하위 노래들에 대해 정보들을 담은 파일들을 리턴
	 * @param fileDir
	 * @return
	 * @throws Throwable
	 */
	public List<MediaFileInfoModel> mediaDirParsePrint(String fileDir) throws Throwable {
		return mediaDirParseInner(new File(fileDir));
	}
	
	private List<MediaFileInfoModel> mediaDirParseInner(File dir) throws Throwable{
		List<MediaFileInfoModel> fileInfoModel = new ArrayList<>();
		if(dir.isDirectory()) {
			for(File file : dir.listFiles()) {
				if(file.isFile()) {
					String abPath = file.getAbsolutePath();
					for(String extension : musicExtension) {
						if(abPath.endsWith(extension)) {
							fileInfoModel.add(mediaFileParsePrint(abPath));
							break;
						}
					}
				}else if(file.isDirectory()) {
					fileInfoModel.addAll(mediaDirParseInner(file)  );
				}
			}
		}
		return fileInfoModel;		
	}
	
	public MediaFileInfoModel mediaFileParsePrint(String filePath) throws Throwable {
		return parser.getMediaFileInfo(filePath);
	}
	
}
