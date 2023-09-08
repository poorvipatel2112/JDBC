package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student st){
        boolean f =false;

        try{
            Connection con = CP.createConn();
            String q = "insert into student(sname,sphone,scity) values(?,?,?)";
            //preparedStatement
            PreparedStatement pstmt =  con.prepareStatement(q);

            //set the value of parameters
            pstmt.setString(1,st.getStudentName());
            pstmt.setString(2,st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            //execute
            pstmt.executeUpdate();
            f = true;

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        boolean f =false;

        try{
            Connection con = CP.createConn();
            String q = "delete from student where sid=?";
            //preparedStatement
            PreparedStatement pstmt =  con.prepareStatement(q);

            //set the value of parameters
            pstmt.setInt(1,userId);

            //execute
            pstmt.executeUpdate();
            f = true;

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return f;
    }

    public static void showAllStudent() {
        boolean f =false;

        try{
            Connection con = CP.createConn();
            String q = "select * from student;";
            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(q);
            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString("scity");

                System.out.println("ID: " + id);
                System.out.println("name: " + name);
                System.out.println("phone: " + phone);
                System.out.println("city: " + city);
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
