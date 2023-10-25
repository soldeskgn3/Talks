package com.sold.spring.talks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sold.spring.talks.dto.MemberDto;
import com.sold.spring.talks.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Override
	public void createMember(MemberDto memberDto) {
		memberMapper.createMember(memberDto);
	}

}
