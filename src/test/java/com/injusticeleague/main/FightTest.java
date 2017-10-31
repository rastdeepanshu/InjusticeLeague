package com.injusticeleague.main;

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
public class FightTest {

    @Mock
    private ScannerWrapper wrapper;

    @InjectMocks
    private Fight fight;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCorrectAnswer() {
        int correctAnswer = fight.createQuestion(20);

        Mockito.when(wrapper.getStringInput()).thenReturn(correctAnswer+"");
        assert(fight.isAnswerCorrect(correctAnswer));
    }

    @Test
    public void testIncorrectAnswer() {
        int correctAnswer = fight.createQuestion(20);

        Mockito.when(wrapper.getStringInput()).thenReturn(correctAnswer+2+"");
        Assert.assertFalse(fight.isAnswerCorrect(correctAnswer));
    }
}
