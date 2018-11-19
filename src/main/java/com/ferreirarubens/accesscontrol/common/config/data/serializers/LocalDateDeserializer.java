package com.ferreirarubens.accesscontrol.common.config.data.serializers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
	private static final long serialVersionUID = 1L;

	private LocalDateDeserializer() {
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		String string = parser.getText().trim();
		if (string.length() == 0)
			return null;
		return LocalDate.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
