/**
 * 
 */
package com.ferreirarubens.accesscontrol.model.interfaces;

/**
 * @author rubens.ferreira
 *
 */
public interface Authenticated {
	String getLogin();

	String getPassword();

	void setPassword(String password);
}
