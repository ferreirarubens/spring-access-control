/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.model.enums;

import com.ferreirarubens.accesscontrol.common.config.ConstantsConfig;
import com.ferreirarubens.accesscontrol.common.config.data.serializers.IEnumDeserializer;

/**
 * @author Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public enum ProfileCategoryEnum implements IEnumDeserializer<ProfileCategoryEnum>{
	
	ADMIN("admin");

	private final String text;

	private ProfileCategoryEnum(String text) {
		this.text = text;
	}

	@Override
	public ProfileCategoryEnum getTextEnumByString(String text) {
		for (ProfileCategoryEnum profileEnum : values())
			if (profileEnum.text.equalsIgnoreCase(text))
				return profileEnum;
		return null;
	}

	public String getText() {
		return text.toUpperCase();
	}

	@Override
	public String translate() {
		return ConstantsConfig.getServiceName("profileCategory." + this.text);
	}
}
