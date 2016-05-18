package Fedextrack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Route {
	
	 private List<Vertex> nodes;
	  private List<Edge> edges;
	 
	  private Vertex source;
	  private Vertex destination;
	  private Vertex altsource;
	  private Vertex altdestination;
	 
	  
	  public static String[] a = {
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

	  /* a create vertex method that creates x vertices
	   */
	  public void createvertex(int x){
		  nodes = new ArrayList<Vertex>();
		  for(int i = 0; i<x; i++){
			  Vertex City = new Vertex("City"+i,a[i]);
			  nodes.add(City);
		  }
		  
	  }
	  
	  /* A create vertex funciton that returns the arraylist
	   * 
	   */
	  public List<Vertex> createvertex(){
		   nodes = new ArrayList<Vertex>();
		  for(int i = 0; i<24; i++){
			  Vertex City = new Vertex("City"+i,a[i]);
			  nodes.add(City);
		  }
		  return nodes;
		  
	  }
	  
	  /*generating all the edges in the system
	   * 
	   */
	  public void createedge(){
		  
		  addLane("path1", 0, 1, 626);
		    addLane("path2", 0, 5, 702);
		    addLane("path3", 1, 3, 358);
		    addLane("path4", 1, 5, 534);
		    addLane("path5", 3, 2, 35);
		    addLane("path6", 3, 5, 577);
		    addLane("path7", 2, 5, 570);
		    addLane("path8", 2, 4, 324);
		    addLane("path9", 4, 5, 510);
		    addLane("path10", 4, 6, 585);
		    addLane("path11", 4, 7, 870);
		    addLane("path12", 5, 6, 374);
		    addLane("path13", 6, 7, 667);
		    addLane("path14", 6, 9, 585);
		    addLane("path15", 6, 10,706);
		    addLane("path16", 7, 8, 226);
		    addLane("path17", 7, 9, 461);
		    addLane("path18", 7, 12, 423);
		    addLane("path19", 7, 11, 545);
		    addLane("path20", 8, 12, 483);
		    addLane("path21", 8, 15, 704);
		    addLane("path22", 9, 11, 240);
		    addLane("path23", 9, 12, 372);
		    addLane("path24", 9, 10, 420);
		    addLane("path25", 9, 13, 444);
		    addLane("path26", 10, 11, 466);
		    addLane("path27", 10, 13, 290);
		    addLane("path28", 10, 14, 509);
		    addLane("path29", 11, 12, 244);
		    addLane("path30", 11, 13, 326);
		    addLane("path31", 11, 14, 235);
		    addLane("path32", 11, 15, 470);
		    addLane("path33", 12, 14, 388);
		    addLane("path34", 12, 15, 335);
		    addLane("path35", 12, 18,689);
		    addLane("path36", 13, 14, 226);
		    addLane("path37", 13, 9, 461);
		    addLane("path38", 13, 12, 423);
		    addLane("path39", 14, 15, 417);
		    addLane("path40", 14, 16, 158);
		    addLane("path41", 14, 17, 427);
		    addLane("path42", 14, 19, 329);
		    addLane("path43", 15, 18, 408);
		    addLane("path44", 15, 16, 435);
		    addLane("path45", 15, 17, 228);
		    addLane("path46", 16, 19, 172);
		    addLane("path47", 16, 20, 275);
		    addLane("path48", 16, 17, 348);
		    addLane("path49", 17, 19, 363);
		    addLane("path50", 17, 20, 333);
		    addLane("path51", 17, 18, 465);
		    addLane("path52", 19, 20, 126);
		    addLane("path53", 19, 21, 238);
		    addLane("path54", 20, 21, 153);
		    addLane("path55", 20, 22, 200);
		    addLane("path56", 21, 22, 54);
		    addLane("path57", 21, 23, 233);
		    addLane("path58", 22, 23, 192);
		   
		    
	  }
	  
	  
 public ArrayList<Edge> createedge(int x){
	  ArrayList<Edge> side = new ArrayList<Edge>();
		  
	  addLane1("path1", 0, 1, 626);
	    addLane1("path2", 0, 5, 702);
	    addLane1("path3", 1, 3, 358);
	    addLane1("path4", 1, 5, 534);
	    addLane1("path5", 3, 2, 35);
	    addLane1("path6", 3, 5, 577);
	    addLane1("path7", 2, 5, 570);
	    addLane1("path8", 2, 4, 324);
	    addLane1("path9", 4, 5, 510);
	    addLane1("path10", 4, 6, 585);
	    addLane1("path11", 4, 7, 870);
	    addLane1("path12", 5, 6, 374);
	    addLane1("path13", 6, 7, 667);
	    addLane1("path14", 6, 9, 585);
	    addLane1("path15", 6, 10,706);
	    addLane1("path16", 7, 8, 226);
	    addLane1("path17", 7, 9, 461);
	    addLane1("path18", 7, 12, 423);
	    addLane1("path19", 7, 11, 545);
	    addLane1("path20", 8, 12, 483);
	    addLane1("path21", 8, 15, 704);
	    addLane1("path22", 9, 11, 240);
	    addLane1("path23", 9, 12, 372);
	    addLane1("path24", 9, 10, 420);
	    addLane1("path25", 9, 13, 444);
	    addLane1("path26", 10, 11, 466);
	    addLane1("path27", 10, 13, 290);
	    addLane1("path28", 10, 14, 509);
	    addLane1("path29", 11, 12, 244);
	    addLane1("path30", 11, 13, 326);
	    addLane1("path31", 11, 14, 235);
	    addLane1("path32", 11, 15, 470);
	    addLane1("path33", 12, 14, 388);
	    addLane1("path34", 12, 15, 335);
	    addLane1("path35", 12, 18,689);
	    addLane1("path36", 13, 14, 226);
	    addLane1("path37", 13, 9, 461);
	    addLane1("path38", 13, 12, 423);
	    addLane1("path39", 14, 15, 417);
	    addLane1("path40", 14, 16, 158);
	    addLane1("path41", 14, 17, 427);
	    addLane1("path42", 14, 19, 329);
	    addLane1("path43", 15, 18, 408);
	    addLane1("path44", 15, 16, 435);
	    addLane1("path45", 15, 17, 228);
	    addLane1("path46", 16, 19, 172);
	    addLane1("path47", 16, 20, 275);
	    addLane1("path48", 16, 17, 348);
	    addLane1("path49", 17, 19, 363);
	    addLane1("path50", 17, 20, 333);
	    addLane1("path51", 17, 18, 465);
	    addLane1("path52", 19, 20, 126);
	    addLane1("path53", 19, 21, 238);
	    addLane1("path54", 20, 21, 153);
	    addLane1("path55", 20, 22, 200);
	    addLane1("path56", 21, 22, 54);
	    addLane1("path57", 21, 23, 233);
	    addLane1("path58", 22, 23, 192);


		  return side;
		    
	  }
	  
	  private void addLane(String laneId, int sourceLocNo, int destLocNo,
		      int distance) {
		    Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), distance);
		    edges.add(lane);
		  }
	  
	  private Edge addLane1(String laneId, int sourceLocNo, int destLocNo,
		      int distance) {
		  	
		    Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), distance);
		    
		    return lane;
		  }
	  
	  public LinkedList<Vertex> findpath(){
		  
		  	
		    Graph graph = new Graph(nodes, edges);
		    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		    dijkstra.execute(source);
		    LinkedList<Vertex> path = dijkstra.getPath(destination);
		    
		    /* path will be null if there is no path between source n destination
		     * thus execution the algorithm again with interchanged source and destination 
		     * and calling getotherpath that removes the reverse function
		     */
		    
		    if( path == null){
		    	
		    	altsource = destination;
		    	altdestination = source; 
		    	dijkstra.execute(altsource);
			    path = dijkstra.getotherPath(altdestination);
		    	
		    }
		  
		    return path;
	  }
	  
	  public LinkedList<Vertex> findpath(Graph graph, Vertex source, Vertex destination){
		  
		    
		    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		    dijkstra.execute(source);
		    LinkedList<Vertex> path = dijkstra.getPath(destination);
		    
		    /* path will be null if there is no path between source n destination
		     * thus execution the algorithm again with interchanged source and destination 
		     * and calling getotherpath that removes the reverse function
		     */
		    
		    if( path == null){
		    	
		    	altsource = destination;
		    	altdestination = source; 
		    	dijkstra.execute(altsource);
			    path = dijkstra.getotherPath(altdestination);
		    	
		    }
		    
		    return path;
	  }
	  
	  
	  public void testExcute() {
	    nodes = new ArrayList<Vertex>();
	    edges = new ArrayList<Edge>();
	   
	    LinkedList<Vertex> path;
	    
	    createvertex(24); //generate all the vertices
	    createedge();	//generate all the edges    	    
	    
	    // The scanner function
	    // Provide source and destination
	    
	    
	    	Scanner id = new Scanner(System.in);
	    	System.out.println("ENTER PACKAGE TRACKING NUMBER");
	    	int num = id.nextInt();
	    	String citys = Package.retsource(num);
	    	String cityd = Package.retdestination(num);

	    
	   for( int i=0; i<nodes.size(); i++){
	    	if(nodes.get(i) != null){
	    	if(nodes.get(i).getName().equals(citys))
	    		source = nodes.get(i);
	    	if(nodes.get(i).getName().equals(cityd)) 
	    		destination = nodes.get(i);
	    	}
	    }
	   
	    System.out.println("Package source:- " + source);
	    System.out.println("Package destination:- " + destination);
	    	

	    path = findpath();
	    String route = null;
	    		
	    		for(Vertex v : path){
			    	if(v == source)
			    		route = ""+v;
			    	else
			    	route +=" -> "+ v;
	    		}
	    System.out.println("----------------");

	    System.out.println("The package route is ");
	    System.out.println(route);
	    
	    System.out.println("Current position of the package");
	    System.out.println(Package.retstatus(num));
	    System.out.println("--------------------------");
	    

	  }
	  
	  
	  public void testExcute(int num) {
		    nodes = new ArrayList<Vertex>();
		    edges = new ArrayList<Edge>();
		   
		    LinkedList<Vertex> path;
		   
		    int n;
		    String[] stat = new String[30];
		    
		    
		    createvertex(24); //generate all the vertices
		    createedge();	//generate all the edges    	    
		    
		    // The scanner function
		    // Provide source and destination
		    
		    
		    	
		    	String citys = Package.retsource(num);
		    	String cityd = Package.retdestination(num);
		    	n = Package.retrow(num);
		    	stat = thread1.log.get(n).getstat();
		    	String s = new String();

		    
		   for( int i=0; i<nodes.size(); i++){
		    	if(nodes.get(i) != null){
		    	if(nodes.get(i).getName().equals(citys))
		    		source = nodes.get(i);
		    	if(nodes.get(i).getName().equals(cityd)) 
		    		destination = nodes.get(i);
		    	}
		    }
		   
		   	System.out.println("-----------------------------");
		   	System.out.println("Package details");
		   	System.out.println("-----------------------------");
		   
		    System.out.println("Package source:- " + source);
		    System.out.println("Package destination:- " + destination);
		    System.out.println("no. of pieces in the package :- "+ Package.retpieces(num));
		    System.out.println("weight of the package :- "+ Package.retweight(num));

		    String route = null;
		    path = findpath();
		    if(path == null){
		    	System.out.println("The system is having trouble finding the path.");
		    	route = "TThe system is having trouble finding the path.";
		    }
		    else{
		    		
		    		for(Vertex v : path){
				    	if(v == source)
				    		route = ""+v;
				    	else
				    	route +=" -> "+ v;
		    		}
		    }
		    System.out.println("----------------");

		    System.out.println("The package route is ");
		    System.out.println(route);
		    s= Package.retstatus(num);
		    
		    System.out.println("Activity log");
		    System.out.println("-----------------------------");
		    String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		    for(int i=0; i<stat.length;i++){
		    	
		    	System.out.println(i+" "+ timeStamp+"  :-  "+stat[i]);
		    	if(s.equals(stat[i]))
		    		i=stat.length;
		    	
		    }
		    
		    System.out.println("Current position of the package");
		    System.out.println(Package.retstatus(num));
		    System.out.println("-------------------------------");
		    

		  }
	  
	  
	
	  
	  public LinkedList<Vertex> Excute(String citys, String cityd) {
		    nodes = new ArrayList<Vertex>();
		    edges = new ArrayList<Edge>();
		   
		    String allpath = null;
		    
		    LinkedList<Vertex> path;
		    

		    createvertex(24); //generate all the vertices
		    createedge();	//generate all the edges    	    
		    
		    // The scanner function
		    // Provide source and destination
		    
		    
		   for( int i=0; i<nodes.size(); i++){
		    	if(nodes.get(i) != null){
		    	if(nodes.get(i).getName().equals(citys))
		    		source = nodes.get(i);
		    	if(nodes.get(i).getName().equals(cityd)) 
		    		destination = nodes.get(i);
		    	}
		    }
		   
		    path = findpath();
		    if(path == null){
		    	System.out.println("The system is having trouble finding the path.");
		    	
		    }
	
		    for(Vertex v : path){
		    	if(v == source)
		    		allpath = ""+v;
		    	else
		    	allpath +=" ->"+ v;
		    	
		    	
		    }
		   
		     
		   
		    //System.out.println(allpath);
		 
		    return path;
		    

		  }
	  
	  
	  public String retroute(String citys, String cityd) {
		    nodes = new ArrayList<Vertex>();
		    edges = new ArrayList<Edge>();
		   
		    String allpath = null;
		    
		    LinkedList<Vertex> path;
		    

		    createvertex(24); //generate all the vertices
		    createedge();	//generate all the edges    	    
		    
		    // The scanner function
		    // Provide source and destination
		    
		    
		   for( int i=0; i<nodes.size(); i++){
		    	if(nodes.get(i) != null){
		    	if(nodes.get(i).getName().equals(citys))
		    		source = nodes.get(i);
		    	if(nodes.get(i).getName().equals(cityd)) 
		    		destination = nodes.get(i);
		    	}
		    }
		   
		   
		   String route = null;
		    path = findpath();
	
		    if(path == null){
		    	System.out.println("The system is having trouble finding the path.");
		    	route = "The system is having trouble finding the path.";
		    	
		    }
		    else{
    		
		    		for(Vertex v : path){
		    			if(v == source)
		    				route = ""+v;
		    			else
		    				route +=", "+ v;
		    		}
		    	}
		    	
    		return route;
		    	
		    }
		   
		     
		   
		    //System.out.println(allpath);
		 
		    

	  
	  
	  
	  //public LinkedList<Vertex> testExcute(String citys, String cityd) {
	  public void testExcute(String citys, String cityd) {  

	    LinkedList<Vertex> path;
	    
	   for( int i=0; i<nodes.size(); i++){
	    	if(nodes.get(i) != null){
	    	if(nodes.get(i).getName().equals(citys))
	    		source = nodes.get(i);
	    	if(nodes.get(i).getName().equals(cityd)) 
	    		destination = nodes.get(i);
	    	}
	    }
	   
	    path = findpath();
	
	    System.out.println("----------------");

	    System.out.println("The package route to " + destination + " from " + source + " is " );
	    for (Vertex vertex : path) {
	      System.out.println(vertex);
	    }
	    
	    System.out.println("Current position of the package");
	    

	  }


	  
	  public LinkedList<Vertex> testExcute(Graph graph, String citys, String cityd) {  
		
		    LinkedList<Vertex> path;
		    
		   for( int i=0; i<nodes.size(); i++){
		    	if(nodes.get(i) != null){
		    	if(nodes.get(i).getName().equals(citys))
		    		source = nodes.get(i);
		    	if(nodes.get(i).getName().equals(cityd)) 
		    		destination = nodes.get(i);
		    	}
		    }
		    
		    path = findpath(graph, source, destination);

		    return path;
		    

		  }


	

}

