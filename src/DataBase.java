import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Connection;

public class DataBase
{
	public static void main(String[] args) throws SQLException 
	{
		Connection con = null;
		Statement pstmt;
		
		/*PreparedStatement pstmt1;*/
		
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.100.26:3306/group027_campus", "group027" , "welcome");
			
		pstmt = con.createStatement();
			
			
			Scanner s = new Scanner(System.in);
			

			System.out.println("Enter PRN ");
			int i = s.nextInt();
			
			String q = "Select * from Stuudent where prn = ?;";			
			rs = pstmt.executeQuery(q);
			
		
			if(rs.next())
			{
				do {
				System.out.println(rs.getInt(1)+ " " +rs.getInt(2)+ " " +rs.getString(3)+" " +rs.getDouble(4)+ " "+rs.getDouble(5)+ " " +rs.getDouble(6));
			}
				while(rs.next());
		}
			else
			{
				System.out.println("Not found");
			}
			con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
}
