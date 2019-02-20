package com.ferreirarubens.accesscontrol.common.config.data.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
	}
}