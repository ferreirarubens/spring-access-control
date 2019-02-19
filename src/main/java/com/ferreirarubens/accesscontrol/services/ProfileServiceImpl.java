package com.ferreirarubens.accesscontrol.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferreirarubens.accesscontrol.common.model.Profile;
import com.ferreirarubens.accesscontrol.common.model.ProfilePermission;
import com.ferreirarubens.accesscontrol.dao.IProfileDAO;
import com.ferreirarubens.accesscontrol.services.interfaces.IProfilePermissionService;
import com.ferreirarubens.accesscontrol.services.interfaces.IProfileService;

/**
 * @author rubens.ferreira
 *
 */
@Service
@Transactional
public class ProfileServiceImpl extends ServiceImpl<Profile, IProfileDAO> implements IProfileService {

	@Autowired
	private IProfileDAO dao;

	@Autowired
	private IProfilePermissionService profilePermissionService;

	@Override
	public List<Profile> getByNameContainsIgnoreCase(String name) {
		return dao.getByNameContainsIgnoreCase(name);
	}

	@Override
	public Profile save(Profile t) {
		Profile profile = super.save(t);
		profile.getProfilePermissions().forEach(pp -> this.saveProfilePermissions(pp, profile));
		return profile;
	}

	private void saveProfilePermissions(ProfilePermission profilePermission, Profile profile) {
		if (Objects.isNull(profilePermission.getProfile())) {
			profilePermission.setProfile(profile);
			profilePermissionService.save(profilePermission);
		}
	}

}
