package com.meteor.media.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MediaFileInfoModel {
//TODO mp3, m4a, flac
	public enum MediaType {
		MP3
	}

	private final MediaType mediaType;
	private String artist;
	private String album;
	private final String filePath;

}
