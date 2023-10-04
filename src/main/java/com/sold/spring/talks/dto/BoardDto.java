package com.sold.spring.talks.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
	private int posts_num;
	private String posts_title;
	private String posts_content;
	private int posts_tag;
	private int posts_type;
	private Timestamp posts_date;
	private int posts_hit;
	private int posts_good;
	private String posts_name;

}
