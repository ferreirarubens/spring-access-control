package com.ferreirarubens.accesscontrol.common.model.enums;

public interface IEnumDeserializer<T> {
	
	T getTextEnumByString(String text);
	
}
