package com.zidio.zidioconnect.service;

import java.util.List;

import com.zidio.zidioconnect.dto.UserDto;

public interface UserService  {

	 UserDto createUser(UserDto userDto);
	    UserDto getUserById(Long userId);
	    List<UserDto> getAllUsers();
	    UserDto updateUser(UserDto userDto);
	    void deleteUser(Long userId);
	    boolean existsByEmail(String email);
}
