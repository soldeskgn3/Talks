package com.sold.spring.talks.util;

import java.util.List;

import com.sold.spring.talks.dto.BoardDto;

import lombok.Data;

@Data
public class PagingData {
	private List<BoardDto> boardDtoList;
	private PagingUtil pagingUtil;
	private PageUtil pageUtil;
	
	public PagingData(List<BoardDto> boardDtoList, PagingUtil pagingUtil, PageUtil pageUtil) {
		this.boardDtoList = boardDtoList;
		this.pagingUtil = pagingUtil;
		this.pageUtil = pageUtil;
	}
}
		
    

