package com.ferreirarubens.accesscontrol.common.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@Entity
@SequenceGenerator(initialValue = 1, name = "base_gen", sequenceName = "congregation_seq")
@Table(name = "congregation", schema = "access_control")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id_congregation")) })
public class Congregation extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_congregation", nullable = false, length = 1000)
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_zone", nullable = false)
	private Zone zone;

	public Congregation() {	}
	
	public Congregation(String name, Zone zone) {
		this.name = name;
		this.zone = zone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}
}
