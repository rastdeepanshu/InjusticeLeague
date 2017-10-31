package com.injusticeleague.utils;

import com.injusticeleague.characters.Character;
import com.injusticeleague.characters.Gender;
import org.junit.Test;

public class FileIOTest {

    @Test
    public void testFileReadWrite() {
        FileIO fileIO = new FileIO();
        String filePath = FileIOTest.class.getClassLoader().getResource("savegame").getPath();

        Character character = new Character("Test", "Test object", Gender.Male, true, true, true,
                true, true, false, false);

        fileIO.writeToFile(character, filePath);

        Character readChar = fileIO.readFromFile(filePath);

        assert(character.equals(readChar));
    }
}
