package com.sold.spring.talks.mapper;

import java.util.List;

import com.sold.spring.talks.dto.CommentsDto;

public interface CommentsMapper {
	public List<CommentsDto>commentsList(Long posts_num);
	
	public int commentsInsert(CommentsDto commentsDto);
	
	public int commentsDelete(Long posts_num);
	
	public int commentsUpdate(CommentsDto commentsDto);
}
