package ru.javarush.alexeev.cryptoanalizer;

import ru.javarush.alexeev.cryptoanalizer.constants.Constants;
import ru.javarush.alexeev.cryptoanalizer.entity.Result;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        check(args);
        String path = args[0];
        int key = Integer.parseInt(args[1]);

        String text = input(path);
        System.out.println("origin: \n" + text + "\n");

        String rsl = encode(text, key);
        System.out.println("encode: \n" + rsl + "\n");

        rsl = decode(rsl, key);
        System.out.println("decode: \n" + rsl + "\n");

        Application application = new Application();
        Result result = application.run(args);
    }

    private static void check(String[] args) {
        if (args.length < 2) {
            System.out.println("Empty arguments");
            System.exit(0);
        }
    }

    private static String encode(String text, int key) {
        StringBuilder rsl = new StringBuilder();
        for (char chOuter : text.toCharArray()) {
            for (char chInner : Constants.ALPHABET.toCharArray()) {
                if (chOuter == chInner) {
                    rsl.append((char) (chOuter + key));
                }
            }
        }
        return rsl.toString();
    }

    private static String decode(String text, int key) {
        StringBuilder rsl = new StringBuilder();
        for (char chOuter : text.toCharArray()) {
            for (char chInner : Constants.ALPHABET.toCharArray()) {
                if (chOuter == chInner) {
                    rsl.append((char) (chOuter - key));
                }
            }
        }
        return rsl.toString();
    }

    private static String input(String path) {
        StringBuilder text = new StringBuilder();
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                text.append(br.readLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text.toString();
    }
}
