package com.zidio.zidioconnect.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponseDto{
    private Long id;
    private String studentEmail;
    private Long jobId;
    private String status;
}