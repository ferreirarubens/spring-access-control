package com.ferreirarubens.accesscontrol.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ferreirarubens.accesscontrol.services.interfaces.IProfileService;
import com.ferreirarubens.accesscontrol.services.interfaces.IUserService;

@Component
public class StartClass implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private IProfileService profileService;

	@Autowired
	private IUserService userService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
