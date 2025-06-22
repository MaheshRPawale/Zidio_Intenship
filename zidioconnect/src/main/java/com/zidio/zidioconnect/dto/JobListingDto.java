package com.zidio.zidioconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobListingDto {

	  private Long id;

	    private Long recruiterId;

	    private String title;

	    private String description;

	    private String location;

	    private String type;
}
