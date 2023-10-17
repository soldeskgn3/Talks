package com.sold.spring.talks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sold.spring.talks.dto.BoardDto;
import com.sold.spring.talks.mapper.BoardMapper;
import com.sold.spring.talks.util.PageUtil;

import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> getPostsList(PageUtil pageUtil){
		return boardMapper.getPostsList(pageUtil);
	}
	
	@Override
	public int totalPostsCount(PageUtil pageUtil) {
		return boardMapper.totalPostsCount(pageUtil);
	}
	
	@Override
	public BoardDto getRead(long posts_num) {
		return boardMapper.getRead(posts_num);
	}

}
