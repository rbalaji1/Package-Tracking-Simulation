package Fedextrack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class thread1 implements Runnable {
	
	private static String password = "12020210749343";
	private static String username = "root";
	private static String constring = "jdbc:mysql://localhost:3306/package";
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static ArrayList<String> ss = new ArrayList<String>();
	private static ArrayList<String> dd = new ArrayList<String>();
	
	private static String source;
	private static String destination;
	public static ArrayList<Log> log = new ArrayList<Log>();;
	
	  private static Route r = new Route();
	 private static List<Vertex> nodes; 
	  private static List<Edge> edges;
	  
	  static String[] status;
	  
	  public static final int N = 50;
	  
	  
	  
	  public static Log statlog;
	  static String[] statnew = new String[1000] ;
	  static int[] d = new int[N];
	 
	  public static Log l;
	  private static Package p;
	  
	  static String[][] stat = new String[N][30];
	  

	  static  Semaphore sem = new Semaphore(1);

	Thread t;
	public thread1(String tname){
		
	
		t = new Thread(this, tname);
		try {
			Thread.sleep(10+t.getId());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.start();
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<N; i++){
			try {
				con = DriverManager.getConnection(constring,username,password); 
				st = con.createStatement();
				rs = st.executeQuery(" select source, destination from packages where row ="+i);
				while (rs.next()) {
					
						ss.add(rs.getString("source"));
						dd.add(rs.getString("destination"));
					
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
		}

		
		   int starttime=0;
			 
					for(int i=0;i<N;i++){
				for(int j=0;j<30;j++){
					stat[i][j] = "delivered";
				}
			} 
		  for(int index=0;index<N-1; index++){
		  
			  	  
			  
			LinkedList<Vertex> path;
			
			source = ss.get(index);
			destination = dd.get(index);
			
			try{
				path = r.Excute(source, destination);

			
			Vertex[] p = new Vertex[path.size()];
			
			p = path.toArray(p);
			
			int size=(path.size()*2)-1;
			
			status = new String[size];
			for(int i=0;i<size;i++){
				if(i==0)
					status[i] = "at source";
				else if(i%2==0)
					status[i]="The package is at "+p[i/2];
				else 
					status[i] = "In transit from "+p[i/2];
				
				
			}
		
			l = new Log(index,status);
			log.add(l);
		
			
			for(int i=0;i<size;i++){
				
				stat[index][i]=status[i];
				
			}
	
			}
			catch(NullPointerException e ){
			      //System.out.println("THIS");
					status = new String[3];
					status = null;
					l = new Log(index,status);
					log.add(l);
				
				}
			
	  }
		  for(int i=0;i<1000; i++)
			  statnew[i] = "---";
		 // statnew[0]= "at source";
		  for(int j=0; j<N; j++)
			  d[j] = 0;
		  
		  
		  for(int i=0;i<30;i++){
			  for(int j=0;j<N;j++){
		  
		  try {
				con = DriverManager.getConnection(constring,username,password); 
				st = con.createStatement();
				//if(i==0)
				
				
				if(!(stat[j][i].equals("delivered"))) {
					statnew[j] = statnew[j]+"\n"+stat[j][i]+"\n";
				}

				/*if(d[j]==0){
					if(!(stat[j][i].equals("delivered"))){
						
						statnew[j] = statnew[j]+"\n"+stat[j][i]+"\n";
					}
					else{
						statnew[j] = statnew[j]+"\n"+"delivered"+"\n";
						d[j]=1;
					}
				}*/
				
				
					
				st.execute("update packages set status='"+stat[j][i]+"' where row="+j);
				st.execute("update packages set stat='"+statnew[j]+"' where row="+j);
				
				
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
			  try {
				  Thread.sleep(TimeUnit.SECONDS.toMillis(10));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
		  }
	
	}
		
		
	
	public static void main(String[] args){
		
		
	
		
		try {
			con = DriverManager.getConnection(constring,username,password);
			st = con.createStatement();
			st.execute("update packages set status='at source'");
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		nodes = new ArrayList<Vertex>();
	    edges = new ArrayList<Edge>();
	   
	    nodes = r.createvertex(); //generate all the vertices
	    edges = r.createedge(1);	//generate all the edges 
	   
		

			thread1 tt = new thread1("thread");	

			 int num=0;
			 int num1=2;
			 
			 	Scanner id = new Scanner(System.in);
			 	do{
			 		do{
			 			System.out.println("-------------------------------------------------");
		    	System.out.println("ENTER PACKAGE TRACKING NUMBER");
		    	System.out.println("-------------------------------------------------");
		    	num = id.nextInt();
			 	}while(num==0);
			 		
			 try {
				sem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 r.testExcute(num);
			 sem.release();
			 System.out.println("Search again ?'1/0'");
		    	num1 = id.nextInt();
		    	if(num1==1)
		    		num =0;
		    	if(num1 == 0)
		    		System.exit(0);
			 	}while(num1!=0);  
			 	
			  try {
				tt.t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 	System.out.println("all done");
			 try {
				con = DriverManager.getConnection(constring,username,password);
				st = con.createStatement();
				st.execute("update packages set status='at destination'");
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	
	}

}
