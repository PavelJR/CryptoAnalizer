package ru.javarush.alexeev.cryptoanalizer.commands;

import ru.javarush.alexeev.cryptoanalizer.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
