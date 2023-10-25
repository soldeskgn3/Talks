package com.sold.spring.talks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sold.spring.talks.dto.MemberDto;
import com.sold.spring.talks.service.MemberService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private MemberService memberService;
	
	@GetMapping("/signupForm")
	public String signupForm() {
		return "/member/signupForm";
	}
	
    @PostMapping("/signup")
    public String createMember(MemberDto memberDto) {
    	System.out.println(memberDto);
        memberService.createMember(memberDto);
        return "redirect:/";
    }
    
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}

}
