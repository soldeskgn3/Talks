package com.sold.spring.talks.service;

import java.util.List;

import com.sold.spring.talks.dto.CommentsDto;

public interface CommentsService {
	public List<CommentsDto>commentsList(Long posts_num);
	
	public int commentsInsert(CommentsDto commentsDto);
	
	public int commentsDelete(Long posts_num);
	
	public int commentsUpdate(CommentsDto commentsDto);
}
