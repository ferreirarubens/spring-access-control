/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.web.validator.util;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public class StringValidator {
	private enum RegexEnum {
		DIGIT("[0-9]+"), FLOAT_NUMBER("^[-+]?[0-9]*\\.?[0-9]+$"), ALPHANUMERIC_UPPERCASE("^[A-Z 0-9]+$"),
		NUMBER_AND_LETTER_UPPERCASE("^(?=.*[A-Z])(?=.*[0-9])[A-Z 0-9]+$"),
		ALPHANUMERIC_UPPERCASE_NOT_SPACE("^[A-Z0-9]+$"),
		NUMBER_AND_LETTER_UPPERCASE_NOT_SPACE("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$"),
		NAME_LASTNAME("(([a-zA-Z�-�]{2,})\\s+)+[a-zA-Z�-�]+$"),
		VALID_EMAIL("^([a-z0-9_.+-])+\\@(([a-z0-9-])+\\.)+([a-z0-9]{2,4})+$"),
		PASSWORD_VALIDATION("^(?=.*[^a-zA-Z])(?=.*[a-z])(?=.*[A-Z])\\S{8,}$"), SPACE_VALIDATION("^.*[\\s].*$");

		private final String regex;

		RegexEnum(String regex) {
			this.regex = regex;
		}

		public String getRegex() {
			return regex;
		}

	}

	private StringValidator() {
	}

	public static boolean onlyDigits(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.DIGIT.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}
	}

	public static boolean validPassword(final String password) {
		if (Objects.nonNull(password)) {
			Pattern pattern = Pattern.compile(RegexEnum.PASSWORD_VALIDATION.getRegex());
			return pattern.matcher(password).matches();
		} else {
			return false;
		}
	}

	public static boolean isFloatNumber(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.FLOAT_NUMBER.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}
	}

	public static boolean onlyAlphaNumericAndUpperCase(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.ALPHANUMERIC_UPPERCASE.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}

	}

	public static boolean onlyNumericAndLetterAndUpperCase(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.NUMBER_AND_LETTER_UPPERCASE.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}

	}

	public static boolean onlyAlphaNumericAndUpperCaseAndNotSpace(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.ALPHANUMERIC_UPPERCASE_NOT_SPACE.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}
	}

	public static boolean onlyNumericAndLetterAlphaNumericAndUpperCaseAndNotSpace(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.NUMBER_AND_LETTER_UPPERCASE_NOT_SPACE.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}
	}

	public static boolean nameAndLastName(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.NAME_LASTNAME.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}
	}

	public static boolean containsSpace(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.SPACE_VALIDATION.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}
	}

	public static boolean onlyAlphaNumericAndUpperCaseAndNotBeginAndEndingSpaceAndNoDoubleSpace(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.ALPHANUMERIC_UPPERCASE.getRegex());
			return pattern.matcher(field).matches() && field.equals(field.replaceAll("\\s+", " "))
					&& field.equals(field.trim());
		} else {
			return false;
		}
	}

	public static boolean onlyNumericAndLetterAlphaNumericAndUpperCaseAndNotBeginAndEndingSpaceAndNoDoubleSpace(
			final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.NUMBER_AND_LETTER_UPPERCASE.getRegex());
			return pattern.matcher(field).matches() && field.equals(field.replaceAll("\\s+", " "))
					&& field.equals(field.trim());
		} else {
			return false;
		}
	}

	public static boolean isEmailValid(final String field) {
		if (Objects.nonNull(field)) {
			Pattern pattern = Pattern.compile(RegexEnum.VALID_EMAIL.getRegex());
			return pattern.matcher(field).matches();
		} else {
			return false;
		}
	}
}
