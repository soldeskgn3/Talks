package com.sold.spring.talks.service;

import java.util.List;

import com.sold.spring.talks.dto.BoardDto;
import com.sold.spring.talks.util.PageUtil;

public interface BoardService {
	public List<BoardDto>getPostsList(PageUtil pageUtil);
	public int totalPostsCount(PageUtil pageUtil);
	public BoardDto getRead(Long posts_num);
	public void createPost(BoardDto boardDto);
	public void deletePost(Long posts_num);
	public void modifyPost(BoardDto boardDto);
}
