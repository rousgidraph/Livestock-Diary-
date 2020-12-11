package code;

import java.sql.Connection;
import java.sql.DriverManager;

public class database_connection {
    public static Connection database_connection() {
        Connection con = null;
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        //Database cresentials
        String dbName = "livestock";
        String dbUsername = "root";
        String dbPassword = "";
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL+dbName,dbUsername,dbPassword);
        } catch (Exception e) {
            System.out.println("Something went wrong\n"+e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

}
