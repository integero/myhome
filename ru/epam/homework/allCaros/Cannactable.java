package ru.epam.homework.allCaros;

import java.sql.Connection;

public interface Cannactable {
    Connection getConnection(String db) throws Exception;
}
