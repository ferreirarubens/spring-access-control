package com.ferreirarubens.accesscontrol.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ferreirarubens.accesscontrol.common.model.Profile;
import com.ferreirarubens.accesscontrol.common.model.User;
import com.ferreirarubens.accesscontrol.common.model.enums.Gender;
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
			User user = new User("rubens", encoder().encode("123456"), "Rubens", "06221683475",
					profiles.get(0), Gender.MALE);
			User user2 = new User("teste", encoder().encode("123456"), "Teste", "06221683478",
					profiles.get(0), Gender.MALE);
			
			userService.save(Arrays.asList(user, user2));
			System.out.println("Cadastrados com sucesso: (senha) -> 123456");
		}
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
