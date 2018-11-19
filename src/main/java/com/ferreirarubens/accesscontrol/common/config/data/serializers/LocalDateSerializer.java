package com.ferreirarubens.accesscontrol.common.config.data.serializers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateSerializer  extends StdSerializer<LocalDate> {

	private static final long serialVersionUID = 1L;

	public LocalDateSerializer() {
		this(null);
	}

	protected LocalDateSerializer(Class<LocalDate> t) {
		super(t);
	}

	@Override
	public void serialize(LocalDate date, JsonGenerator generator, SerializerProvider provider)
			throws IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if (Objects.nonNull(date)) {
			String formatDate = date.format(formatter);
			generator.writeObject(formatDate);
		} else {
			generator.writeObject("0000-00-00");
		}
	}

}
