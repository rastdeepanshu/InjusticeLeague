package com.injusticeleague.main;

import com.injusticeleague.characters.Character;
import com.injusticeleague.characters.Gender;
import com.injusticeleague.utils.ScannerWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private ScannerWrapper wrapper;

    @InjectMocks
    private Game game;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMaleGender() {
        Mockito.when(wrapper.getStringInput()).thenReturn("1");
        assert(Gender.Male == game.getGender());
    }

    @Test
    public void testFemaleGender() {
        Mockito.when(wrapper.getStringInput()).thenReturn("2");
        assert(Gender.Female == game.getGender());
    }

    @Test
    public void testPowers() {
        Character character = new Character();
        character.setName("Dummy");
        character.setGender(Gender.Male);

        Mockito.when(wrapper.getStringInput())
                .thenReturn("1")
                .thenReturn("2")
                .thenReturn("3")
                .thenReturn("4")
                .thenReturn("5");

        game.choosePowers(character);

        assert(character.canFly());
        assert(character.canBreathInWater());
        assert(character.canDodgeBullets());
        assert(character.isRich());
        assert(character.canRunFast());
        Assert.assertFalse(character.canChangeWeather());
        Assert.assertFalse(character.hasLaserEyes());
    }
}
