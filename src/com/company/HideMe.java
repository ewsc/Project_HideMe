package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HideMe {

    public static final Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void slowDownOutput(String str) throws InterruptedException {
        for (int i = 0; i < str.length(); i++) {
            TimeUnit.MILLISECONDS.sleep(30);
            System.out.print(str.charAt(i));
        }
    }

    public static void introduceYourSelf() throws InterruptedException {
        slowDownOutput("\n> Hi! This program will help you to encrypt your message using Caesar's cipher.\n\n");
    }

    public static String inputMessage() throws InterruptedException {
        slowDownOutput("> Please note: Only English letters are supported.\n");
        slowDownOutput("> Input the message you want to encrypt / decrypt: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static boolean checkForLetter(char a) {
        boolean isExists = false;
        for (char letter: alphabet) {
            if (letter == a) {
                isExists = true;
                break;
            }
        }
        return isExists;
    }

    public static String encryptMessage(String message, byte amount) {
        StringBuilder result = new StringBuilder();
        boolean isLetter;
        for (char character : message.toCharArray()) {
            isLetter = checkForLetter(character);
            if (isLetter) {
                int originalAlphabetPosition = character - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + amount) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void echoResults(String result, byte amount) throws InterruptedException {
        if (amount < 10) {
            slowDownOutput(">  [" + amount + "]: " + result + "\n");
        }
        else {
            slowDownOutput("> [" + amount + "]: " + result + "\n");
        }
    }

    public static void sayGoodbye() throws InterruptedException {
        slowDownOutput("\n> You are free to use encrypted message.\n");
        slowDownOutput("> Developed by Azam Alamov, 2021. <3\n");
    }

    public static void presAnyKey() throws InterruptedException {
        slowDownOutput("\n> Press Enter key to terminate program...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        introduceYourSelf();
        String message = inputMessage().toUpperCase(Locale.ROOT);
        System.out.println();
        for (byte amount = 0; amount < 26; amount++) {
            String result = encryptMessage(message, amount);
            echoResults(result, amount);
        }
        sayGoodbye();
        presAnyKey();
    }
}
