package kata5;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//C:\Users\Entrar\Downloads\SQLiteDatabaseBrowserPortable\Data

public class Kata5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        //DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Entrar\\Downloads\\SQLiteDatabaseBrowserPortable\\Data\\Kata5.db");
        Connection com = DriverManager.getConnection("jdbc:sqlite:C:/Users/Entrar/Downloads/SQLiteDatabaseBrowserPortable/Data/Kata5.db");
        Statement st = com.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PEOPLE");
        while (rs.next()){
            System.out.print("ID = " +rs.getInt("Id"));
            System.out.println(" NAME = " + rs.getString("Name"));
        }
        
    }
    
}
