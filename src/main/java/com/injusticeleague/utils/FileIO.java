package com.injusticeleague.utils;

import com.injusticeleague.characters.Character;

import java.io.*;
import java.util.concurrent.*;

/**
 * Class to handle file IO.
 */
public class FileIO {

    /**
     * The method saves the ({@link Character}) in the file in user's home directory.
     * @param character the ({@link Character}) object which is required to be saved.
     * @param filename name of the file in which the object has to be saved.
     */
    public void writeToFile(Character character, String filename) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(() -> {
            try {
                File file = new File(filename);

                FileOutputStream foutStream = new FileOutputStream(file, false);
                ObjectOutputStream oOutStream = new ObjectOutputStream(foutStream);

                oOutStream.writeObject(character);

                oOutStream.close();
                foutStream.close();
            } catch (IOException e) {
                System.out.println(Constants.ERROR + ": " + e.getMessage());
            }
        });

        try {
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(Constants.ERROR + ": " + e.getMessage());
        }
    }

    /**
     * The method retrieves the ({@link Character}) from the file in user's home directory.
     * @param filename name of the file from which the object has to be read.
     */
    public Character readFromFile(String filename) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Character> futChar = service.submit(new Callable<Character>() {
            @Override
            public Character call() throws Exception {
                Character character = null;
                try {
                    File file = new File(filename);

                    if (!file.exists()) {
                        return null;
                    }
                    FileInputStream fInStream = new FileInputStream(file);
                    ObjectInputStream oInStream = new ObjectInputStream(fInStream);

                    character = (Character) oInStream.readObject();

                    oInStream.close();
                    fInStream.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(Constants.ERROR + ": " + e.getMessage());
                }
                return character;
            }
        });

        try {
            service.shutdown();
            return futChar.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println(Constants.ERROR + ": " + e.getMessage());
        }
        return null;
    }
}
