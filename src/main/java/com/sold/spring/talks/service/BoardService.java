package com.sold.spring.talks.service;

import java.util.List;

import com.sold.spring.talks.dto.BoardDto;
import com.sold.spring.talks.util.PageUtil;

public interface BoardService {
	public List<BoardDto>getBoardList(PageUtil pageUtil);
	public int totalPostsCount(PageUtil pageUtil);
}
