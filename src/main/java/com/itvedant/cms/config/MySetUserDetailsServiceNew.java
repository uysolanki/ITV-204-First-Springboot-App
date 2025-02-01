package com.itvedant.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itvedant.cms.entity.User;
import com.itvedant.cms.repository.UserRepository;

@Service
public class MySetUserDetailsServiceNew implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User does not exist");
		
		return new MyUserDecorator(user);
		
	}

}
