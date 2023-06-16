package ticket_booking_system;

import java.sql.*;
public class conn {
    public static  void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root","");
            if (con == null) {
                System.out.println("JDBC connection is not established");
                return;
             } else
                System.out.println("Congratulations," + 
                     " JDBC connection is established successfully.\n");
             con.close();
            Statement st = con.createStatement();
            ResultSet rst = st.executeQuery("select * from register");
            boolean flag = false;
            while(rst.next()){
            	flag = true;
                System.out.println(rst.getString(1));
            }
            rst.close();
            st.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
