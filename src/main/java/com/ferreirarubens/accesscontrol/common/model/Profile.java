package com.ferreirarubens.accesscontrol.common.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.ferreirarubens.accesscontrol.common.config.data.serializers.ProfilePermissionListSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author rubens_ferreira
 *
 */
@Entity
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id_profile")) })
@SequenceGenerator(initialValue = 1, name = "base_gen", sequenceName = "profile_seq")
@Table(name = "profile")
public class Profile extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_profile", nullable = false, length = 30)
	private String name;

	@Column(name = "nr_hierarchy", nullable = false)
	private int hierarchy;

	@ManyToOne
	@JoinColumn(name = "id_profile_type", nullable = false)
	private ProfileType profileType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profile", orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonSerialize(using = ProfilePermissionListSerializer.class)
	private List<ProfilePermission> profilePermissions = new ArrayList<>();

	public Profile() {
	}

	public Profile(int id) {
		this.setId(id);
	}

	public Profile(String name, int hierarchy, Collection<ProfilePermission> profilePermissions) {
		this.name = name;
		this.hierarchy = hierarchy;
		this.profilePermissions = new ArrayList<ProfilePermission>(profilePermissions);
	}

	@JsonIgnore
	public Collection<String> getRoles() {
		if (Objects.nonNull(getProfilePermissions())) {
			return getProfilePermissions().stream().map(ProfilePermission::getRoles).flatMap(Collection::stream)
					.sorted().collect(Collectors.toList());
		}
		return null;
	}

	public int getHierarchyAllowed() {
		if (this.hierarchy < 9) {
			return this.hierarchy + 1;
		} else {
			return this.hierarchy;
		}
	}

	public int getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}

	public List<ProfilePermission> getProfilePermissions() {
		return profilePermissions;
	}

	public void setProfilePermissions(List<ProfilePermission> profilePermissions) {
		this.profilePermissions = profilePermissions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProfileType getType() {
		return profileType;
	}

	public void setType(ProfileType profileType) {
		this.profileType = profileType;
	}

}
