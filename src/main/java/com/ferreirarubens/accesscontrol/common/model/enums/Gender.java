package com.ferreirarubens.accesscontrol.common.model.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Gender implements Comparable<Gender>{
	FEMALE("enum.gender.female"), MALE("enum.gender.male");
	
	private final String gender;

	private Gender(String gender) {
		this.gender = gender;
	}
	
	public static Gender getGender(String gender) {
		for (Gender Gender : values())
			if (Gender.gender.equals(gender))
				return Gender;
		return null;
	}

	public static List<String> getAll() {
		List<String> Genderes = new ArrayList<String>();

		for (Gender Gender : values())
			Genderes.add(Gender.gender);

		Collections.sort(Genderes);

		return Genderes;
	}
}
