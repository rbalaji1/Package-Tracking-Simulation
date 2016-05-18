# Package-Tracking-Simulation
Creates a fedex type system with millions of packages and provide tracking details

———————————————————————————————————
Fedex Tracking simulator
———————————————————————————————————

Content
——————————————
1. Class functionality
2. Instructions

Class functionality
——————————————————
Connect.java:

This class establishes connection with mysql server and creates a database called ‘package’ and creates a tables with all the attributes of a package.

Package.java

This class populates the database with package details like track, source, destination, and other details for the packages.

Edge.java 

This class creates edges, with its source, destination and distance between both of them

Vertex.java

This class creates vertices or nodes.

Graph.java

This class maps the nodes and edges to a list.

DijkstraAlgorithm.java

This class generates the graph of all the nodes and edges according the distance between nodes.

Route

This class contains methods that return the path from a source to a particular distance, 
each method has its own arguments, like track, source & destination etc.

thread1.java

this class is the main class that does the updating and real time simulation.
I also does the query for the search from database with the track number.






Instructions
—————————————————

1. extract the zip file and save the project1.jar.
2. open eclipse and create a new java project.
3. right click on src folder in the project and select import
4. in the general tab select archive file.
5. select browse and find the project1.jar file and click finish.
6. the src folder should now have two packages, connect and fedextrack.
7. in the connect packages there is a connector jar file.
8. right click on this file select build path -> add to build path.
9. install sql:
 
	1.	download and install mysql server from
		https://dev.mysql.com/downloads/mysql/
		
		and install the server.
		once install start the server from mysql preference panel in system
		preferneces.
	
	2.	also download the mysql workbench from
		https://dev.mysql.com/downloads/workbench/

	3.	open terminal and type
		mysql -u root -p
		enter the password of your system

	4.	the mysql prompt will start and copy paste the following without quotes.
		“SHOW VARIABLES WHERE Variable_name = 'port’;”

	5. 	open mysql workbench, click the add sign (+) on mysql connection

	6.	give a connection name and change the port to the value seen through
		terminal and click ok.

	7.	the sql editor will open up


10. Open eclipse and give the password of your system and the port in ‘constring’ in these class files,
	connect, Package, thread1, threads


11. select the class Package and change the value of N for the desired number of entries in the package database and run it.

12. select thread1 class and run it for the simulation.
