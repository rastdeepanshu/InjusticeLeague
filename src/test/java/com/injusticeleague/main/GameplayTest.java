package com.injusticeleague.main;

import com.injusticeleague.characters.Character;
import com.injusticeleague.utils.ScannerWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameplayTest {

    @Mock
    private ScannerWrapper wrapper;

    @InjectMocks
    private Gameplay gameplay;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void notSufficientHealthTest() {
        Character character = new Character();
        character.updateStrengthPoints(-50);

        Assert.assertFalse(gameplay.hasHealthSufficient(character));
    }

    @Test
    public void sufficientHealthTest() {
        Character character = new Character();
        character.updateStrengthPoints(50);

        assert(gameplay.hasHealthSufficient(character));
    }
}
