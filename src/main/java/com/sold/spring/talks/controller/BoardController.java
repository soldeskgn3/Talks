package com.sold.spring.talks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sold.spring.talks.dto.BoardDto;
import com.sold.spring.talks.service.BoardService;
import com.sold.spring.talks.service.CommentsService;
import com.sold.spring.talks.util.PageUtil;
import com.sold.spring.talks.util.PagingUtil;
import com.sold.spring.talks.util.PagingData;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	private BoardService boardService;
	private CommentsService commentsService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, PageUtil pageUtil,
		      @RequestParam(name = "searchType", required = false) String searchType,
		      @RequestParam(name = "searchWord", required = false) String searchWord) {
	    pageUtil.setSearchType(searchType);
	    pageUtil.setSearchWord(searchWord);
        pageUtil.setStartIndex((pageUtil.getPageNum() - 1) * pageUtil.getPageAmount());
		List<BoardDto> boardDtoList = boardService.getBoardList(pageUtil);
		int totalPostsCount = boardService.totalPostsCount(pageUtil);
		PagingUtil pagingUtil = new PagingUtil(totalPostsCount, pageUtil);
		PagingData pagingData = new PagingData(boardDtoList, pagingUtil, pageUtil);
		model.addAttribute("pagingData", pagingData);
		return ("getBoardList");
	}
	
	@GetMapping("/read")
	public String getRead(@RequestParam("posts_num") long posts_num, Model model) {
		model.addAttribute("read", boardService.getRead(posts_num));
		model.addAttribute("commentsList", commentsService.commentsList(posts_num));
		return ("read");
	}
}