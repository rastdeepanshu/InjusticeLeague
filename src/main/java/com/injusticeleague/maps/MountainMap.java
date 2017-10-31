package com.injusticeleague.maps;

import com.injusticeleague.common.Bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MountainMap implements Map {

	private List<Bonus> availableBonuses = new ArrayList<Bonus>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5640286911146260731L;

		{
			add(Bonus.Alcohol);
			add(Bonus.Herbs);
			add(Bonus.Kryptonite);
			add(Bonus.Boredom);
		}
	};

	@Override
	public Bonus getBonus() {
		Random random = new Random();
		return availableBonuses.get(random.nextInt(availableBonuses.size()));
	}
}
