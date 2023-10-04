package com.sold.spring.talks.util;

import lombok.Data;

@Data
public class PageUtil {
	private int pageNum;
	private int pageAmount;
	private int pageSize;
	private int startIndex;
	
	public PageUtil() {
		this.pageNum = 1;
		this.pageAmount = 10;
		this.pageSize = 10;
		this.startIndex = (pageNum - 1) * pageAmount;
	}
}
