package com.sold.spring.talks.mapper;

import java.util.List;

import com.sold.spring.talks.dto.BoardDto;
import com.sold.spring.talks.util.PageUtil;

public interface BoardMapper {
	public List<BoardDto>getBoardList(PageUtil pageUtil);
	public int totalPostsCount(PageUtil pageUtil);
	public BoardDto getRead(long posts_num);
}
