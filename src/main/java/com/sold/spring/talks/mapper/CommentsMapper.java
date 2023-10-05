package com.sold.spring.talks.mapper;

import java.util.List;

import com.sold.spring.talks.dto.CommentsDto;

public interface CommentsMapper {
	public List<CommentsDto>commentsList(long posts_num);
}
