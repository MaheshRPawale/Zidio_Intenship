package com.zidio.zidioconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserStatusUpdateRequestDto {
    private String email;
    private boolean isActive;
    
}