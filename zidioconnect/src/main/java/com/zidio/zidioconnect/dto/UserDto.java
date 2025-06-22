package com.zidio.zidioconnect.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UserDto {

	 private Long id;
	 
	@NotBlank(message = "Name cannot be blank !")
	@Size(min=2 ,max = 100 ,message = "Name must be 2-100 character long")
    private String name;
	
	@NotBlank(message = "Email cannot be blank !")
	@Email(message = "Invalid email format!")
	@Size(min = 8 ,max=64, message = "Email must be ≤100 characters")
		private String email;
	
	@NotBlank(message = "Password cannot be blank!")
    @Size(min = 8, max = 64, message = "Password must be 8-64 characters long")
		private String password;
	
	 
    @NotBlank(message = "Role cannot be blank!")
    private String role;
}
