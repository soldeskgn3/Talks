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
	private Timestamp posts_date;
	private String posts_name;
	private String posts_main_category;
	private String posts_sub_category;
	private String posts_minor_category;
}
