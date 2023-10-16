package com.sold.spring.talks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/{mainCategory}/{subCategory}")
	public String getSoccerList(Model model, PageUtil pageUtil,
	        @PathVariable String mainCategory,
	        @PathVariable String subCategory,
	        @RequestParam(name = "minorCategory", required = false) String minorCategory,
			@RequestParam(name = "searchType", required = false) String searchType,
			@RequestParam(name = "searchWord", required = false) String searchWord) {
		pageUtil.setSearchType(searchType);
		pageUtil.setSearchWord(searchWord);
		pageUtil.setStartIndex((pageUtil.getPageNum() - 1) * pageUtil.getPageAmount());
	    pageUtil.setPosts_main_category(mainCategory);
	    pageUtil.setPosts_sub_category(subCategory);
	    pageUtil.setPosts_minor_category(minorCategory);
		List<BoardDto> boardDtoList = boardService.getSoccerList(pageUtil);
		int totalPostsCount = boardService.totalPostsCount(pageUtil);
		PagingUtil pagingUtil = new PagingUtil(totalPostsCount, pageUtil);
		PagingData pagingData = new PagingData(boardDtoList, pagingUtil, pageUtil);
		model.addAttribute("pagingData", pagingData);
	    return "sports/soccer";
	}
	
	@GetMapping("/read/{posts_num}")
	public String getRead(@PathVariable("posts_num") Long posts_num, Model model) {
		model.addAttribute("read", boardService.getRead(posts_num));
		return ("read");
	}
}