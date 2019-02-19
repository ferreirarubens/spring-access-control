/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.model.enums;

/**
 * @author Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public enum ProfileCategoryEnum implements IEnumDeserializer<ProfileCategoryEnum>{
	
	ADMIN("ADMIN");

	private final String text;

	private ProfileCategoryEnum(String text) {
		this.text = text;
	}

	@Override
	public ProfileCategoryEnum getTextEnumByString(String text) {
		for (ProfileCategoryEnum profileEnum : values())
			if (profileEnum.text.equals(text))
				return profileEnum;
		return null;
	}

	public String getText() {
		return text;
	}
}
