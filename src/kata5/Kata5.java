package kata5;

import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Kata5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.jdbc.driver.OracleDriver");
        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@servidorvirtual|127.0.0.1:1521:orcl","system","orcl");
        Statement st = com.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PEOPLE");
        while (rs.next()){
            System.out.print("ID = " +rs.getInt("Id"));
            System.out.println(" NAME = " + rs.getString("Name"));
        }     
        String Query = "Create table IF NOT EXISTS MAIL ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' TEXT NOT NULL)";
        st.execute(Query);
        String name = "C:\\Users\\Entrar\\Downloads\\emails.txt";
        ArrayList<String> mailArray = (ArrayList<String>) MailListReader.read(name);
        for (String mail : mailArray) {
            String query = "INSERT INTO MAIL (MAIL) VALUES ('" + mail + "');";
            System.out.println(query);
            st.executeUpdate(query);
            
        }
    }
}
