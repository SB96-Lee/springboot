package com.study.springboot.domain;

import lombok.Data;

@Data // 게터 세터 투스트링 전부 자동으로 만들어짐
public class Board {
	private int boardno;
	private String title;
	private String writer;
	private String content;
}
