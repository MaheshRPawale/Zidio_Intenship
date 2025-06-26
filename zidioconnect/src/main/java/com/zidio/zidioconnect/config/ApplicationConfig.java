
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

package com.zidio.zidioconnect.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zidio.zidioconnect.Entity.StudentProfile;
import com.zidio.zidioconnect.dto.StudentProfileDto;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // ✅ Custom Mapping: StudentProfile → StudentProfileDto
        PropertyMap<StudentProfile, StudentProfileDto> studentMap = new PropertyMap<StudentProfile, StudentProfileDto>() {
            @Override
            protected void configure() {
                map().setUserId(source.getUser().getId()); // map nested user.id to userId
            }
        };
        modelMapper.addMappings(studentMap);

        // ✅ Default Mapping: Recruiter ↔ RecruiterRequest
        // No need for manual configuration since fields match exactly

        return modelMapper;
    }
}
