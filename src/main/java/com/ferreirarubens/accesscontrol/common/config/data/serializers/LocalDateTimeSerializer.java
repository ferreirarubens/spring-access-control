package com.ferreirarubens.accesscontrol.common.config.data.serializers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateTimeSerializer  extends StdSerializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	public LocalDateTimeSerializer() {
		this(null);
	}

	protected LocalDateTimeSerializer(Class<LocalDateTime> t) {
		super(t);
	}

	@Override
	public void serialize(LocalDateTime dateTime, JsonGenerator generator, SerializerProvider provider)
			throws IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if (Objects.nonNull(dateTime)) {
			String formatDateTime = dateTime.format(formatter);
			generator.writeObject(formatDateTime);
		} else {
			generator.writeObject("0000-00-00 00:00:00");
		}
	}

}
