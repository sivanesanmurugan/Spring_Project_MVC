package com.codewithsiva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connection {

        private static final String connectionURL="jdbc:mysql://localhost:3306/spring";

        private static final String username ="root";
        private static final String password="root";

        public static Connection getconnection() throws ClassNotFoundException, SQLException {

            Connection connection;

            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(connectionURL,username,password);
            System.out.println("Connection" + !connection.isClosed());

            return connection;

        }

}
