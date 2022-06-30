package com.bonjok.www.service;

import com.bonjok.www.domain.dto.MemberInsertDTO;
import org.springframework.stereotype.Service;

public interface MemberService {
    void save(MemberInsertDTO dto);
}
