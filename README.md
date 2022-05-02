# sim-power

## Presentation

This project was carried out as part of the ap4b subject object-oriented design in Java and UML).

This project is a management game, in which you build your city. This game simulates the electrical distribution of the play area.

The goal of the player is to be able to supply the entire population located in the playing area while

minimizing energy costs for residents and minimizing pollution.

## Installing and running

This program has been tested on JDK 16.0.1 for both methods

### Get source files

First, you need to clone this repository :

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

This will create in the target folder a .jar not executable !

To execute it run this :

```
java -cp target/Simpower-1.0.jar main.java.Main
```

### Compile with javac

```
cd src

mkdir classes

javac -d classes main/java/*.java
```

### Run the app on Windows

```
java -cp ./main/resources;./classes main.java.Main
```

### Run the app on Linux

```
java -cp ./main/resources:./classes main.java.Main
```

### Use docker container

Build the docker image

```
docker build -f Dockerfile -t simpower:1.0 .
```

Run the container

```
docker run -it simpower:1.0
```

**Warning**

If you run it just like this you will have a java.awt.HeadlessException Exception

You need to :

- Install [vcxsrv]{https://sourceforge.net/projects/vcxsrv/}
  
- Start the Xlaunch
  

```
docker run -it --rm -e DISPLAY=${ipaddress of hostmachine} image/bin/bash
```