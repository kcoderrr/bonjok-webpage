package com.bonjok.www.mapper;

import com.bonjok.www.domain.dto.MemberInsertDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    @Insert("insert into member(email,name,pass)"
            + "values(#{email}, #{name}, #{pass})")
    int save(MemberInsertDTO dto);
}
