package com.sold.spring.talks.util;

import lombok.Data;

@Data
public class PagingUtil {
	
	private int totalPostsCount; //총 글수
	private int totalPageCount; //총 페이지수
	private int firstPage; //첫 페이지
	private int lastPage; //마지막 페이지
	private boolean nextPage; //다음 페이지 버튼
	private boolean prevPage; //이전 페이지 버튼
	
	public PagingUtil(int totalPostsCount,PageUtil pageUtil) {
		if(totalPostsCount > 0) {
			this.totalPostsCount = totalPostsCount;
			Calculation(pageUtil);
		}
	}
	
	public void Calculation(PageUtil pageUtil) {
		//전체 페이지 구하기
		totalPageCount = ((totalPostsCount - 1) / pageUtil.getPageAmount()) + 1;
		
		if(pageUtil.getPageNum() > totalPageCount) {
			pageUtil.setPageNum(totalPageCount);
		}
		//첫 페이지 구하기
		firstPage = ((pageUtil.getPageNum() - 1) / pageUtil.getPageSize()) * pageUtil.getPageSize() + 1;
		//마지막 페이지 구하기
		lastPage = firstPage + pageUtil.getPageSize() - 1;
		
		if(lastPage > totalPageCount) {
			lastPage = totalPageCount;
		}
		//전 블럭 이동
		prevPage = firstPage != 1;
		//다음 블럭 이동
		nextPage = (lastPage * pageUtil.getPageAmount()) < totalPostsCount;
	}
	
}
