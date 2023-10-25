package com.sold.spring.talks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		List<BoardDto> boardDtoList = boardService.getPostsList(pageUtil);
		int totalPostsCount = boardService.totalPostsCount(pageUtil);
		PagingUtil pagingUtil = new PagingUtil(totalPostsCount, pageUtil);
		PagingData pagingData = new PagingData(boardDtoList, pagingUtil, pageUtil);
		model.addAttribute("pagingData", pagingData);
		String viewName = mainCategory + "/" + subCategory;
	    return viewName;
	}
	
	@GetMapping("/{mainCategory}/{subCategory}/read/{posts_num}")
	public String getRead(@PathVariable String mainCategory, @PathVariable String subCategory, @PathVariable Long posts_num,
	                      @RequestParam(name = "minorCategory", required = false) String minorCategory, Model model) {
	    model.addAttribute("read", boardService.getRead(posts_num));
	    model.addAttribute("mainCategory", mainCategory);
	    model.addAttribute("subCategory", subCategory);
	    if (minorCategory != null) {
	        model.addAttribute("minorCategory", minorCategory);
	    }
	    return "read";
	}
	
	
	@GetMapping("/{mainCategory}/{subCategory}/write")
	public String writeForm(@PathVariable String mainCategory, @PathVariable String subCategory,
		           			@RequestParam(name = "minorCategory", required = false) String minorCategory, Model model) {
	    return "write";
	}
	
	@PostMapping("/create")
	public String createPost(BoardDto boardDto, @RequestParam(name = "mainCategory") String mainCategory, 
							 @RequestParam(name = "subCategory") String subCategory, @RequestParam(name = "minorCategory", required = false) String minorCategory){
		boardDto.setPosts_main_category(mainCategory);
		boardDto.setPosts_sub_category(subCategory);
		boardDto.setPosts_minor_category(minorCategory);
	    boardService.createPost(boardDto);
	    String redirectUrl = "/board/" + boardDto.getPosts_main_category() + "/" + boardDto.getPosts_sub_category();
	    if (boardDto.getPosts_minor_category() != null) {
	        redirectUrl += "?minorCategory=" + boardDto.getPosts_minor_category();
	    }
	    return "redirect:" + redirectUrl;
	}
	
	@PostMapping("/deletePost")
	public String deletePost(@RequestParam(name = "posts_num") Long posts_num, @RequestParam(name = "mainCategory") String mainCategory, 
							 @RequestParam(name = "subCategory") String subCategory, @RequestParam(name = "minorCategory", required = false) String minorCategory) {
		boardService.deletePost(posts_num);
	    String redirectUrl = "/board/" + mainCategory + "/" + subCategory;
	    if (minorCategory != null) {
	        redirectUrl += "?minorCategory=" + minorCategory;
	    }
		return "redirect:" + redirectUrl;
	}
	
	@GetMapping("/{mainCategory}/{subCategory}/modifyPost/{posts_num}")
	public String modifyPost(@PathVariable String mainCategory, @PathVariable String subCategory, @PathVariable Long posts_num,
			@RequestParam(name = "minorCategory", required = false) String minorCategory, Model model) {
		model.addAttribute("read", boardService.getRead(posts_num));
		model.addAttribute("mainCategory", mainCategory);
		model.addAttribute("subCategory", subCategory);
		if (minorCategory != null) {
			model.addAttribute("minorCategory", minorCategory);
		}
		return "modify";
	}
	
	@PostMapping("/modifyPost")
	public String modifyPost(@RequestParam(name = "mainCategory") String mainCategory, @RequestParam(name = "subCategory") String subCategory, 
							 @RequestParam(name = "minorCategory", required = false) String minorCategory, @RequestParam(name = "posts_num") int posts_num,
							 @RequestParam(name = "posts_title") String posts_title, @RequestParam(name = "posts_content") String posts_content) {
		BoardDto boardDto = new BoardDto();
		boardDto.setPosts_num(posts_num);
		boardDto.setPosts_title(posts_title);
		boardDto.setPosts_content(posts_content);
		boardService.modifyPost(boardDto);
	    String redirectUrl = "/board/" + mainCategory + "/" + subCategory;
	    if (minorCategory != null) {
	        redirectUrl += "?minorCategory=" + minorCategory;
	    }
		return "redirect:" + redirectUrl;
	}
}