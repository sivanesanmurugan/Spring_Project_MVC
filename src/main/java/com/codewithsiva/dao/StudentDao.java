package com.codewithsiva.dao;

import com.codewithsiva.database.Db_connection;

import com.codewithsiva.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private String SELECT_QUERY = "SELECT id,Firstname,Lastname FROM student WHERE Firstname=? and Lastname=?;";
    private String INSERT_QUERY = "insert into student(Firstname,Lastname,Country,Language,OS) values(?,?,?,?,?);";
    private String SELECT_ALL_USER="SELECT id,Firstname,Lastname,Country,Language,OS FROM student;";
    Connection connection;

    public StudentDao() throws SQLException, ClassNotFoundException {
        connection = Db_connection.getconnection();
    }

    public Student loginuser(String Firstname, String Lastname) throws SQLException {
        Student student = null;

        PreparedStatement p1 = connection.prepareStatement(SELECT_QUERY);
        p1.setString(1, Firstname);
        p1.setString(2, Lastname);
        ResultSet r1 = p1.executeQuery();
        if (r1.next()) {
            student  = new Student();
            student .setId(Integer.parseInt(r1.getString("id")));
            student .setFirstName(r1.getString("Firstname"));
            student .setLastName(r1.getString("Lastname"));
        }
        return student;
    }

    public void NewUser(String Firstname ,String Lastname,String Country,String Language,String OS ) throws SQLException {
        PreparedStatement p2 = connection.prepareStatement(INSERT_QUERY);
        p2.setString(1, Firstname);
        p2.setString(2, Lastname);
        p2.setString(3, Country);
        p2.setString(4,Language);
        p2.setString(5,OS);
        p2.executeUpdate();
    }
    public ArrayList<Student> allStudent() throws SQLException {
        ArrayList<Student> Students = new ArrayList<>();
        Student student=null;
            PreparedStatement p3=connection.prepareStatement(SELECT_ALL_USER);
            ResultSet r3 = p3.executeQuery();
            while (r3.next()) {
                student = new Student();
                student.setId(Integer.parseInt(r3.getString("id")));
                student.setFirstName(r3.getString("FirstName"));
                student.setLastName(r3.getString("LastName"));
                student.setCountry(r3.getString("Country"));
                student.setLanguage(r3.getString("Language"));
                student.setOS(r3.getString("OS"));
                Students.add(student);
            }
        return Students;
    }
}
