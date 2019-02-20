/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.config;

/**
 * @author Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public class ConstantsConfig {

	public static final String SERVICE_NAME = "accessControl";
	
	public static String getServiceName(String arg) {
		return String.format(SERVICE_NAME + "%s", arg);
	}
}
