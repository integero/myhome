package ru.epam.homework.common.solutions.dbservice;


import java.sql.Connection;
import java.sql.DriverManager;

public class GetMyConnection implements DbConnection {
    private static final GetMyConnection INSTANCE = new GetMyConnection();
    public GetMyConnection() {
    }

     public static GetMyConnection getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection(String dateBase) throws Exception {
        String driverClass = "org.h2.Driver";
        Class.forName(driverClass);

        return DriverManager
                .getConnection("jdbc:h2:~/"+dateBase,
                        "sa",
                        "");
    }
}
