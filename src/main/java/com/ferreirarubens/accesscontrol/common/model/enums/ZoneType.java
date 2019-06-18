/**
 * 
 */
package com.ferreirarubens.accesscontrol.common.model.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ferreira Rubens <rubensdefrancaferreira@gmail.com>
 *
 */
public enum ZoneType implements Comparable<ZoneType> {
	SECTOR("enum.zone.sector"), AREA("enum.zone.area");

	private final String zoneType;

	private ZoneType(String zoneType) {
		this.zoneType = zoneType;
	}

	public static ZoneType getZoneType(String zoneType) {
		for (ZoneType ZoneType : values())
			if (ZoneType.zoneType.equals(zoneType))
				return ZoneType;
		return null;
	}

	public static List<String> getAll() {
		List<String> ZoneTypees = new ArrayList<String>();

		for (ZoneType ZoneType : values())
			ZoneTypees.add(ZoneType.zoneType);

		Collections.sort(ZoneTypees);

		return ZoneTypees;
	}
}