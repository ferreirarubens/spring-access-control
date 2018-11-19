/**
 * 
 */
package com.ferreirarubens.accesscontrol.model.enums;

/**
 * @author rubens.ferreira
 *
 */
public enum ProfileCategoryEnum implements IEnumDeserializer<ProfileCategoryEnum>{
	
	STUDENT("STUDENT"),
	SECRETARY("SECRETARY"),
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
