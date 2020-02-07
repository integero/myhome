package ru.epam.homework.allCaros;

import org.h2.engine.User;

import java.sql.*;

public class DmlDdl {
    private static Statement currentStatment = null;

    public static void creatTabel(Connection conn, String tableCreation) {

        try (
/*                Connection connection = TryConnection
                .getInstance().getConnection("");*/
                Statement statement = conn.createStatement();) {
            statement.executeUpdate(tableCreation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveUser(Connection conn, User user) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO USERS (ID, NAME) VALUES (?, ?)";
            ps = conn.prepareStatement(sql);
/*            ps.setLong(1, user.id);
            ps.setString(2, user.name);
 */
            setToPreparedStatment(ps,user.id,1);
            setToPreparedStatment(ps,user.name,2);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Object getFieldFromResult(ResultSet reSet, Object field, String fieldName) {
        if (field instanceof Long)
            return (Long) reSet.getLong(fieldName);
        if (field instanceof String)
            return (String) reSet.getString(fieldName);
        return null;
    }

    private static void setToPreparedStatment(PreparedStatement ps, Object field, int index) {
        if (field instanceof Long) {
            ps.setLong(index, (Long) field);
        }
        if (field instanceof String)
            ps.setString(index, (String) field);
    }
}
