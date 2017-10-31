package com.injusticeleague.utils;

import java.util.Scanner;

public class ScannerWrapper {
    private Scanner scanner;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStringInput() {
        return scanner.nextLine();
    }
}
