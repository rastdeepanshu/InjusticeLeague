package com.injusticeleague.maps;

import com.injusticeleague.common.Bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DesertMap implements Map {

	private List<Bonus> availableBonuses = new ArrayList<Bonus>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5449667924974773567L;

		{
			add(Bonus.Alcohol);
			add(Bonus.Gun);
			add(Bonus.Boredom);
		}
	};

	@Override
	public Bonus getBonus() {
		Random random = new Random();
		return availableBonuses.get(random.nextInt(availableBonuses.size()));
	}
}
