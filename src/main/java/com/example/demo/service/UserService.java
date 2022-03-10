package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserModel;
import com.example.demo.error.UserExceptionResolver;
import com.example.demo.input.UserModelInput;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserModel addUser(UserModelInput input) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> mp = objectMapper.convertValue(input, Map.class);
		UserModel users = objectMapper.convertValue(mp, UserModel.class);
		return userRepository.save(users);
	}

	public List<UserModel> users(){		
		return userRepository.findAll();
	}

	public UserModel userItem(String id) {
		if(!userRepository.existsById(id)){
			throw new UserExceptionResolver("User doesnt exitst");
		}
		else
		{
			return userRepository.findById(id).get();
		}
	}
}
