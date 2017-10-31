package com.injusticeleague.maps;

/**
 * Returns a desired implementation of ({@link Map}) interface.
 */
public class MapFactory {

	/**
	 *
	 * @param code specific code to access specific ({@link Map}) implementation.
	 *             Options are: "city", "desert", "mountain" and "sea".
	 * @return the required instance.
	 */
	public Map getMap(String code) {
		switch (code) {
		case "city":
			return new CityMap();
		case "desert":
			return new DesertMap();
		case "mountain":
			return new MountainMap();
		case "sea":
			return new SeaMap();
		}
		return null;
	}
}
