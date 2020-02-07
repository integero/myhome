package ru.epam.homework.allCaros;

import java.sql.Connection;
import java.sql.DriverManager;

public class TryConnection implements Cannactable {
    private static final TryConnection INSTANCE = new TryConnection();
    public TryConnection() {
    }

     public static TryConnection getInstance() {
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
