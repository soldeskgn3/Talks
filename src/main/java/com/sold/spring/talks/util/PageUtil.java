package com.sold.spring.talks.util;

import lombok.Data;

@Data
public class PageUtil {
	private int pageNum; //페이지 번호
	private int pageAmount; //페이지당 글수
	private int pageSize; //페이지 블록 사이즈
	private int startIndex; // 페이지 시작점
	private String searchType; //검색 타입
	private String searchWord; //검색어
	private String posts_main_category;
	private String posts_sub_category;
	private String posts_minor_category;
	
	public PageUtil() {
		this.pageNum = 1;
		this.pageAmount = 10;
		this.pageSize = 10;
		this.startIndex = (pageNum - 1) * pageAmount;
	}
}
