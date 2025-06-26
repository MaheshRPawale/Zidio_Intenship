package com.zidio.zidioconnect.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDto{
    private String studentEmail;
    private Long jobId;
}