/**
 * 
 */
package com.ferreirarubens.accesscontrol.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.ferreirarubens.accesscontrol.common.model.Profile;
import com.ferreirarubens.accesscontrol.common.web.validator.AbstractValidator;
import com.ferreirarubens.accesscontrol.services.interfaces.IProfileService;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@Component
public class ProfileValidator extends AbstractValidator<Profile> {

	@Autowired
	private IProfileService profileService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Profile.class.isAssignableFrom(clazz);
	}

	@Override
	public void validateEntity(Object object, Errors errors) {
		Profile profile = (Profile) object;

		if (!objectIsNull(profile, errors)) {

			/*UPDATE METHOD*/
			if (profile.getId() > 0) {
				if (!objectNotExist(profileService.findById(profile.getId()), errors)) {

				}
			}
			
		}
	}

}
