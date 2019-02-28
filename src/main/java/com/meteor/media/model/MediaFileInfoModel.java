package com.meteor.media.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MediaFileInfoModel {
//TODO mp3, m4a, flac
	/*
	public enum MediaType {
		MP3
	}
*/
	private final String mediaType;
	private String artist;
	private String album;
	private final String filePath;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MediaFileInfoModel [mediaType=").append(mediaType).append(", artist=").append(artist)
				.append(", album=").append(album).append(", filePath=").append(filePath).append("]");
		return builder.toString();
	}

	
}
