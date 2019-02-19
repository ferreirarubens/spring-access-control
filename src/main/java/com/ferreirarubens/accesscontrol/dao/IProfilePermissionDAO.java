package com.ferreirarubens.accesscontrol.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ferreirarubens.accesscontrol.common.model.ProfilePermission;

/**
 * @author rubens.ferreira
 *
 */
public interface IProfilePermissionDAO extends JpaRepository<ProfilePermission, Serializable> {

	@Query(value = " SELECT profile_permission.* " + 
					"  FROM profile_permission, permission " + 
					" WHERE profile_permission.id_permission = permission.id_permission " +
					"   AND profile_permission.id_profile =:profileId " + 
					" ORDER BY permission.nm_permission", nativeQuery = true)
	List<ProfilePermission> getByProfile(@Param("profileId") Integer profileId);
	
	@Query(value = "DELETE FROM profile_permission WHERE profile_permission.id_profile_permission =:id", nativeQuery = true)
	Integer deleteById(@Param("id") int id);
	
	List<ProfilePermission> findAllByOrderByPermissionNameAsc();
	
	ProfilePermission findByProfileIdAndPermissionId(int profileId, int permissionId);

}
