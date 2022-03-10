package com.example.demo.Resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.UserModel;
import com.example.demo.input.UserModelInput;
import com.example.demo.service.UserService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;


@Component
public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	private UserService userService;
		
	public UserResolver(UserService userService) {	
		this.userService = userService;
	}

	public UserModel addUser(UserModelInput input) {
		
		return userService.addUser(input);
	}

	public List<UserModel> users() {
		
		return userService.users();
	}

	public UserModel user(String id){
		return userService.userItem(id);
	}
}
