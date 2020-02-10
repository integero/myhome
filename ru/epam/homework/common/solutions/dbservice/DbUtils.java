package ru.epam.homework.common.solutions.dbservice;

import ru.epam.homework.cargo.domain.FoodCargo;

import java.sql.*;

public class DbUtils {
    public static Connection dbConnection(String dbName) throws Exception {
        return GetMyConnection.getInstance().getConnection(dbName);
    }

    public static void creatTable(Connection conn, String tableCreation) {
        try (
                Statement statement = conn.createStatement();) {
            statement.executeUpdate(tableCreation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void  createAndFillAllTables(Connection conn) throws Exception {

        creatTable(conn, SqlDbDdl.sqlCreateCargoTable());
        creatTable(conn, SqlDbDdl.sqlInitCargos());
        creatTable(conn, SqlDbDdl.sqlCreateCarrierTable());
        creatTable(conn, SqlDbDdl.sqlInitCarriers());
        creatTable(conn, SqlDbDdl.sqlCreateTransportationTable());
        creatTable(conn, SqlDbDdl.sqlInitTransportations());

    }
    private static<T> void saveSomething(Connection conn, T smthng) {
        PreparedStatement ps = null;
       try {
            if (smthng instanceof FoodCargo){
                String sql = SqlDbDdl.sqlInsertInToFoodCargo();
                ps = conn.prepareStatement(sql);
                FoodCargo foodCargo=(FoodCargo)smthng;

                ps.setLong(1,foodCargo.getId());
                ps.setDate(2, (Date) foodCargo.getExpirationDate());
//          или
                setToPreparedStatment(ps, 1,foodCargo.getId());
                setToPreparedStatment(ps, 2, (Date) foodCargo.getExpirationDate());

//          Оба ваорианта заливки мне не нравятся. Думаю, что можно вытащить методы get** из smthng
//          с помощью Reflection и залить данные в цикле?? Isn't it?

                ps.executeUpdate();
            }
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
    private static void setToPreparedStatment(PreparedStatement ps, int index, Object field) throws SQLException {
        if (field instanceof Long) {
            ps.setLong(index, (Long) field);
        }
        if (field instanceof String)
            ps.setString(index, (String) field);
    }

    private static Object getFieldFromResult(ResultSet reSet, Object field, String fieldName) throws SQLException {
        if (field instanceof Long)
            return (Long) reSet.getLong(fieldName);
        if (field instanceof String)
            return (String) reSet.getString(fieldName);
        return null;
    }


}
