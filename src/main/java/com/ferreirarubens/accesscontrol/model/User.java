package com.ferreirarubens.accesscontrol.model;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.ferreirarubens.accesscontrol.model.interfaces.Authenticated;

/**
 * @author Renatão
 *
 */
@Entity
@SequenceGenerator(initialValue = 1, name = "base_gen", sequenceName = "user_seq")
@Table(name = "users")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id_user")) })
public class User extends GenericEntity implements Authenticated {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ds_login", nullable = false, length = 50)
	private String login;

	@Column(name = "ds_password", nullable = false)
	private String password;

	@Column(name = "nm_user", nullable = false, length = 1000)
	private String name;

	@Column(name = "nr_cpf", nullable = false, length = 14)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "id_profile", nullable = false)
	private Profile profile;

	public User() {	}
	
	public User(String login, String password, String name, String cpf, Profile profile) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
		this.profile = profile;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@JsonProperty(access = Access.WRITE_ONLY)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Collection<String> getRoles() {
		if (Objects.nonNull(getProfile())) {
			return getProfile().getRoles();
		}
		return null;
	}

}
