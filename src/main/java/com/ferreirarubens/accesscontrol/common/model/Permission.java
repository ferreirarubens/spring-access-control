package com.ferreirarubens.accesscontrol.common.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@Entity
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id_permission")) })
@SequenceGenerator(initialValue = 1, name = "base_gen", sequenceName = "permission_seq")
@Table(name = "permission", schema = "access_control")
public class Permission extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_permission", nullable = false, length = 50)
	private String name;

	@Column(name = "is_crud")
	private boolean crud;

	public Permission() {

	}

	public Permission(int id) {
		setId(id);
	}

	public Permission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCrud() {
		return crud;
	}

	public void setCrud(boolean crud) {
		this.crud = crud;
	}

}