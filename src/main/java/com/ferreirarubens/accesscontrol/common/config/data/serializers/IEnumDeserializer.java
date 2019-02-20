package com.ferreirarubens.accesscontrol.common.config.data.serializers;

public interface IEnumDeserializer<T> {
	
	T getTextEnumByString(String text);
	
	String translate();
	
}
