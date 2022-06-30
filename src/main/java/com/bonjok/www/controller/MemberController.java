package com.bonjok.www.controller;

import com.bonjok.www.domain.dto.MemberInsertDTO;
import com.bonjok.www.service.MemberService;
import com.bonjok.www.service.Proc.MemberServiceProc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {

    //로직처리하기 위한 서비스
    @Autowired//
    private MemberService service;

    //회원가입처리
    @PostMapping ("signup")
    public String signup(MemberInsertDTO dto) {
        log.debug(">>> 회원가입처리 : "+ dto);
        //: 필요한게 무엇?
        //웹(View)-> 서버(Controller) 회원가입을 위한 데이터 전송
        //매핑메서드의 파라미터에 데이터 타입정의하면 되요 현재 3개의 데이터:MemberInsertDTO로 매핑
        //DB에 저장하도록 service에 지시
        service.save(dto);

        return "redirect:/signin";
    }
}
