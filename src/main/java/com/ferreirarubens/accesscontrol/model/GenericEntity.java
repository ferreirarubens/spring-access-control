package com.ferreirarubens.accesscontrol.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.ferreirarubens.accesscontrol.common.config.data.serializers.LocalDateTimeDeserializer;
import com.ferreirarubens.accesscontrol.common.config.data.serializers.LocalDateTimeSerializer;
import com.ferreirarubens.accesscontrol.common.config.data.serializers.UserInsertUpdateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
 
/**
 * @author Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public abstract class GenericEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "base_gen")
	private long id;

	@Column(name = "dt_insert")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dateInsert;

	@Column(name = "dt_update")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dateUpdate;

	@ManyToOne
	@JoinColumn(name = "id_user_insert")
	@JsonSerialize(using = UserInsertUpdateSerializer.class)
	private User userInsert;

	@ManyToOne
	@JoinColumn(name = "id_user_update")
	@JsonSerialize(using = UserInsertUpdateSerializer.class)
	private User userUpdate;
	
	public GenericEntity() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(LocalDateTime dateInsert) {
		this.dateInsert = dateInsert;
	}

	public LocalDateTime getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(LocalDateTime dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public User getUserInsert() {
		return userInsert;
	}

	public void setUserInsert(User userInsert) {
		this.userInsert = userInsert;
	}

	public User getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(User userUpdate) {
		this.userUpdate = userUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericEntity other = (GenericEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
