# Tic Tac Toe with different modes
This is a java maven project for the tic tac toe game which can be played in three modes
* Human vs Human
* Human vs Computer
* Computer vs Computer

### Assumptions

* This is a 3 X 3 tic tac toe board game with row numbers and column numbers 1-3 for user interface. 
* Default implementation for a computer's move is Random.
* Player 1 is always X and Player 2 is always O

### Getting Started

To get started, clone this repository

```bash
git clone git@github.com:ravinaik1312/tic-tac-toe-problem.git
```

Since, this is a maven project, you will need to install [Java](https://java.com/en/download/help/mac_install.xml), [Maven](https://maven.apache.org/install.html) on your machine. If you are on MAC OS and you use external third party package manager, you can install it from command line using 

```bash
brew install maven
```

### Running the Project

```bash
mvn package
java -cp target/problem-0.0.1-SNAPSHOT.jar tic_tac_toe.problem.App
```

'mvn package' will download and install the maven compiler plugin and compile the project. 
