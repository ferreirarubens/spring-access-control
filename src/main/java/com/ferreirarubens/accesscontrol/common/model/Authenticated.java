/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.model;

/**
 * @author rubens.ferreira
 *
 */
public interface Authenticated {
	String getLogin();

	String getPassword();

	void setPassword(String password);
}
