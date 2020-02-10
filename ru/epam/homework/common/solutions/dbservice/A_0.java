package ru.epam.homework.common.solutions.dbservice;


import java.sql.Connection;


public class A_0 {
    public static void main(String[] args) throws Exception {
        Connection myDb=DbUtils.dbConnection("cargo3");
        DbUtils.createAndFillAllTables(myDb);
    }
}
