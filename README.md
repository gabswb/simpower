# sim-power
## Presentation

This project was carried out as part of the ap4b subject (object oriented design in Java and UML). 
This project is a management game, in which you build your city. This game simulates the electrical distribution of the play area. 
The goal of the player is to be able to supply the entire population located on the playing area while
minimising energy costs for residents and minimising pollution.

## Installing and running

This programm have been tested on jdk 16.0.1 for both methods

### Get source files
First you need to clone this repository :
```
git clone https://github.com/gabswb/ap4b-simpower.git
cd ap4b-simpower
```
Or you can just download the zip archive of this repo

### Compile and run with Maven
 - You need to have [Maven](https://maven.apache.org/download.cgi) installed on your computer
```
mvn compile
mvn clean package
```
This will create in target folder a .jar not executable !
To execute it run this :
```
java -cp target/Simpower-1.0.jar main.java.Main
```

### Compile and run with javac
```
cd src
mkdir classes
javac -d classes main/java/*.java
java -cp ./main/resources;./classes main.java.Main
```


