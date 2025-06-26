package com.zidio.zidioconnect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {
    private String to;
    private String subject;
    private String message;
}