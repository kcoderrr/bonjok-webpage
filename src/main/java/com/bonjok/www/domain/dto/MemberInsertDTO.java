package com.bonjok.www.domain.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MemberInsertDTO {

    private String email;
    private String name;
    private String pass;

}
