import java.sql.*;
import java.io.*;
public class Blob_operation {
    public static void main(String[] args)throws Exception 
    {
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rintu","12453");
        PreparedStatement pst=con.prepareStatement("insert into longdatainfo values(?,?)");
        File f=new File("nature.jpg");
        FileInputStream fis=new FileInputStream(f);
        pst.setString(1,"rintu");
        pst.setBlob(2,fis);
        pst.executeUpdate();
        System.out.println("data inserted");
        con.close();

        
    }
}
