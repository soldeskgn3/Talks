package com.sold.spring.talks.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentsDto {
	private int comments_num;
	private int posts_num;
	private String comments_content;
	private String member_nickname;
	private Timestamp comments_date;
	private int comments_parents_num;
	private int comment_level;
	private boolean comments_deleted;
}
