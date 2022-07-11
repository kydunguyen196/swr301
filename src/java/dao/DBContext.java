package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    private final String serverName = "localhost";
    private final String dbName = "Mido_PRJ301_SE1624";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "sa";
    private static Connection con = null;
    
     public Connection getConnection()throws Exception {        
        if(con != null)
            return con;
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +
                ";databaseName="+dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, userID, password);
        return con;
    }
    
}
