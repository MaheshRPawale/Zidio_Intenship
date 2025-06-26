package com.zidio.zidioconnect.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {

	   @Id
	    private Long id; 

	   

	    @Column(nullable = false, length = 100)
	    private String companyName;

	    @Column(nullable = false, unique = true, length = 100)
	    private String recruiterEmail;

	    @Column(nullable = false, length = 100)
	    private String recruiterName;

	    @Column(nullable = false, length = 50)
	    private String designation;
}
