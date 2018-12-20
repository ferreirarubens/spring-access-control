/**
 * 
 */
package com.ferreirarubens.accesscontrol.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.ferreirarubens.accesscontrol.common.web.validator.AbstractValidator;
import com.ferreirarubens.accesscontrol.model.User;
import com.ferreirarubens.accesscontrol.services.interfaces.IUserService;

/**
 * @author rubens.ferreira
 *
 */
@Component
public class UserValidator extends AbstractValidator<User> {

	@Autowired
	private IUserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validateEntity(Object object, Errors errors) {
		User user = (User) object;

		if (!objectIsNull(user, errors)) {

			/*UPDATE METHOD*/
			if (user.getId() > 0) {
				if (!objectNotExist(userService.findById(user.getId()), errors)) {

				}
			}
			
		}
	}

}
