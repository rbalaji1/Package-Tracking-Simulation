package Fedextrack;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.sql.*;
import java.util.Random;
public class Package {
	
	private long trackno = 0;
	private long temp = 0; // for randomizing trackno
	private static String date;
	private int weight;
	private int pieces;
	private String source;
	private String destination;
	private int starttime;
	private String route;
	private static Route rr = new Route();
	
	
	
	public String getRoute() {
		return route;
	}


	public void setRoute(String route) {
		this.route = route;
	}



	private int s; // for randomizing soruce
	private int d; //and destination
	private static ArrayList<Long> track = new ArrayList<Long>(); // an array of tracking numbers
	Random num = new Random();
	public static final int N = 100000;
	
	
	
	private static String password = "12020210749343";
	private static String username = "root";
	private static String constring = "jdbc:mysql://localhost:3306/package";
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static String[] a = {
		"Seattle, WA",
	   	  "Sacramento, CA",
	   	  "Chino, CA",
	   	  "Los Angeles, CA",
	   	  "Phoenix, AZ",
	   	  "Salt Lake City, UT",
	   	  "Denver, CO",
	   	  "Dallas, TX",
	   	  "Houston, TX",
	   	  "Kansas, KS",
	   	  "Minneapolis, MN",
	   	  "St. Louis, MO",
	   	  "Memphis, TN",
	   	  "New Berlin, WI",
	   	  "Indianapolis, IN",
	   	  "Atlanta, GA",
	   	  "Grove City, OH",
	      "Charlotte, NC",
	  	  "Orlando, FL",
	  	  "Pittsburgh, PA",
	  	  "Martinsburg, WV",
	  	  "Allentown, PA",
	  	  "Edison, NJ",
		  "Northborough, MA"
	};

	private static Route r = new Route();
	
		
	public Package(int t){
		if(t<20){
			
			this.trackno = t;
			
		}
		else{
		this.temp = createnew();
		for( int i=0; i<track.size(); i++)
		{
			Long value = track.get(i);
			if(value==this.temp)
			{
				this.temp = createnew();
				i=0;
			}
				
			else
			{
				track.add(this.temp);
				i = track.size();
			}
		}
		this.trackno = this.temp;
		}
		this.weight = num.nextInt(6) + 1;
		this.pieces = num.nextInt(10) + 1;
		do{
			s = num.nextInt(23);
		
			d = num.nextInt(23);
	
			if(s!=d){
				this.source = a[s];
				this.destination = a[d];
		}
		}while( (this.source == null || this.destination == null));
		starttime = num.nextInt(20);
		route = rr.retroute(source, destination);
		
	}
	
	
	public void printall(){
	for( int i=0; i< track.size(); i++ )
	{
		System.out.println(track.get(i));
	}
	}
	
	public long createnew()
	{
		int n = num.nextInt(10000000) + 1;
		return n;
	}
	
	public long getTrackno() {
		return trackno;
	}
	
	public String getDate() {
		return date;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getPieces() {
		return pieces;
	}
	
	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}
		
	
	public int getStarttime() {
		return starttime;
	}


	public static String retsource(int trackno){
		String ss = null;
		
		
		try {
			con = DriverManager.getConnection(constring,username,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select source from packages where trackno =" + trackno);
			while (rs.next()) {
					ss = rs.getString("source");
	        }
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		return ss;
		
		
	}
	
	public static String retdestination(int trackno){
		String dd = null;
		try {
			con = DriverManager.getConnection(constring,username,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select destination from packages where trackno =" + trackno);
			while (rs.next()) {
					dd = rs.getString("destination");
	        }
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		return dd;
		
	}
	
	
	public static String retstatus(int trackno){
		String dd = null;
		try {
			con = DriverManager.getConnection(constring,username,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select status from packages where trackno =" + trackno);
			while (rs.next()) {
					dd = rs.getString("status");
	        }
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		return dd;
		
	}
	
	public static int retweight(int trackno){
		int dd = 0;
		try {
			con = DriverManager.getConnection(constring,username,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select weight from packages where trackno =" + trackno);
			while (rs.next()) {
					dd = rs.getInt("weight");
	        }
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		return dd;
		
	}
	
	
	public static int retpieces(int trackno){
		int dd = 0;
		try {
			con = DriverManager.getConnection(constring,username,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select pieces from packages where trackno =" + trackno);
			while (rs.next()) {
					dd = rs.getInt("pieces");
	        }
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		return dd;
		
	}
	
	
	public static int retrow(int trackno){
		int r = 0;
		try {
			con = DriverManager.getConnection(constring,username,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select row from packages where trackno =" + trackno);
			while (rs.next()) {
					r = rs.getInt("row");
	        }
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		return r;
		
	}
	
	
	public static Object retlog(int trackno){
		String dd = null;
		try {
			con = DriverManager.getConnection(constring,username,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select log from packages where trackno =" + trackno);
			while (rs.next()) {
					dd = rs.getString("status");
	        }
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		return dd;
		
	}
	

			
	public static void main(String[] args){
		//LinkedList<Vertex> path ;
		//Package d1 = new Package(1);
		 //r.Excute(d1.getSource(), d1.getDestination());
		for( int i=0; i<N; i++){
		try {
			
			Package d = new Package(i);
			
			
			con = DriverManager.getConnection(constring,username,password);
			st = con.createStatement();
			st.execute("INSERT INTO packages (trackno, source, destination, weight, pieces, starttime, row, status, route) VALUES (" + d.getTrackno() + ", '"+d.getSource()+"', '" + d.getDestination() +"', "+ d.getWeight() +"," + d.getPieces() +", " + d.getStarttime() +", "+i+", "+ "'at source'"+", "+ "'" + d.getRoute() + "'" +")");

		}
		
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 if(st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	
	}

}
