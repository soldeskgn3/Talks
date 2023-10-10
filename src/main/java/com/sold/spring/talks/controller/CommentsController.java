package com.sold.spring.talks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sold.spring.talks.dto.CommentsDto;
import com.sold.spring.talks.service.CommentsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/board/*")
@AllArgsConstructor
public class CommentsController {
	
	private CommentsService commentsService;
	
	@GetMapping(value = "/read/{posts_num}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CommentsDto>>getCommentsList(@PathVariable("posts_num") Long posts_num){
		return new ResponseEntity<>(commentsService.commentsList(posts_num), HttpStatus.OK);
	}

}
