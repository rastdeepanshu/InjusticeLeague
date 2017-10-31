package com.injusticeleague.maps;

import com.injusticeleague.common.Bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeaMap implements Map {

	private List<Bonus> availableBonuses = new ArrayList<Bonus>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2753189759446751098L;

		{
			add(Bonus.Herbs);
			add(Bonus.Boredom);
			add(Bonus.Fat);
		}
	};

	@Override
	public Bonus getBonus() {
		Random random = new Random();
		return availableBonuses.get(random.nextInt(availableBonuses.size()));
	}
}
