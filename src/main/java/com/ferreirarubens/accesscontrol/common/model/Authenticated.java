/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.model;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public interface Authenticated {
	String getLogin();

	String getPassword();

	void setPassword(String password);
}
