Loch Ness Monty Hall

The application is a RESTful Web Service which runs one or more simulations on a Monty Hall problem.
The result of the simulation is returned in JSON format.
The result shows the number of wins when choosing to stay with an initial choice AND the number of wins when switching to another choice after a non-win choice is removed.

The result is returned as JSON in the format:
{"staySuccessCount":X,"switchSuccessCount":Y,"roundsCount":X+Y}

How to run the application:


Alternative 1 (if you do want to compile it yourself):

1) Download the code from GitHub. (https://github.com/developerPete/LochNessMontyHall)

2) Build the JAR file by typing: mvn clean package

3) Run the JAR file by typing: java -jar target/lochness-montyhall-0.1.0.jar

4) Point browser to the url http://localhost:8080/simulate?numberOfRounds=[Number of rounds to run the simulation]



Alternative 2 (if you do not want to compile it yourself):

1) Download the jar-file from GitHub. (https://github.com/developerPete/LochNessMontyHall)

2) Run the JAR by typing: java -jar target/lochness-montyhall-0.1.0.jar

3) Point browser to the url http://localhost:8080/simulate?numberOfRounds=[Number of rounds to run the simulation]


Examples:
http://localhost:8080/simulate?numberOfRounds=1000

http://localhost:8080/simulate(If numberOfRounds is omitted, one round will be simulated.)
