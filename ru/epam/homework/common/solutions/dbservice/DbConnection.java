package ru.epam.homework.common.solutions.dbservice;

import java.sql.Connection;

public interface DbConnection {
    Connection getConnection(String db) throws Exception;
}
