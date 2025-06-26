package com.zidio.zidioconnect.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterRequestDto {

	
	    @NotBlank(message = "Company name is required")
	    @Size(max = 100)
	    private String companyName;

	    @NotBlank(message = "Recruiter name is required")
	    @Size(max = 100)
	    private String recruiterName;

	    @NotBlank(message = "Recruiter email is required")
	    @Email(message = "Email should be valid")
	    private String recruiterEmail;

	    @NotBlank(message = "Designation is required")
	    @Size(max = 50)
	    private String designation;
}
