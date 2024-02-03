import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

// Jdbc for storing the username and password in the database
public class LoginInfo {
    ResultSet rs;
    Statement stmt;
    Connection con = null;
    PreparedStatement p;
    public HashMap<String,String> loginInfoHashMap = new HashMap<String,String>();

    public LoginInfo(){
        
        try{
            String url = "jdbc:mysql://localhost:3306/?user=root/logininfo";
            String user = "root";
            String password = "root";
        
            con = DriverManager.getConnection(url, user, password);
        
            stmt = con.createStatement();

            // create database login
            try{
                stmt.execute("Use login");
            }catch(Exception e){
                stmt.execute("Create database login");
                stmt.execute("Use login");
            }

            // create table logininfo
            try{
                stmt.executeQuery("Select * from logininfo");
            }catch(Exception e){
                stmt.execute("Create table logininfo(username varchar(20), password varchar(20))");
            }

            rs = stmt.executeQuery("Select * from logininfo");
           
            if(!rs.next()){
            
                stmt.execute("Insert into logininfo values('admin', 'admin')");
                stmt.execute("Insert into logininfo values('student1', 'student1')");
                stmt.execute("Insert into logininfo values('student2', 'student2')");
                stmt.execute("Insert into logininfo values('student3', 'student3')");
                stmt.execute("Insert into logininfo values('student4', 'student4')");
                stmt.execute("Insert into logininfo values('student5', 'student5')");
            }
            
            rs.close();

        }catch(Exception e){
            System.out.println(e);
        }
       
    }
    boolean getLoginData(String username, String password) throws Exception{
        rs = stmt.executeQuery("Select * from logininfo where username = '"+username+"' and password = '"+password+"'");
    
        if(rs.next())
            return true;
        return false;
        
        
    }

    void setPassword(String username, String password) throws Exception{
        
        p = con.prepareStatement("Update logininfo set password = '"+password+"' where username = '"+username+"'");
        p.executeUpdate();

        System.out.println("password changed");
    }
    public static void main(String[] args) throws Exception{
        LoginInfo rk = new LoginInfo();
        rk.setPassword("admin", "hello");

    }
    
}
