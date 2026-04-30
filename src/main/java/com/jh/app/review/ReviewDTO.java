package com.jh.app.review;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO {

	private Long reviewNum;
	private Long productNum;
	private String username;
	private String reviewContents;
	private LocalDateTime reviewDate;
	private Long reviewStar;

	private String productName;
}
