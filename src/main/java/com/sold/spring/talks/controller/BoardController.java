package com.sold.spring.talks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sold.spring.talks.dto.BoardDto;
import com.sold.spring.talks.service.BoardService;
import com.sold.spring.talks.util.PageUtil;
import com.sold.spring.talks.util.PagingUtil;
import com.sold.spring.talks.util.PagingData;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	private BoardService boardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, PageUtil pageUtil) {
        pageUtil.setStartIndex((pageUtil.getPageNum() - 1) * pageUtil.getPageAmount());
		List<BoardDto> boardDtoList = boardService.getBoardList(pageUtil);
		int totalPostsCount = boardService.totalPostsCount(pageUtil);
		PagingUtil pagingUtil = new PagingUtil(totalPostsCount, pageUtil);
		PagingData pagingData = new PagingData(boardDtoList, pagingUtil, pageUtil);
		model.addAttribute("pagingData", pagingData);
		return ("getBoardList");
	}

}
