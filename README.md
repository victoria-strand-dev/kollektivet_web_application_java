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

- Alternative to the paid version Ultimate IntelliJ is https://start.spring.io/ . This generates a zip-file that one can open through IntelliJ with all the right setup. Remember to adjust "application.properties" so it connects successfully to the MySQL Workbench and the correct database. I don't know yet if you do this you don't have to do it again for the same procject or if it's a time- or spacelimit.
- The database must be created manually in MySQL Workbench so that Spring Boot gets something to connect to.
- To create connections between tables -> it's important to know/decide if the connection is OneToMany, ManyToOne etc..
- To specify "null"/"not null" etc. from scripts themselves, one has to manually drop the tables from MySQL Workbench first since the hibernate doesn't override the colums/tables if they already exists.

--- Question to myself: Session() in php, how do I do that in this project? ---

03.11.2025
!IMPORTANT: What is what in my project/test project now? 
--------------------------------------------------------
1. myNewBackend -> myBackend is saved on gitHub, but something went wrong, so I made a new project and database. I haven't connected it to gitHub yet.
2. C:\Users\Queen Victoria xoxo\OneDrive\USN_23_til_27\h25_usn\webutvikling\myNewBackend\src\main\java\com\example\myNewBackend:
   - Java files for CoLiving, User, Calendar, Room
   - Java repositories for CoLiving, User, Calendar, Room
   - Java controllers for CoLiving, User, Calendar, Room
   - MyNewBackendApplication.java -> Main script that runs everything
   - TestWebApp.java -> Contains both html and css (I want to link to ..
   - HTML og CSS for login, create_coLiving, calendar, join_coLiving, profile, residents
   - common.css -> CSS-file that all the html-files use 
   - index.html, test.html, new_user.html
...


  
16.10.2025:
Tried to replicate the code that ChatGPT made for me, and adjust it for each of the new tables (classes) I wanted to have in my project. Ended up not working -> the code ran without errors, but the datebase didn't get updated.

17.10.2025:
Temporarily moved all the files that didn't corealate to the User-table/-class to make it easier to analyze the problem and fix it.
Created a new project to start over. Now without using a git repository, to make things as simple as possible for the learning process.
Created one table (User) to first check the connetion, then another (CoLiving) to check if both would work, then put in the realations between the two classes/tables to check if that worked, and then started adding spesifications to the different columns ("not null" etc.).

29.10.2025:
Made the room table in the database, and made relations to the coLiving table and user table. First I forgot to set the coLiving relation to Not Nullable, so I updated the code. The database did not get updatet. So I manually dropped the room table from the database and ran the code again. Then it worked. 
Made a simple script to test connection to web/localhost. The other classes that creates the database tables each have their own corelated repository-script. The script that is in charge of the frontend part/the webhosting(?) itself do not use this. 
Question for myself: Tomcat for creating/connecting to SQL, but Tomcat turned off for localhost?

03.11.2025:
The current goal is to connect the frontend to the backend. For testing/learning I am following a guide from the Engineer's CodingHub website (https://engineerscodinghub.com/full-stack-web-application-using-spring-boot/), but adjusted to my project instead of the example project on the site (chose users instead of employees, etz.).
Trying to make a table (localhoast:8081/users) that fetches data from the database, but there's something wrong somewhere. Still working on debugging.

04.11.2025:
The goal for today is to find the problem from yesterday, then start on the frontend part of the project. TestWebApp.java that runs on http://localhost:8081/ is working. It's a simple, static web page That just shows a text with basic CSS for coloring and font size, and a link just for testing. The problem lays in one or more of the following files: NewUserController.java, users.html, pom.xml. The error-message in pom.xml is: "Dependency 'org.springframework.boot:spring-boot-starter-thymeleaf:3.3.4' not found". In users.html the error-messages are: "URI is not registered (Settings | Languages & Frameworks | Schemas and DTDs)" and "Attribute th:text is not allowed here".
Have adjusted, edited, deleted, moved etz. and corrected som minor detail with names in the different codes. Changed from ex. userRepository to UserRepository, and made three folders inside the backend-folder (MyNewBackend) -> models, controllers and repositories. Made a frontend folder in the same folder that the backend folder is in (Webutvikling). Heres the biggest/most important problem i fixed: 
package com.example.myNewBackend.controllers; (added "controllers" since the file is now in another folder).
import com.example.myNewBackend.repositories.UserRepository; (imported the UserRepository-class).
import com.example.myNewBackend.models.User; (imported the User-class).
I have finally fixed the problems (with the help of ChatGPT)! ChatGPT has given me a few very simple codes just to make everything work. Now I am going to use this base(?) to further build my project and connect it to all the already existing files I made in the php-version of the project.
Something I've learned today: Models -> Repositories -> Controllers -> html/css/etc. :: One only need to make controllers and repositories for the models to fetch data from the database tables.
I've added a couple of css files and files that I "converted" from php to regular html that uses JS to connect to the backend part. I delted all php-code, therefor i must edit the files to "get back" the same functionalities, but all html and css work. Before I start adjusting the code that connects to the database, I want to test if I can use more than one css file per html-file. I hope that if that's possible, I can have ONE css-file that all thml-files can use, and add shorter, more spesific css-files for each html-file (if needed). It worked!

05.11.2025:
I (ChatGPT) figured out why the data for users were shown in the table on index.html, but not the data for the coLivings-table. I had to add @JsonIgnore to the coLiving-relation in User.java ->     
@ManyToOne
@JoinColumn(name = "co_living_id")    
@JsonIgnore
private CoLiving coLiving;
But why?
new task -> trying to add the following to UserController.java :
@PostMapping
public User addUser(@RequestBody User user) {
    return userRepository.save(user);
}
-> didn't change anything -> trying to change the names in new_user.html to match the variables(?) in User.java -> didn't change anything -> I read the error-message in Intellij and figured that I were trying to add a new user with null values in not nullable spaces

06.11.2025:
I figured out why I couldn't register a user from the new_user.html. It was both that I used different names (first_name vs firstName), and that I used the same e-mail and telephone number several times, but these fields are "unique". Now it worked! Time to use the test codes and incorporate them in my actual project. Now there's no code (script) in my html-files that connects with the database.
Got the register-scheme for login.html file to work, but haven't started on the login-part. Continued with calendar.html instead since it uses the same functionality as registering. Problem fixed by adding @PostMapping in CalendarController.java:
    @PostMapping
    public Calendar addUser(@RequestBody Calendar event) {
        return userRepository.save(event); }
Now i'm going to add this to RoomController.java and CoLivingController.java as well. After that I will continue to work on create_coLiving.html.
I am now working on create_coLiving.html, but I think I have to find some way to automatically create a invite code when creating the coliving.

10.11.2025:
Plan/goal for today: Fix the problems with the join_coLiving.html + create/update profile.html to fulfill the CRUD requirements. Without session() functionality (in PHP) most of the functionalities in the webapplication doesn't do anything. Therefore I need to figuere out the Java equivalent for PHP session(). Important: privacy/sequrity, stay in the session even when refreshing or changing site. After this is completed I need to make the logout.html file where the session is ended.
