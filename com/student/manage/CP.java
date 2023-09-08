package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CP {
    static Connection con = null;
    public static Connection createConn(){

        try{
            //load driver
            Class.forName("com.mysql.jdbc.Driver");

            //create connection
            String user = "root";
            String password = "Poorvi@123";
//            String url = "jdbc:mysql://localhost:3306/student_manage?useUnicode=true&characterEncoding=UTF-8";
            String url = "jdbc:mysql://localhost:3306/student_manage";
//            jdbc:mysql://localhost:3306/student_manage?useUnicode=true&characterEncoding=UTF-8

            con = DriverManager.getConnection(url,user,password);
//            con= DriverManager.getConnection(url +"?" +
//                    "user="+ user+"&password=" +password);
            System.out.println(con);
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}
