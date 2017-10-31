package com.injusticeleague.common;

import com.injusticeleague.characters.Enemy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EnemiesUtil {

	private Map<Integer, Enemy> enemiesLevel;

	public EnemiesUtil() {
		enemiesLevel = Collections.unmodifiableMap(new HashMap<Integer, Enemy>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -8270525678925594030L;

			{
				put(1, Enemy.Superman);
				put(2, Enemy.Batman);
				put(3, Enemy.WonderWoman);
				put(4, Enemy.Flash);
				put(5, Enemy.Aquaman);
				put(6, Enemy.Cyborg);
			}
		});
	}

	/**
	 *
	 * @param level the current level of your ({@link com.injusticeleague.characters.Character}).
	 * @return the next ({@link Enemy})
	 */
	public Enemy getNextEnemy(int level) {
		return enemiesLevel.get(level - 1);
	}
}
