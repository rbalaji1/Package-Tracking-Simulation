
/*create the table */
package Fedextrack;

import java.sql.*;


public class connect {
	 
	private static String password = "12020210749343";
	private static String username = "root";
	
	private static String constring = "jdbc:mysql://localhost:3306/package";
	private static Connection con;
	private static Statement st;
	
	
	
	public static void main(String[] args){
		
		try {
			
			con = DriverManager.getConnection(constring,username,password);
			st = con.createStatement();
			//st.execute("create database package");
			st.execute("use package");
			st.execute("create table packages (trackno INT(11), source VARCHAR(20), destination VARCHAR(20), weight INT(11), pieces INT(11), starttime INT(7), row INT(10) PRIMARY KEY, status VARCHAR(100), route VARCHAR(200), stat VARCHAR(1000), username VARCHAR(100))");
			//st.execute("UPDATE packages SET destination =" + a + " WHERE source = 'CA'" );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
