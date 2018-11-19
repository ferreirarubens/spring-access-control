package com.ferreirarubens.accesscontrol.model.enums;

public interface IEnumDeserializer<T> {
	
	T getTextEnumByString(String text);
	
}
