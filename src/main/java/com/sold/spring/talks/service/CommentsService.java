package com.sold.spring.talks.service;

import java.util.List;

import com.sold.spring.talks.dto.CommentsDto;

public interface CommentsService {
	public List<CommentsDto>commentsList(long posts_num);
	
}
