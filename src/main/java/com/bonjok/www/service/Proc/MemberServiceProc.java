package com.bonjok.www.service.Proc;

import com.bonjok.www.domain.dto.MemberInsertDTO;
import com.bonjok.www.mapper.MemberMapper;
import com.bonjok.www.service.MemberService;
import com.bonjok.www.util.EncryptUtils;
import org.apache.ibatis.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceProc implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Override
    public void save(MemberInsertDTO dto) {
        // DB에 dto정보 저장
        //필요한게 무엇일까요?
        //DB접근(jpa,my) DAO(repository 객체, mapper객체)은 무엇으로 결정?
        String encryptedPass= EncryptUtils.encryptSHA256(dto.getPass());
        System.out.println(dto.getPass()+":"+encryptedPass);
        dto.setPass(encryptedPass);
        int result=mapper.save(dto);
    }
}
