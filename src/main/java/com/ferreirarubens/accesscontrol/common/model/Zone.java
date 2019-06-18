package com.ferreirarubens.accesscontrol.common.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ferreirarubens.accesscontrol.common.model.enums.ZoneType;

/**
 * @author Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@Entity
@SequenceGenerator(initialValue = 1, name = "base_gen", sequenceName = "zone_seq")
@Table(name = "zone", schema = "access_control")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id_zone")) })
public class Zone extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_zone", nullable = false, length = 1000)
	private String name;

	@Column(name = "tp_zone")
	@Enumerated(EnumType.STRING)
	private ZoneType type;

	public Zone() {	}
	
	public Zone(String name, ZoneType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZoneType getType() {
		return type;
	}

	public void setType(ZoneType type) {
		this.type = type;
	}
}
