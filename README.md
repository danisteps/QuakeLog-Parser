# README #

### What is this repository for? ###

* This project is a Quake log parser that reads a quake log file and outputs its information.
* The application contains a console to import and output log information and a web page that displays the players ranking.
* Version 1.0

### How do I get set up? ###

* To run the console you can either run the jar file or open the project using Eclipse or another IDE for Java.
* In order to run the web page (index.html) properly, you'll need a local server or simply configure the following steps:
>1. Open terminal (command line) and go to the index project folder
>2. Run the command: python -m SimpleHTTPServer
>3. Open the index through: http://localhost:8000

### How do I run the console parser? ###

* Run the main class (Main.java) or open the jar file.
* The console will display the options available to execute. The options are:
>1. Importar log de jogo: when this option is selected, the user will have to enter the log file path.
>2. Listar todas as partidas: this option displays all imported matches along with its informations
>3. Listar ranking de jogadores: this option displays the players ranking when a log is imported
>4. Sair: this options closes the application

### How do I run the web ranking page? ###

* In order to display the ranking information you have to first import a log file on the console
* The console will outputs a file (output.json) that contains the ranking information when a log is imported.
* After the log is imported, you can open the index.html

### How do I run the tests ###

* Unit tests were developed to test the application because its fast and since the application is not complex it was enough.
* To run the tests, open the project in a Java IDE (I used Eclipse)
> On Eclipse, just right-click on the project folder and select Run As > JUnit Test

### Technologies used ###

* The console was developed using Java
* Unit testing was used to develop the tests
* The web page was developed using HTML and JQuery

### Considerations ###

* It was assumed that if a player kills himself he loses 1 kill form his count;