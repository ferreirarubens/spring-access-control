package com.ferreirarubens.accesscontrol.common.config.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ferreirarubens.accesscontrol.common.model.Profile;
import com.ferreirarubens.accesscontrol.common.model.User;
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
		List<Profile> profiles = profileService.findAll();

		if (profiles.isEmpty()) {
			System.out.println("Nenhum encontrado");
		} else {
			User user = new User("rubens", encoder().encode("password"), "Rubens", "06221683475",
					profiles.get(0));
			
			userService.save(user);
		}
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
