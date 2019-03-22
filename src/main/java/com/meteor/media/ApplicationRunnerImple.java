package com.meteor.media;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.meteor.media.model.MediaFileInfoModel;
import com.meteor.media.service.MediaFileInfoParsingService;

/**
 * 1차 작업 예정
 * 디렉토리에 존재하는 mp3들의 태그들을 출력하여 잘못된 태그들 검색
 * 잘못된 태그의 종류, 잘못된 태그명, 고칠 태그명 을 입력받아 신규 생성
 * 
 * 2차 예정
 * flac 파일도 변경할 수 있도록
 * 
 * 
 * @author kimunseok
 *
 */
@Component
public class ApplicationRunnerImple implements ApplicationRunner{
	@Autowired
	private MediaFileInfoParsingService service;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String filePath = "G\\Music";
		
		
		List<MediaFileInfoModel> list = null;
		try {
			list = service.mediaDirParsePrint(filePath);
		} catch (Throwable e1) {
			throw new Exception(e1);
		}
		
		System.out.println("FileCnt : " + list.size());
		
		for(MediaFileInfoModel model : list) {
			System.out.println(model.toString());
		}
		
		/*
		try {
			service.mediaFileParsePrint(filePath);
		} catch (Throwable e) {
			throw new Exception(e);
		}
		*/
	}

}
