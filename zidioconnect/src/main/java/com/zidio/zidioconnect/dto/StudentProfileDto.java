package com.zidio.zidioconnect.dto;

import  jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentProfileDto {

    private Long userId;

    @NotBlank(message = "University cannot be blank")
    private String university;

    @NotBlank(message = "Degree cannot be blank")
    private String degree;

    @Min(value = 1, message = "Year of study must be at least 1")
    @Max(value = 4, message = "Year of study cannot exceed 4")
    private int yearOfStudy;

    private String resumeUrl;
}