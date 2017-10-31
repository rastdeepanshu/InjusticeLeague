package com.injusticeleague.common;

import com.injusticeleague.characters.Enemy;
import org.junit.Test;

public class EnemiesUtilTest {

    @Test
    public void testNextEnemy() {
        EnemiesUtil enemiesUtil = new EnemiesUtil();
        Enemy enemy = enemiesUtil.getNextEnemy(4);

        assert("Wonder Woman".equals(enemy.getName()));
    }
}
