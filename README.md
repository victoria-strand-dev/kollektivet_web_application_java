# kollektivet_web_application_java
Web application project for the subject Webutvikling (web development): "Kollektivet" remake from PHP to Java.

Start: 
1. Download Temurin 21 (LTS) -> https://adoptium.net/temurin/releases?version=21&os=any&arch=any
2. Download IntelliJ IDEA -> https://www.jetbrains.com/idea/download
3. Download XAMPP and MySQL Workbench if not already downloaded
4. Connect to the SQL-database from XAMPP through MySQL Workbench
5. Setting up the Spring Boot project manually https://start.spring.io/
6. Open the application.properties-file (C:\[...]\myBackend\src\main\resources\application.properties) to configure the connection between the Spring project an the MySQL database so Spring Boot automatically uses the correct settings to set up the environment.
7. Create the database (mybackend_db) in MySQLWorkbench
8. Create the first files and set up the project for testing (testing code created by OpenAI ChatGPT (2025)) that everything works -> create the first table in the database using java
9. Test more to get the hang of things, then start working on the real project


16.10.2025:
Tried to replicate the code that ChatGPT made for me, and adjust it for each of the new tables (classes) I wanted to have in my project. Ended up not working -> the code ran without errors, but the datebase didn't get updated.

17.10.2025:
Temporarily moved all the files that didn't corealate to the User-table/-class to make it easier to analyze the problem and fix it.
