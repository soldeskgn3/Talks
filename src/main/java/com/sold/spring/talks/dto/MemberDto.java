package com.sold.spring.talks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MemberDto {
    private String member_nickname;
    private String member_pw;
    private String member_id;
    private String member_name;
}
