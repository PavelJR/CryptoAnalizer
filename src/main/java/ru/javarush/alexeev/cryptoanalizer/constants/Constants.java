package ru.javarush.alexeev.cryptoanalizer.constants;

import java.util.Locale;

public class Constants {
    private static final String RUS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String ENG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String PUNCTUATION_MARKS = " []{}()|/\\\"'`,.:;!?#$%&@*+-~<=>^_";
    public static final String ALPHABET =
            RUS + ENG + RUS.toLowerCase() + ENG.toLowerCase() + NUMBERS + PUNCTUATION_MARKS;
}
