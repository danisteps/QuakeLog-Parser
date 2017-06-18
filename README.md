# README #

### What is this repository for? ###

* This project is a Quake log parser that reads a quake log file and outputs its information.
* The application contains a console to import and output log information and a web page that displays the players ranking.
* Version 1.0
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* To run the console you can either run the jar file or open the project using Eclipse or another IDE for Java.
* In order to run the web page (index.html) properly, you'll need a local server or simply configure the following steps:
>1. Open terminal (command line) and go to the index project folder
>2. Run the command: python -m SimpleHTTPServer
>3. Open the index through: http://localhost:8000

### How do I run the parser? ###

* Run the main class (Main.java) or open the jar file.
* The console will display the options available to execute. The options are:
>1. Importar log de jogo
>   When this option is selected, the user will have to enter the log file path.
>2. Listar todas as partidas
>   This option displays all imported matches along with its informations
>3. Listar ranking de jogadores
>   This option displays the players ranking when a log is imported
>4. Sair
>   This options closes the application

### Technologies used ###

* The console was developed using Java
* The web page was developed using HTML and JQuery