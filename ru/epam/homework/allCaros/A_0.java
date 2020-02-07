package ru.epam.homework.allCaros;

import ru.epam.homework.cargo.domain.AllCargo;
import ru.epam.homework.cargo.domain.CargoType;
import ru.epam.homework.allCaros.DmlDdl.*;

import java.sql.Connection;
import java.util.Date;

public class A_0 {
    public static void main(String[] args) throws Exception {
/*
        Date ddd=new Date();
        ddd.setYear(2007);
        ddd.setMonth(11);
        ddd.setDate(12);
        AllCargo car=new AllCargo(CargoType.CLOTHERS,"SSS",45,"12","wool",
                ddd,23);
        AllCargo car1=new AllCargo(CargoType.FOOD,"SSS",45,"12","wool",
                ddd,23);


        System.out.println(car);
        System.out.println(car1);

        DmlDdl.creatTabel("CREATE TABLE IF NOT EXISTS USERS (\n" +
                "   ID           BIGINT      ,\n" +
                "   NAME         VARCHAR(50)\n" +
                ");");
   */
        Connection dBoFAllCargo =TryConnection.getInstance().getConnection("tryCargoDB_2");

//        DmlDdl.creatTabel(tryConn,"CREATE TABLE (\n" +
        DmlDdl.creatTabel(dBoFAllCargo,"CREATE TABLE IF NOT EXISTS USERS (\n" +
                "   ID           BIGINT      ,\n" +
                "   NAME         VARCHAR(50)\n," +
                "   weight         VARCHAR(50)\n" +
                ");");
    }
}
