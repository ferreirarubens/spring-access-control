/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.web.validator;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ferreirarubens.accesscontrol.common.model.GenericEntity;
import com.ferreirarubens.accesscontrol.common.model.enums.ProfileCategoryEnum;
import com.ferreirarubens.accesscontrol.common.web.validator.util.StringValidator;

/**
 * @auhtor Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public abstract class AbstractValidator<T extends GenericEntity> implements Validator {

	private Class<T> clazz;
	private RequestMethod method;

	@SuppressWarnings("unchecked")
	public AbstractValidator() {
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public boolean isInsert() {
		return RequestMethod.POST == getMethod();
	}

	public boolean isUpdate() {
		return RequestMethod.PUT == getMethod();
	}
	
	private String classNameFirstLowerCase(String string){
		return string.substring(0, 1).toLowerCase() + string.substring(1, string.length());
	}

	@Override
	public void validate(Object object, Errors errors) {
		GenericEntity entity = (GenericEntity) object;
		if (entity.getId() <= 0 && !isInsert())
			errors.reject(classNameFirstLowerCase(clazz.getSimpleName()) + "GlobalError.updateError",
					clazz.getSimpleName() + " Register does not exist!");
		else if (entity.getId() > 0 && !isUpdate()) {
			errors.reject(classNameFirstLowerCase(clazz.getSimpleName()) + "GlobalError.insertError", clazz.getSimpleName()
					+ " Register already exists! (change the id to '0', so that a new record is generated)");
		} else
			validateEntity(object, errors);
	}

	public abstract void validateEntity(Object object, Errors errors);

	public RequestMethod getMethod() {
		return method;
	}

	public void setMethod(RequestMethod method) {
		this.method = method;
	}

	public boolean objectNotExist(T value, Errors errors) {
		if (Objects.isNull(value)) {
			errors.reject(classNameFirstLowerCase(clazz.getSimpleName()) + "GlobalError.objectNotExist",
					"The object does not exist in the database.");
			return true;
		}
		return false;
	}

	public boolean isEqualZero(String fieldName, int value, Errors errors) {
		if (value == 0) {
			errors.rejectValue(classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".emptyObject",
					"The value result in zero.");
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean objectIsNull(String fieldName, Object value, Errors errors) {
		if ((Objects.isNull(value)) || ((value instanceof ArrayList) && ((ArrayList<Object>) value).size() == 0)) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".emptyObject",
					"You must complete the information");
			return true;
		}
		return false;
	}

	public <Type> boolean objectIsNull(Type value, Errors errors) {
		if (this.objectIsNull(value)) {
			errors.reject(value.getClass().getSimpleName().toLowerCase() + ".GlobalError.emptyObject",
					"You must complete the information");
			return true;
		}
		return false;
	}

	public <Type> boolean objectIsNull(Type value) {
		if (Objects.isNull(value)) {
			return true;
		}
		return false;
	}

	public <Type> boolean isNotNullOrEmpty(Collection<Type> value) {
		if (Objects.nonNull(value) && !value.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isNullOrEmpty(String fieldName, String value, Errors errors) {
		if (Objects.isNull(value) || value.trim().isEmpty()) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".empty",
					"The " + fieldName + " must be informed");
			return true;
		}
		return false;
	}

	public boolean isNullOrEmpty(String value) {
		return (Objects.isNull(value) || value.trim().isEmpty()) ? true : false;
	}

	public boolean containsSpaceAndSpecialCharacter(String fieldName, String value, Errors errors) {
		String specialAndSpaces = "!@#$%^&*() _";
		String pattern = ".*[" + Pattern.quote(specialAndSpaces) + "].*";
		if (value == null || value.matches(pattern)) {
			errors.rejectValue(fieldName,
					classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".spaceEspecialCharacter",
					"The " + fieldName + " is required and must not contain special characters and no space.");
			return true;
		}
		return false;
	}

	public boolean containsSpecialCharacter(String fieldName, String value, Errors errors) {
		String specialAndSpaces = "!@#$%^&*()";
		String pattern = ".*[" + Pattern.quote(specialAndSpaces) + "].*";
		if (value == null || value.matches(pattern)) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".specialCharacter",
					"The " + fieldName + " is required and must not contain special characters.");
			return true;
		}
		return false;
	}

	public boolean checkSize(String fieldName, String value, long min, long max, Errors errors) {
		if (value == null || value.length() < min || value.length() > max) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".invalidSize",
					"The " + fieldName + " must be larger than or equal to " + min + " and less equal to " + max);
			return true;
		}
		return false;
	}

	public boolean checkUnique(String fieldName, List<T> list, Errors errors) {
		if (list.size() > 0) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".notUnique",
					"The " + fieldName + " must be unique");
			return true;
		}
		return false;
	}

	public boolean checkUniqueRegister(String fieldName, List<T> list, Errors errors) {
		if (list.size() > 0) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".uniqueRegister",
					"The " + fieldName + " must be unique");
			return true;
		}
		return false;
	}

	public boolean checkProfileCategoryEnum(String fieldName, String value, Errors errors) {
		
		boolean find = false;
		
		for(ProfileCategoryEnum profileCategory: ProfileCategoryEnum.values()){
			if(profileCategory.name().equals(value)){
				find = true;
				break;
			}
		}
		
		if(!find)
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".invalidProfileCategory",
					"Category " + fieldName + " does not exist");
			
		return false;
	}

	public boolean checkInterval(String fieldName, int value, long min, long max, Errors errors) {
		if (value == 0 || value < min || value > max) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".invalidInterval",
					"The " + fieldName + " must be larger than or equal to " + min + " and less equal to " + max);
			return true;
		}
		return false;
	}

	public boolean noHasOnlyAlphaNumericAndUpperCaseAndNotSpace(String fieldName, String value, Errors errors) {
		if (!StringValidator.onlyAlphaNumericAndUpperCaseAndNotSpace(value)) {
			errors.rejectValue(fieldName,
					classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".alphaNumericNoSpacesAndUpperCase",
					"The " + fieldName + " must be alphanumeric, uppercase characters and may not have space");
			return true;
		}
		return false;
	}

	public boolean isDateNull(String fieldName, Date value, Errors errors) {
		if (value == null) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".dateEmpty",
					"The " + fieldName + " is required.");
			return true;
		}
		return false;
	}

	public boolean checkDiferentSize(String fieldName, String value, long tamanho, Errors errors) {
		if (fieldName == null || value.trim().length() != tamanho) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".invalidSize",
					"The " + fieldName + " should have a length of " + tamanho);
			return true;
		}
		return false;
	}

	public boolean containsLowerCase(String fieldName, String value, Errors errors) {
		if (value == null || !value.equals(value.toUpperCase())) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".lowerCase",
					"The " + fieldName + " must not contain lowercase characters.");
			return true;
		}
		return false;
	}

	public boolean containsUpperCase(String fieldName, String value, Errors errors) {
		if (value == null || !value.equals(value.toLowerCase())) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".upperCase",
					"The " + fieldName + " is required and must not contain uppercase characters.");
			return true;
		}
		return false;
	}

	public void repeatedField(String fieldName, String value, Errors errors) {
		errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".existing",
				"There is already record with that " + fieldName + " registered.");
	}

	public boolean containsSpace(String fieldName, String value, Errors errors) {
		if (StringValidator.containsSpace(value)) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".space",
					"The " + fieldName + " should not contain space");
			return true;
		}
		return false;
	}

	public boolean noHasOnlyDigits(String fieldName, String value, Errors errors) {
		if (!StringValidator.onlyDigits(value)) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".onlyDigits",
					"The " + fieldName + " must contain only digits");
			return true;
		}
		return false;
	}

	public boolean isDecimalValid(String fieldName, String value, Errors errors) {
		if (!StringValidator.isFloatNumber(value)) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".realNumber",
					"The " + fieldName + " must contain only digits");
			return false;
		}
		return true;

	}

	public boolean isEmailValid(String fieldName, String value, Errors errors) {
		if (!StringValidator.isEmailValid(value)) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + ".emailInvalid",
					"The email must have the following standard email and have only tiny characters");
			return true;
		}
		return false;
	}

	public boolean isCNPJValid(String cnpj, Errors errors) {

		boolean invalid = (cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
				|| cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444")
				|| cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
				|| cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || (cnpj.length() != 14));

		int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

		Integer d1 = calculateDigit(cnpj.substring(0, 12), pesoCNPJ);
		Integer d2 = calculateDigit(cnpj.substring(0, 12) + d1, pesoCNPJ);

		if (!cnpj.equals(cnpj.substring(0, 12) + d1.toString() + d2.toString()) || invalid) {
			errors.rejectValue("cnpj", classNameFirstLowerCase(clazz.getSimpleName()) + ".cnpj.invalid",
					"Informed cnpj not available");
			return true;
		}
		return false;
	}

	public boolean isCPFValid(String cpf, Errors errors) {

		boolean invalid = (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11));

		int[] weightCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

		Integer digit1 = calculateDigit(cpf.substring(0, 9), weightCPF);
		Integer digit2 = calculateDigit(cpf.substring(0, 9) + digit1, weightCPF);
		if (!cpf.equals(cpf.substring(0, 9) + digit1.toString() + digit2.toString()) || invalid) {
			errors.rejectValue("cpf", classNameFirstLowerCase(clazz.getSimpleName()) + ".cpf.invalid", "The CPF is invalid");
			return true;
		}
		return false;
	}

	private static int calculateDigit(String str, int[] weight) {
		int sum = 0;
		for (int index = str.length() - 1, digit; index >= 0; index--) {
			digit = Integer.parseInt(str.substring(index, index + 1));
			sum += digit * weight[weight.length - str.length() + index];
		}
		sum = 11 - sum % 11;
		return sum > 9 ? 0 : sum;
	}

	protected boolean isNumberInvalid(String fieldName, int number, Errors errors) {
		if (number <= 0) {
			errors.rejectValue(fieldName, classNameFirstLowerCase(clazz.getSimpleName()) + "." + fieldName + ".invalid", "The " + fieldName + " must be greather than 0");
			return true;
		}
		return false;
	}

}