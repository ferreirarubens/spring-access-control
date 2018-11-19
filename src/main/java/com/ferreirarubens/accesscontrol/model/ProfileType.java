package com.ferreirarubens.accesscontrol.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ferreirarubens.accesscontrol.model.enums.ProfileCategoryEnum;

/**
 * @author Renatão
 *
 */
@Entity
@SequenceGenerator(initialValue = 1, name = "base_gen", sequenceName = "profile_type_seq")
@Table(name = "profile_type")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id_profile_type")) })
public class ProfileType extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_profile_type", nullable = false, length = 1000)
	private String name;

	@Column(name = "ds_profile_type", nullable = true, length = 1000)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "tp_category", nullable = false, length = 50)
	private ProfileCategoryEnum category;

	public ProfileType() { }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProfileCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(ProfileCategoryEnum category) {
		this.category = category;
	}
	
}
