package com.zidio.zidioconnect.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zidio.zidioconnect.Entity.StudentProfile;
import com.zidio.zidioconnect.Entity.User;
import com.zidio.zidioconnect.dto.StudentProfileDto;

@Configuration
public class ApplicationConfig {
/*
	  @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        
	        // Explicit mapping for StudentProfile to StudentProfileDto
	        modelMapper.typeMap(StudentProfile.class, StudentProfileDto.class)
	            .addMappings(mapper -> {
	                mapper.map(src -> src.getUser().getId(), StudentProfileDto::setId);
	                mapper.skip(StudentProfileDto::setId); // Skip the direct userId mapping
	            });
	            
	        return modelMapper;
    }*/
	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();

	    modelMapper.typeMap(StudentProfile.class, StudentProfileDto.class).addMappings(mapper -> {
	        mapper.map(src -> src.getUser().getId(), StudentProfileDto::setUserId);
	    });

	    return modelMapper;
	}


	
}