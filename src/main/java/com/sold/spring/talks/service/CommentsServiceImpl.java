package com.sold.spring.talks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sold.spring.talks.dto.CommentsDto;
import com.sold.spring.talks.mapper.CommentsMapper;

import lombok.Setter;

@Service
public class CommentsServiceImpl implements CommentsService{
	
	@Setter(onMethod_ = @Autowired)
	private CommentsMapper commentsMapper;
	
	@Override
	public List<CommentsDto>commentsList(Long posts_num){
		return commentsMapper.commentsList(posts_num);
	}
	
	public int commentsInsert(CommentsDto commentsDto) {
		return commentsMapper.commentsInsert(commentsDto);
	}
	
	public int commentsDelete(Long posts_num) {
		return commentsMapper.commentsDelete(posts_num);
	}
	
	public int commentsUpdate(CommentsDto commentsDto) {
		return commentsMapper.commentsUpdate(commentsDto);
	}

}
