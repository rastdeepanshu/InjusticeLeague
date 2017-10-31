package com.injusticeleague.maps;

import com.injusticeleague.common.Bonus;

import java.util.Random;

public interface Map {

	default int getNumberOfBonus() {
		Random random = new Random();
		return random.nextInt(3);
	}

	Bonus getBonus();
}
