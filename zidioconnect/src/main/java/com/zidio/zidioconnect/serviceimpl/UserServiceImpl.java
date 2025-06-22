package com.zidio.zidioconnect.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.Entity.User;
import com.zidio.zidioconnect.dto.UserDto;
import com.zidio.zidioconnect.repo.UserRepo;
import com.zidio.zidioconnect.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
	    this.userRepo = userRepo;
	    this.modelMapper = modelMapper;
	}

	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		  User user = modelMapper.map(userDto, User.class);
	        User savedUser = userRepo.save(user);
	        return modelMapper.map(savedUser, UserDto.class);
	}

	 @Override
	    public UserDto getUserById(Long userId) {
	        User user = userRepo.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
	        return modelMapper.map(user, UserDto.class);
	    }


	    @Override
	    public List<UserDto> getAllUsers() {
	        List<User> users = userRepo.findAll();
	        return users.stream()
	                .map(user -> modelMapper.map(user, UserDto.class))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public UserDto updateUser(UserDto userDto) {
	        User existingUser = userRepo.findById(userDto.getId())
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDto.getId()));
	        
	        modelMapper.map(userDto, existingUser);
	        User updatedUser = userRepo.save(existingUser);
	        return modelMapper.map(updatedUser, UserDto.class);
	    }

	    @Override
	    public void deleteUser(Long userId) {
	        User user = userRepo.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
	        userRepo.delete(user);
	    }

	    @Override
	    public boolean existsByEmail(String email) {
	        return userRepo.existsByEmail(email);
	    }

}
