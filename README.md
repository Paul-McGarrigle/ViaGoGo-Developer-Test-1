# ViaGoGo-Developer-Test-1

# Running the application
This is the completed ViaGoGo Developer challenge.  This application was built in the Intellij IDE and can be run by cloning the repository and importing the project to a chosen IDE and running the Driver Class.  It can also be run from the command line by downloading the repository, extracting the zip file and navigating to the project src folder which can be found by adding 

\ViaGoGo-Developer-Test-1-master\ViaGoGo-Developer-Test-1-master\ViaGoGoDeveloperTest1\src 

to the path where the zip file has been extracted to.  From the src folder run the following command to compile all the Classes:

javac *.java

The Main Method is located in the Driver Class, therefore to run the application use the following command:

java Driver

The user will then be prompted to enter two coordinates seperated by a comma, in the format 1,1 etc.  If the user enters invalid data, error messages will be returned and the user will be prompted to re-enter their coordinates.  When the user enters valid data the application will return the 5 closest events, to the user specified coordinates, and the application will end.

# Assumptions
The assumptions I made are as follows
The World can contain up to 200 events
Each event can have between 0 to 5000 tickets
These tickets are in the price range of $1 to $500 per ticket

# How might you change your program if you needed to support multiple events at the same location?
The generateUniqueLocation() Method in the World Class, checks if a location is already in use by checking if the values already exist in a HashSet of locations, therefore, if the program needed to support multiple events in the same location the check functionality, of this Method and the HashSet could be removed and the program would then support multiple events at the same location.

# How would you change your program if you were working with a much larger world size?
The Driver Class contains the variables worldSizeMin & worldRangeMax which determine the size of the world the user can enter coordinates from, the worldMin & worldMax variables in the World Class determine the size of the world the random data will be generated from.  By changing the default values of these variables you can specify a world of any size.
