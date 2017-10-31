package com.injusticeleague.maps;

import com.injusticeleague.common.Bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityMap implements Map {

	private List<Bonus> availableBonuses = new ArrayList<Bonus>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2991493076175470134L;

		{
			add(Bonus.Alcohol);
			add(Bonus.Gun);
			add(Bonus.Television);
			add(Bonus.Drugs);
			add(Bonus.Fat);
		}
	};

	@Override
	public Bonus getBonus() {
		Random random = new Random();
		return availableBonuses.get(random.nextInt(availableBonuses.size()));
	}
}
