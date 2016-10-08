# Build the application

It is recommended to build the application with maven tool by executing `mvn package` command.

# Run the application

You can run the JAR file: `java -jar target/rashambo-1.0-SNAPSHOT.jar`

The table below specifies all application properties that are available.

| Property                   | Default | Description  |
|:-------------------------- | -------:|:------------ |
| rashambo.number-of-players | 2       | Not yet supported. The number of players that play rashambo game. |
| rashambo.number-of-rounds  | 100     | The number of rounds that the players are going to play the game. |

To override the default values of properties, you can pass them as a JVM options, e.g. 
```
java -Drashambo.number-of-rounds=10000 -jar target/rashambo-1.0-SNAPSHOT.jar
``` 
will run the application with 10000 rounds.